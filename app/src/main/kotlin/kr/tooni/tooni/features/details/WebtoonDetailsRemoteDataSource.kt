/*
 * Created by Leo on 2021. 05. 23 ..
 */
package kr.tooni.tooni.features.details

import io.reactivex.rxjava3.core.Single
import kr.tooni.tooni.core.model.WebtoonDetails
import kr.tooni.tooni.data.ApiProvider
import kr.tooni.tooni.data.api.DetailsApi

class WebtoonDetailsRemoteDataSource constructor(private val apiProvider: ApiProvider = ApiProvider) {
    
    fun getWebtoonDetails(id: Long): Single<WebtoonDetails> {
        return apiProvider.create(DetailsApi::class.java).getWebtoonDetails(id)
            .map { response -> response.data.toDetails() }
    }
}
