package kr.tooni.tooni.features.watch.favorites

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kr.tooni.tooni.core.model.Author

@Entity(tableName = "favorites_data_table")
data class Favorites (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "favorites_id")
    var id : Int,

    @ColumnInfo(name = "favorites_site")
    var site: String,

    @ColumnInfo(name = "favorites_title")
    var title: String,

    @ColumnInfo(name = "favorites_authors")
    var authors : List<Author>,

    @ColumnInfo(name = "favorites_thumbnail")
    var thumbnail: String,

    @ColumnInfo(name = "favorites_score")
    var score: Double,

    @ColumnInfo(name = "favorites_genres")
    var genres : List<String>
)
