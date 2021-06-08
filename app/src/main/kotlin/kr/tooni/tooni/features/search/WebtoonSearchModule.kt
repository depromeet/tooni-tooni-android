package kr.tooni.tooni.features.search

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import kr.tooni.tooni.data.api.ListApi
import retrofit2.Retrofit

@Module
@InstallIn(ViewModelComponent::class)
object WebtoonSearchModule {
    
    @Provides
    fun provideWebtoonRecentRepository(
        @ApplicationContext context: Context
    ): WebtoonRecentRepository = WebtoonRecentRepository(context)
    
    @Provides
    fun provideWebtoonSearchRepository(
        retrofit: Retrofit
    ): WebtoonSearchRepository = WebtoonSearchRepository(
        retrofit.create(ListApi::class.java)
    )
}
