package kr.tooni.tooni.features.author

import io.reactivex.rxjava3.core.Single
import kr.tooni.tooni.core.model.Authors


interface AuthorDetailRepository  {
    fun getAuthor(): Single<List<Authors>>
}