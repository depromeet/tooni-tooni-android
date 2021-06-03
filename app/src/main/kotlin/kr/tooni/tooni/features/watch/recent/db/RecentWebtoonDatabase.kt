package kr.tooni.tooni.features.watch.recent.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(entities = [RecentWebtoon::class], version = 1)
@TypeConverters(RecentWebtoonConverters::class)
abstract class RecentWebtoonDatabase: RoomDatabase() {

    abstract val recentWebtoonDAO: RecentWebtoonDAO

    companion object {
        private var INSTANCE : RecentWebtoonDatabase? = null
        fun getInstance(context: Context) : RecentWebtoonDatabase {
            synchronized(this) {
                var instance = INSTANCE
                if(instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        RecentWebtoonDatabase::class.java,
                        "recent_webtoom_data_database"
                    ).build()
                }
                return instance
            }
        }
    }
}