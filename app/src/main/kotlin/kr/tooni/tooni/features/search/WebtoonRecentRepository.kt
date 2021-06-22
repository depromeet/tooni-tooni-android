package kr.tooni.tooni.features.search

import android.content.Context
import android.content.Entity
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class WebtoonRecentRepository @Inject constructor(context: Context) {
    private var webtoonRecentDAO: WebtoonRecentDAO
    
    init {
        val database = AppDatabase.getDatabase(context)
        webtoonRecentDAO = database.recentDAO()
    }
    
    
    fun insertKeyword(keyword: String): Completable {
        val entity = WebtoonRecentEntity(recentSearch = keyword)
        return webtoonRecentDAO.insertAll(entity)
    }
    
    fun updateKeyword(webtoonRecentEntity: WebtoonRecentEntity): Completable {
        return webtoonRecentDAO.update(webtoonRecentEntity)
    }
    
    fun deleteKeyword(keyword: String): Completable {
        val entity = WebtoonRecentEntity(recentSearch = keyword)
        return webtoonRecentDAO.delete(entity)
    }
    
    fun getAll(): Single<List<WebtoonRecentEntity>> {
        return webtoonRecentDAO.getAll()
    }
}
