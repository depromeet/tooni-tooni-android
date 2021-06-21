package kr.tooni.tooni.features.top20

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object Top20Module {
    @Provides
    fun provideTop20Repository(
        remoteDataSource: Top20RemoteDataSource
    ) : Top20Repository = Top20RepositoryImpl(remoteDataSource)
}