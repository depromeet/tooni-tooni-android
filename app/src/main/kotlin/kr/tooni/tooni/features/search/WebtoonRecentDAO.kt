package kr.tooni.tooni.features.search

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single

@Dao
interface WebtoonRecentDAO {
    @Query("SELECT * FROM tb_recentKeyword")
    fun getAll(): Single<List<WebtoonRecentEntity>>
    
    @Query("SELECT * FROM tb_recentKeyword WHERE id=:id")
    fun getKeyword(id: Long): List<WebtoonRecentEntity>
    
    @Insert
    fun insertAll(vararg webtoonRecentEntity: WebtoonRecentEntity): Completable
    
    @Delete
    fun delete(webtoonRecentEntity: WebtoonRecentEntity): Completable
    
    @Update
    fun update(webtoonRecentEntity: WebtoonRecentEntity): Completable
}
