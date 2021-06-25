package kr.tooni.tooni.features.author

import io.reactivex.rxjava3.core.Single
import kr.tooni.tooni.core.model.Authors
import kr.tooni.tooni.data.api.AuthorsApi
import retrofit2.Retrofit
import javax.inject.Inject

class AuthorDetailRemoteDataSource @Inject constructor(
    private val retrofit: Retrofit
) {
    //api call
    fun getAuthorTooni(): Single<List<Authors>> {
        return retrofit.create(AuthorsApi::class.java).getRecommendAuthor()
            .map { it.data.authors}
    }

}