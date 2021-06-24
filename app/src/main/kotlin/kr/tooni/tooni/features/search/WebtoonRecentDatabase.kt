package kr.tooni.tooni.features.search

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [WebtoonRecentEntity::class], version = 1)
abstract class WebtoonRecentDatabase : RoomDatabase() {
    abstract fun recentDAO(): WebtoonRecentDAO
    
    companion object {
        @Volatile
        private var INSTANCE: WebtoonRecentDatabase? = null
        
        fun getDatabase(context: Context): WebtoonRecentDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    WebtoonRecentDatabase::class.java,
                    "recent_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
