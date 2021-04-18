/*
 * Created by Leo on 2021. 04. 18 ..
 */
package kr.tooni.tooni

import io.reactivex.rxjava3.core.Single
import kr.tooni.tooni.data.ApiProvider
import kr.tooni.tooni.data.api.MortyApi
import kr.tooni.tooni.model.Character

class MainRepositoryImpl : MainRepository {
    
    override fun getAllCharacters(): Single<List<Character>> {
        return ApiProvider.create(MortyApi::class.java).getAllCharacters()
            .map { response -> response.results }
    }
}
