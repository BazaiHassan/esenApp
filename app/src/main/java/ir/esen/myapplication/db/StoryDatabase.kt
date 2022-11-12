package ir.esen.myapplication.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import ir.esen.myapplication.data.ResponseStories

@Database(entities = [ResponseStories::class], version = 1)
abstract class StoryDatabase : RoomDatabase() {
    abstract fun getStoryDao(): StoryDao

    companion object {
        @Volatile
        private var instance: StoryDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK){
            // every thing in this block of code can be accessed by other threads in the same time
            // Below code tells: if there is no instance of db let's make one.
            instance ?: createDatabase(context).also{ instance = it }
        }

        private fun createDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                StoryDatabase::class.java,
                "story_db.db"
            ).build()
    }


}