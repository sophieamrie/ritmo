package com.example.ritmo.data.local

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.ritmo.model.Habit
import com.example.ritmo.model.HabitLog

@Dao
interface HabitDao {

    @Query("SELECT * FROM habits ORDER BY createdAt DESC")
    fun getAllHabits(): LiveData<List<Habit>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertHabit(habit: Habit)

    @Update
    suspend fun updateHabit(habit: Habit)

    @Delete
    suspend fun deleteHabit(habit: Habit)

    @Insert
    suspend fun insertHabitLog(habitLog: HabitLog)

    @Query("SELECT * FROM habit_logs WHERE habitId = :habitId ORDER BY completedDate DESC")
    fun getLogsForHabit(habitId: Int): LiveData<List<HabitLog>>

    @Query("SELECT * FROM habit_logs WHERE habitId = :habitId AND completedDate >= :startOfDay AND completedDate <= :endOfDay LIMIT 1")
    suspend fun getLogForToday(habitId: Int, startOfDay: Long, endOfDay: Long): HabitLog?
}