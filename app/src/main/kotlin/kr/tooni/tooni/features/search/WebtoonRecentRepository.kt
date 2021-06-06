package kr.tooni.tooni.features.search

import android.app.Application
import android.content.Context
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Observable

class WebtoonRecentRepository(context: Context) {
    private var webtoonRecentDAO: WebtoonRecentDAO

    init{
        val database = AppDatabase.getDatabase(context)
        webtoonRecentDAO = database.RecentDAO()
    }


    fun insertKeyword(webtoonRecentEntity: WebtoonRecentEntity): Completable { return webtoonRecentDAO.insertAll(webtoonRecentEntity)}
    fun updateKeyword(webtoonRecentEntity: WebtoonRecentEntity): Completable { return webtoonRecentDAO.update(webtoonRecentEntity)}
    fun deleteKeyword(webtoonRecentEntity: WebtoonRecentEntity): Completable { return webtoonRecentDAO.delete(webtoonRecentEntity)}
}