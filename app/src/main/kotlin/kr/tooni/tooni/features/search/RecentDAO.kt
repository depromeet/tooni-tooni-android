package kr.tooni.tooni.features.search

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import io.reactivex.rxjava3.core.Completable
import retrofit2.http.DELETE

@Dao
interface RecentDAO {
    @Query("SELECT * FROM tb_recentKeyword")
    fun getAll(): List<RecentEntity>

    @Query("SELECT recent_search FROM tb_recentKeyword WHERE id=:id")
    fun getKeyword(id: String): List<RecentEntity>

    @Insert
    fun insertAll(vararg recentEntity: RecentEntity): Completable

    @DELETE
    fun delete(recentEntity: RecentEntity): Completable

    @Update
    fun update(recentEntity: RecentEntity): Completable
}