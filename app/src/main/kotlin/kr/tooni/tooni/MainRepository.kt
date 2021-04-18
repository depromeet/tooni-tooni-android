/*
 * Created by Leo on 2021. 04. 18 ..
 */
package kr.tooni.tooni

import io.reactivex.rxjava3.core.Single
import kr.tooni.tooni.model.Character

interface MainRepository {
    
    fun getAllCharacters(): Single<List<Character>>
}
