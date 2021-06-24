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
    @Query("SELECT * FROM tb_recentKeyword order by id desc limit 10")
    fun getAll(): Single<List<WebtoonRecentEntity>>
    
    @Query("SELECT * FROM tb_recentKeyword WHERE id=:id ")
    fun getKeyword(id: Long): List<WebtoonRecentEntity>

    @Query("DELETE FROM tb_recentKeyword")
    fun deleteALLItem(): Completable

    @Query("DELETE FROM tb_recentKeyword WHERE recent_search =:keyword")
    fun deleteALLItem(keyword: String): Completable

    @Insert
    fun insertAll(vararg webtoonRecentEntity: WebtoonRecentEntity): Completable
    
    @Delete
    fun delete(webtoonRecentEntity: WebtoonRecentEntity): Completable
    
    @Update
    fun update(webtoonRecentEntity: WebtoonRecentEntity): Completable
}
