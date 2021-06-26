package kr.tooni.tooni.features.author

import io.reactivex.rxjava3.core.Single
import kr.tooni.tooni.core.model.Authors
import kr.tooni.tooni.core.model.Webtoon
import kr.tooni.tooni.data.api.AuthorsApi
import kr.tooni.tooni.data.api.ListApi
import retrofit2.Retrofit
import javax.inject.Inject

class AuthorDetailRemoteDataSource @Inject constructor(
    private val retrofit: Retrofit
) {
    //api call
    fun getAuthorTooni(id: Long): Single<List<Webtoon>> {
        return retrofit.create(ListApi::class.java).getWebtoonsByAuthor(id)
            .map { it.data.webtoons }
    }



}