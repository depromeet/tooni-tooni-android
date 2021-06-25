package kr.tooni.tooni.features.author

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import kr.tooni.tooni.data.api.AuthorsApi
import retrofit2.Retrofit

@Module
@InstallIn(ViewModelComponent::class)
object AuthorDetailModule {

    @Provides
    fun provideAuthorsApi(retrofit: Retrofit): AuthorsApi {
        return retrofit.create(AuthorsApi::class.java)
    }
}

