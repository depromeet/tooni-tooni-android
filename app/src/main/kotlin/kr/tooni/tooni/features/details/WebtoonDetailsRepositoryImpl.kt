/*
 * Created by Leo on 2021. 05. 23 ..
 */
package kr.tooni.tooni.features.details

import io.reactivex.rxjava3.core.Single
import kr.tooni.tooni.core.model.WebtoonDetails

class WebtoonDetailsRepositoryImpl constructor(
    private val remoteDataSource: WebtoonDetailsRemoteDataSource = WebtoonDetailsRemoteDataSource()
) : WebtoonDetailsRepository {
    
    override fun getWebtoonDetails(id: Long): Single<WebtoonDetails> {
        return remoteDataSource.getWebtoonDetails(id)
    }
}
