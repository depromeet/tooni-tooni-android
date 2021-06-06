/*
 * Created by Leo on 2021. 06. 06 ..
 */
package kr.tooni.tooni.features.more

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.functions.BiFunction
import io.reactivex.rxjava3.schedulers.Schedulers
import kr.tooni.tooni.base.BaseViewModel
import kr.tooni.tooni.core.extensions.EMPTY
import kr.tooni.tooni.core.model.User
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class MoreViewModel @Inject constructor(
    private val moreRepository: MoreRepository
) : BaseViewModel() {
    
    data class State(
        val nickname: String = User.EMPTY.nickname,
        val description: String = String.EMPTY,
        val profileImageUrl: String? = User.EMPTY.profileImage,
        val versionName: String = String.EMPTY
    )
    
    private val _state = MutableLiveData(State())
    val state: LiveData<State>
        get() = _state
    
    private val cachedState
        get() = _state.value ?: State()
    
    init {
        Single.zip(
            moreRepository.getUser().subscribeOn(Schedulers.io()),
            moreRepository.getVersionInfo().subscribeOn(Schedulers.io()),
            BiFunction { user, versionName ->
                cachedState.copy(nickname = User.EMPTY.nickname, versionName = versionName)
            }
        )
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(_state::setValue, Timber::e)
            .addDisposable()
    }
}
