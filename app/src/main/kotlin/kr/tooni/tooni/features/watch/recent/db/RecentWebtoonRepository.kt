package kr.tooni.tooni.features.watch.recent.db

class RecentWebtoonRepository(private val dao: RecentWebtoonDAO) {

    val recentWebtoons = dao.getAllRecentWebtoons()

    suspend fun insert(recentWebtoon: RecentWebtoon): Long {
        return dao.insertRecentWebtoon(recentWebtoon)
    }

    suspend fun update(recentWebtoon: RecentWebtoon): Int {
        return dao.updateRecentWebtoon(recentWebtoon)
    }

    suspend fun delete(recentWebtoon: RecentWebtoon): Int {
        return dao.deleteRecentWebtoon(recentWebtoon)
    }

    suspend fun deleteAll(): Int {
        return dao.deleteAllRecentWebtoon()
    }
}