package kr.tooni.tooni.features.watch.favorites.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kr.tooni.tooni.core.model.Webtoon

@Entity(tableName = "favorites_data_table")
data class Favorites (

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "favorites_webtoon_id")
    var id : Int,

    @ColumnInfo(name = "webtoon")
    val webtoon: Webtoon

)
