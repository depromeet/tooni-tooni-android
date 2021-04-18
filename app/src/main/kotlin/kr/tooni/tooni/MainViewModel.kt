/*
 * Created by Leo on 2021. 04. 17 ..
 */
package kr.tooni.tooni

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import kr.tooni.tooni.base.BaseViewModel
import kr.tooni.tooni.model.Character

class MainViewModel(
    private val mainRepository: MainRepository = MainRepositoryImpl()
) : BaseViewModel() {
    
    private val _characters = MutableLiveData<List<Character>>()
    val characters: LiveData<List<Character>>
        get() = _characters
    
    init {
        mainRepository.getAllCharacters()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(_characters::setValue)
            .addDisposable()
    }
}
