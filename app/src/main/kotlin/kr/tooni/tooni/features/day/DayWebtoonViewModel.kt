/*
 * Created by Leo on 2021. 05. 19 ..
 */
package kr.tooni.tooni.features.day

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import kr.tooni.tooni.base.BaseViewModel
import kr.tooni.tooni.data.ApiProvider
import kr.tooni.tooni.data.api.ListApi
import timber.log.Timber

class DayWebtoonViewModel : BaseViewModel() {
    
    init {
        ApiProvider.create(ListApi::class.java).search("조석")
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
               // do something
            }, Timber::e)
            .addDisposable()
    }
}
