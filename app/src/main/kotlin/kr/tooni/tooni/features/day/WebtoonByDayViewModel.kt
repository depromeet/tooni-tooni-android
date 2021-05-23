/*
 * Created by Leo on 2021. 05. 19 ..
 */
package kr.tooni.tooni.features.day

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import kr.tooni.tooni.base.BaseViewModel
import kr.tooni.tooni.core.model.Webtoon
import timber.log.Timber

class WebtoonByDayViewModel constructor(
    day: String, // inject from savedStateHandle
    private val webtoonByDayRepository: WebtoonByDayRepository = WebtoonByDayRepositoryImpl()
) : BaseViewModel() {
    
    private val _webtoons = MutableLiveData<List<Webtoon>>()
    val webtoons: LiveData<List<Webtoon>>
        get() = _webtoons
    
    init {
        webtoonByDayRepository.getWebtoonsByDay(day)
            .doOnError { throwable -> showSnackBar(throwable.message) }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(_webtoons::setValue, Timber::e)
            .addDisposable()
    }
}
