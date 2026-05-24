package com.example.ritmo.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.ritmo.model.Habit
import com.example.ritmo.model.HabitLog
import com.example.ritmo.model.Task

@Database(
    entities = [Task::class, Habit::class, HabitLog::class],
    version = 1,
    exportSchema = false
)

abstract class RitmoDatabase : RoomDatabase() {

    abstract fun taskDao(): TaskDao
    abstract fun habitDao(): HabitDao

    companion object {
        @Volatile
        private var INSTANCE: RitmoDatabase? = null

        fun getDatabase(context:Context): RitmoDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    RitmoDatabase::class.java,
                    "ritmo_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}