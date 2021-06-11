package kr.tooni.tooni.features.home

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import kr.tooni.tooni.di.SchedulerProvider

@Module
@InstallIn(ViewModelComponent::class)
object HomeModule {
    
    @Provides
    fun provideHomeRepository(
        remoteDataSource: HomeRemoteDataSource,
        schedulerProvider: SchedulerProvider
    ): HomeRepository = HomeRepositoryImpl(remoteDataSource, schedulerProvider)
}
