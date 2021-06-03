package kr.tooni.tooni.features.search

import android.app.Application
import io.reactivex.rxjava3.core.Completable

class WebtoonRecentRepository(application: Application) {
    private var webtoonRecentDAO: WebtoonRecentDAO

    init{
        val database = AppDatabase.getDatabase(application)
        webtoonRecentDAO = database.RecentDAO()
    }

    fun insertKeyword(webtoonRecentEntity: WebtoonRecentEntity): Completable { return webtoonRecentDAO.insertAll(webtoonRecentEntity)}
    fun updateKeyword(webtoonRecentEntity: WebtoonRecentEntity): Completable { return webtoonRecentDAO.update(webtoonRecentEntity)}
    fun deleteKeyword(webtoonRecentEntity: WebtoonRecentEntity): Completable { return webtoonRecentDAO.delete(webtoonRecentEntity)}
}