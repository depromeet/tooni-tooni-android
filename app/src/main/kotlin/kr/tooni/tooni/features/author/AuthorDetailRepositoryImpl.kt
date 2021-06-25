package kr.tooni.tooni.features.author

import io.reactivex.rxjava3.core.Single
import kr.tooni.tooni.core.model.Authors
import javax.inject.Inject

class AuthorDetailRepositoryImpl @Inject constructor(
    private val remoteDataSource: AuthorDetailRemoteDataSource
) : AuthorDetailRepository{
    override fun getAuthor(): Single<List<Authors>> {
        return remoteDataSource.getAuthorTooni()
        }
}