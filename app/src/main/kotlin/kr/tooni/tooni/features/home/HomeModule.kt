package kr.tooni.tooni.features.home

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import kr.tooni.tooni.di.SchedulersProvider
import retrofit2.Retrofit

@Module
@InstallIn(ViewModelComponent::class)
object HomeModule {
    
    @Provides
    fun provideHomeRepository(
        remoteDataSource: HomeRemoteDataSource
    ): HomeRepository = HomeRepositoryImpl(remoteDataSource)
    
    @Provides
    fun provideHomeRemoteDataSource(
        retrofit: Retrofit,
        schedulersProvider: SchedulersProvider
    ): HomeRemoteDataSource {
        return HomeRemoteDataSource(retrofit, schedulersProvider)
    }
}
