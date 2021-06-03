package kr.tooni.tooni.features.search

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import io.reactivex.rxjava3.core.Completable
import retrofit2.http.DELETE

@Dao
interface WebtoonRecentDAO {
    @Query("SELECT * FROM tb_recentKeyword")
    fun getAll(): List<WebtoonRecentEntity>

    @Query("SELECT recent_search FROM tb_recentKeyword WHERE id=:id")
    fun getKeyword(id: String): List<WebtoonRecentEntity>

    @Insert
    fun insertAll(vararg webtoonRecentEntity: WebtoonRecentEntity): Completable

    @DELETE
    fun delete(webtoonRecentEntity: WebtoonRecentEntity): Completable

    @Update
    fun update(webtoonRecentEntity: WebtoonRecentEntity): Completable
}