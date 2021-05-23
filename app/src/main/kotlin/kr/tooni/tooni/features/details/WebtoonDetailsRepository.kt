/*
 * Created by Leo on 2021. 05. 23 ..
 */
package kr.tooni.tooni.features.details

import io.reactivex.rxjava3.core.Single
import kr.tooni.tooni.core.model.WebtoonDetails

interface WebtoonDetailsRepository {
    fun getWebtoonDetails(id: Long): Single<WebtoonDetails>
}
