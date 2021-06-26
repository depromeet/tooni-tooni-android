package kr.tooni.tooni.features.author

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import kr.tooni.tooni.data.api.ListApi
import retrofit2.Retrofit

@Module
@InstallIn(ViewModelComponent::class)
object AuthorDetailModule {

    @Provides
    fun provideListApi(retrofit: Retrofit): ListApi {
        return retrofit.create(ListApi::class.java)
    }

    @Provides
    fun provideAuthorDetailRepository(
        remoteDataSource: AuthorDetailRemoteDataSource
    ): AuthorDetailRepository = AuthorDetailRepositoryImpl(remoteDataSource)

}

