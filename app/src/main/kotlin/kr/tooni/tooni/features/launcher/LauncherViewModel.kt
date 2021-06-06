/*
 * Created by Leo on 2021. 06. 06 ..
 */
package kr.tooni.tooni.features.launcher

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single
import kr.tooni.tooni.base.BaseViewModel
import kr.tooni.tooni.core.extensions.applySchedulers
import timber.log.Timber
import java.util.concurrent.TimeUnit
import javax.inject.Inject

@HiltViewModel
class LauncherViewModel @Inject constructor(
    private val launcherRepository: LauncherRepository
) : BaseViewModel() {
    
    sealed class State {
        object Success : State()
        data class Error(val errorMessage: String) : State()
    }
    
    private val _state = MutableLiveData<State>()
    val state: LiveData<State>
        get() = _state
    
    init {
        launcherRepository.signInAnonymously()
            .map { State.Success }
            .ofType(State::class.java)
            .onErrorReturn { throwable -> State.Error(throwable.message.toString()) }
            .applySchedulers()
            .subscribe(_state::setValue, Timber::e)
            .addDisposable()
    }
}
