package kr.tooni.tooni.features.search

import android.app.Application
import io.reactivex.rxjava3.core.Completable

class RecentRepository(application: Application) {
    private var recentDAO: RecentDAO

    init{
        val database = AppDatabase.getDatabase(application)
        recentDAO = database.RecentDAO()
    }

    fun insertKeyword(recentEntity: RecentEntity): Completable { return recentDAO.insertAll(recentEntity)}
    fun updateKeyword(recentEntity: RecentEntity): Completable { return recentDAO.update(recentEntity)}
    fun deleteKeyword(recentEntity: RecentEntity): Completable { return recentDAO.delete(recentEntity)}
}