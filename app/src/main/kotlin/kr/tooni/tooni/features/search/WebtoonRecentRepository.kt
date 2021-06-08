package kr.tooni.tooni.features.search

import android.content.Context
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class WebtoonRecentRepository @Inject constructor(context: Context) {
    private var webtoonRecentDAO: WebtoonRecentDAO
    
    init {
        val database = AppDatabase.getDatabase(context)
        webtoonRecentDAO = database.recentDAO()
    }
    
    
    fun insertKeyword(webtoonRecentEntity: WebtoonRecentEntity): Completable {
        return webtoonRecentDAO.insertAll(webtoonRecentEntity)
    }
    
    fun updateKeyword(webtoonRecentEntity: WebtoonRecentEntity): Completable {
        return webtoonRecentDAO.update(webtoonRecentEntity)
    }
    
    fun deleteKeyword(webtoonRecentEntity: WebtoonRecentEntity): Completable {
        return webtoonRecentDAO.delete(webtoonRecentEntity)
    }
    
    fun getAll(): Single<List<WebtoonRecentEntity>> {
        return Single.fromCallable { webtoonRecentDAO.getAll() }
    }
}
