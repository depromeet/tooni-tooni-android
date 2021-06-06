package kr.tooni.tooni.features.more

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object MoreModule {
    
    @Provides
    fun provideMoreRepository(
        localDataSource: MoreLocalDataSource
    ): MoreRepository = MoreRepositoryImpl(localDataSource)
}
