package kr.tooni.tooni.features.watch.recent.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(entities = [RecentWebtoon::class], version = 1)
@TypeConverters(RecentWebtoonConverters::class)
abstract class RecentWebtoonDatabase: RoomDatabase() {
    abstract fun recentWebtoonDAO(): RecentWebtoonDAO
}