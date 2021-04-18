/*
 * Created by Leo on 2021. 04. 18 ..
 */
package kr.tooni.tooni.data

import com.google.gson.FieldNamingPolicy
import com.google.gson.GsonBuilder
import kr.tooni.tooni.BuildConfig
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object ApiProvider {
    
    private const val TIMEOUT_READ: Long = 15L
    private const val TIMEOUT_CONNECT: Long = 15L
    private const val TIMEOUT_WRITE: Long = 15L
    
    private const val baseUrl: String = BuildConfig.BASE_URL
    
    private val okHttpClient by lazy {
        OkHttpClient.Builder()
            .readTimeout(TIMEOUT_READ, TimeUnit.SECONDS)
            .connectTimeout(TIMEOUT_CONNECT, TimeUnit.SECONDS)
            .writeTimeout(TIMEOUT_WRITE, TimeUnit.SECONDS)
            .build()
    }
    
    private val gson by lazy {
        GsonBuilder()
            .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
            .create()
    }
    
    private fun provide(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .build()
    }
    
    fun <T> create(service: Class<T>): T {
        return provide().create(service)
    }
}
