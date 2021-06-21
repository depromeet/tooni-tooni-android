package kr.tooni.tooni.features.top20

import io.reactivex.rxjava3.core.Single
import kr.tooni.tooni.core.model.Webtoon
import javax.inject.Inject

class Top20RepositoryImpl @Inject constructor(
    private val remoteDataSource: Top20RemoteDataSource
) : Top20Repository {

    override fun getTop20(): Single<List<Webtoon>> {
        return remoteDataSource.getTop20()
    }
}