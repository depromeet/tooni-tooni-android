package kr.tooni.tooni.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kr.tooni.tooni.data.ApiProvider
import kr.tooni.tooni.data.preference.Preference
import kr.tooni.tooni.data.preference.PreferenceImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    
    @Provides
    @Singleton
    fun providePreference(@ApplicationContext context: Context): Preference {
        return PreferenceImpl(context)
    }
    
    @Provides
    @Singleton
    fun provideApiProvider(): ApiProvider {
        return ApiProvider
    }
}
