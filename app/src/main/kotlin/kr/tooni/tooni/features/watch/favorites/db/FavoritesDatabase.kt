package kr.tooni.tooni.features.watch.favorites.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import kr.tooni.tooni.watch.favorites.db.FavoritesDAO

@Database(entities = [Favorites::class], version = 1)
@TypeConverters(FavoritesConverters::class)
abstract class FavoritesDatabase : RoomDatabase() {

    abstract val favoritesDAO : FavoritesDAO

    companion object {
        @Volatile
        private var INSTANCE : FavoritesDatabase? = null
        fun getInstance(context: Context) : FavoritesDatabase {
            synchronized(this) {
                var instance : FavoritesDatabase? = INSTANCE
                if(instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        FavoritesDatabase::class.java,
                        "favorites_data_database"
                    ).build()
                }
                return instance
            }
        }
    }
}