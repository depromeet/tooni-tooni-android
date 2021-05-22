/*
 * Created by Leo on 2021. 04. 17 ..
 */
package kr.tooni.tooni.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.disposables.Disposable

abstract class BaseViewModel : ViewModel() {

    private val compositeDisposable = CompositeDisposable()
    
    private val _snackBarMessage = MutableLiveData<String>()
    val snackBarMessage: LiveData<String>
        get() = _snackBarMessage
    
    override fun onCleared() {
        compositeDisposable.clear()
        super.onCleared()
    }
    
    protected fun showSnackBar(message: String?) {
        _snackBarMessage.postValue(message.toString())
    }

    fun Disposable.addDisposable() = compositeDisposable.add(this)
}
