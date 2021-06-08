package kr.tooni.tooni.features.search

import androidx.room.*
import io.reactivex.rxjava3.core.Completable

@Dao
interface WebtoonRecentDAO {
    @Query("SELECT * FROM tb_recentKeyword")
    fun getAll(): List<WebtoonRecentEntity>
    
    @Query("SELECT * FROM tb_recentKeyword WHERE id=:id")
    fun getKeyword(id: Long): List<WebtoonRecentEntity>
    
    @Insert
    fun insertAll(vararg webtoonRecentEntity: WebtoonRecentEntity): Completable
    
    @Delete
    fun delete(webtoonRecentEntity: WebtoonRecentEntity): Completable
    
    @Update
    fun update(webtoonRecentEntity: WebtoonRecentEntity): Completable
}
