package kr.tooni.tooni.di

import android.content.Context
import com.chuckerteam.chucker.api.ChuckerCollector
import com.chuckerteam.chucker.api.ChuckerInterceptor
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.schedulers.Schedulers
import kr.tooni.tooni.BuildConfig
import kr.tooni.tooni.core.StringKeySet
import kr.tooni.tooni.data.preference.Preference
import kr.tooni.tooni.data.preference.PreferenceImpl
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import timber.log.Timber
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    
    private const val TIMEOUT_READ: Long = 15L
    private const val TIMEOUT_CONNECT: Long = 15L
    private const val TIMEOUT_WRITE: Long = 15L
    
    @Provides
    @Singleton
    fun providePreference(
        @ApplicationContext context: Context,
        gson: Gson
    ): Preference {
        return PreferenceImpl(context, gson)
    }
    
    @Provides
    @Singleton
    @Named(StringKeySet.BASE_URL)
    fun provideBaseUrl(): String {
        return BuildConfig.BASE_URL
    }
    
    @Provides
    @Singleton
    @Named(StringKeySet.VERSION_NAME)
    fun provideVersionName(): String {
        return BuildConfig.VERSION_NAME
    }
    
    @Provides
    @Singleton
    fun provideGson(): Gson {
        return GsonBuilder().create()
    }
    
    @Provides
    @Singleton
    fun provideChuckerInterceptor(@ApplicationContext context: Context): ChuckerInterceptor {
        return ChuckerInterceptor.Builder(context)
            .collector(ChuckerCollector(context))
            .alwaysReadResponseBody(true)
            .build()
    }
    
    @Provides
    fun okHttpClient(
        preference: Preference,
        chuckerInterceptor: ChuckerInterceptor
    ): OkHttpClient {
        val interceptor = Interceptor { chain ->
            val builder = chain.request()
                .newBuilder()
                .header(StringKeySet.AUTHORIZATION, "${StringKeySet.BEARER} ${preference.uid}")
            
            chain.proceed(builder.build())
        }
        
        return OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .also { builder ->
                if (BuildConfig.DEBUG) {
                    builder.addInterceptor(chuckerInterceptor)
                }
            }
            .readTimeout(TIMEOUT_READ, TimeUnit.SECONDS)
            .connectTimeout(TIMEOUT_CONNECT, TimeUnit.SECONDS)
            .writeTimeout(TIMEOUT_WRITE, TimeUnit.SECONDS)
            .build()
    }
    
    @Provides
    @Singleton
    fun provideRetrofit(
        @Named(StringKeySet.BASE_URL) baseUrl: String,
        okHttpClient: OkHttpClient,
        gson: Gson
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .build()
    }
    
    @Provides
    @Singleton
    fun provideSchedulerProvider(): SchedulerProvider {
        return object : SchedulerProvider {
            override fun newThread(): Scheduler {
                return Schedulers.newThread()
            }
    
            override fun io(): Scheduler {
                return Schedulers.io()
            }
    
            override fun computation(): Scheduler {
                return Schedulers.computation()
            }
    
            override fun main(): Scheduler {
                return AndroidSchedulers.mainThread()
            }
        }
    }
}
