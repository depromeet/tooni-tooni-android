package kr.tooni.tooni.features.search

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tb_recentKeyword")
data class WebtoonRecentEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    @ColumnInfo(name = "recent_search") val recentSearch: String
)

