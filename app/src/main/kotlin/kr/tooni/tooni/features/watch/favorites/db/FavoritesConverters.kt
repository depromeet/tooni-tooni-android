package kr.tooni.tooni.features.watch.favorites.db

import androidx.room.TypeConverter
import com.google.gson.Gson
import kr.tooni.tooni.core.model.Author

class FavoritesConverters {
    // Authors converter
    @TypeConverter
    fun authorToList(value: List<Author>) = Gson().toJson(value)

    @TypeConverter
    fun listToAuthor(value: String) = Gson().fromJson(value, Array<Author>::class.java).toList()

    // Genres converter
    @TypeConverter
    fun listToJson(value: List<String>?) = Gson().toJson(value)

    @TypeConverter
    fun jsonToList(value: String) = Gson().fromJson(value, Array<String>::class.java).toList()
}