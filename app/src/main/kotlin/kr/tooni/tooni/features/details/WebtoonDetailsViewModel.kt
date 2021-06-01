/*
 * Created by Leo on 2021. 05. 23 ..
 */
package kr.tooni.tooni.features.details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import kr.tooni.tooni.base.BaseViewModel
import kr.tooni.tooni.core.model.WebtoonDetails
import timber.log.Timber

class WebtoonDetailsViewModel constructor(
    webtoonId: Long,
    private val webtoonDetailsRepository: WebtoonDetailsRepository = WebtoonDetailsRepositoryImpl()
) : BaseViewModel() {
    
    private val _webtoonDetails = MutableLiveData(WebtoonDetails.EMPTY)
    val webtoonDetails: LiveData<WebtoonDetails>
        get() = _webtoonDetails
    
    init {
        webtoonDetailsRepository.getWebtoonDetails(webtoonId)
            .doOnSuccess { details -> Timber.e("--- details: $details") }
            .doOnError { throwable -> showSnackBar(throwable.message) }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(_webtoonDetails::setValue, Timber::e)
            .addDisposable()
    }
}
