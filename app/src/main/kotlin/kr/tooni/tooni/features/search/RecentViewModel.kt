package kr.tooni.tooni.features.search

import android.app.Application
import androidx.lifecycle.MutableLiveData

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.observers.DisposableCompletableObserver
import io.reactivex.rxjava3.schedulers.Schedulers

class ViewModel(application: Application) {
    lateinit var recentRepository: RecentRepository
    fun insertKeyword(recentEntity: RecentEntity) {
        CompositeDisposable().add(recentRepository.insertKeyword(recentEntity)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe()
        )
    }
}
