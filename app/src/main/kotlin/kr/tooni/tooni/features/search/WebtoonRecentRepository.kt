package kr.tooni.tooni.features.search

import android.content.Context
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class WebtoonRecentRepository @Inject constructor(context: Context) {
    private var webtoonRecentDAO: WebtoonRecentDAO
    
    init {
        val database = WebtoonRecentDatabase.getDatabase(context)
        webtoonRecentDAO = database.recentDAO()
    }

    fun insertKeyword(keyword: String): Completable {
        val entity = WebtoonRecentEntity(keyword = keyword)
        return webtoonRecentDAO.insertAll(entity)
    }
    
    fun deleteKeyword(keyword: String): Completable {
        val entity = WebtoonRecentEntity(keyword = keyword)
        return webtoonRecentDAO.delete(entity)
    }
    
    fun getAll(): Single<List<WebtoonRecentEntity>> {
        return webtoonRecentDAO.getAll()
    }
}
