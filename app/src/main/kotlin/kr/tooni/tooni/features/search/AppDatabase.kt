package kr.tooni.tooni.features.search

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [WebtoonRecentEntity::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun RecentDAO(): WebtoonRecentDAO

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "recent_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}