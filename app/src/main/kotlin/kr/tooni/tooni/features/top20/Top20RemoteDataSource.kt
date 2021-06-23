package kr.tooni.tooni.features.top20

import io.reactivex.rxjava3.core.Single
import kr.tooni.tooni.core.model.Webtoon
import kr.tooni.tooni.data.api.ListApi
import retrofit2.Retrofit
import javax.inject.Inject

class Top20RemoteDataSource @Inject constructor(
    private val retrofit: Retrofit
) {
    //api call
    fun getTop20(): Single<List<Webtoon>> {
        return retrofit.create(ListApi::class.java).getRandomWebtoons()
            .map {it.data.webtoons}
    }
}