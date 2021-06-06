package kr.tooni.tooni.features.watch.favorites.db

import androidx.room.TypeConverter
import com.google.gson.Gson
import kr.tooni.tooni.core.model.Author
import kr.tooni.tooni.core.model.Webtoon

class FavoritesConverters {

    // Webtoon Converter
    @TypeConverter
    fun webtoonToList(value: Webtoon) = Gson().toJson(value)

    @TypeConverter
    fun listToWebtoon(value: String) = Gson().fromJson(value, Webtoon::class.java) as Webtoon

}