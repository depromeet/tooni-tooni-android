package kr.tooni.tooni.features.recommend

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import kr.tooni.tooni.data.api.ListApi
import retrofit2.Retrofit

@Module
@InstallIn(ViewModelComponent::class)
object WebtoonByGenreModule {
    
    @Provides
    fun provideWebtoonByGenreRepository(
        remoteDataSource: WebtoonByGenreRemoteDataSource
    ): WebtoonByGenreRepository = WebtoonByGenreRepositoryImpl(remoteDataSource)

//    @Provides
//    fun provideListApi(retrofit: Retrofit): ListApi {
//        return retrofit.create(ListApi::class.java)
//    }
}
