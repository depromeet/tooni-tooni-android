package kr.tooni.tooni.features.watch.recent.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kr.tooni.tooni.core.model.Webtoon

@Entity(tableName = "recent_webtoon_data_table")
data class RecentWebtoon (

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "recent_webtoon_id")
    var id : Int,

    @ColumnInfo(name = "webtoon")
    val webtoon: Webtoon

)