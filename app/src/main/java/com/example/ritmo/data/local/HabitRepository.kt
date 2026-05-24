package com.example.ritmo.data.local

import androidx.lifecycle.LiveData
import com.example.ritmo.model.Habit
import com.example.ritmo.model.HabitLog

class HabitRepository(private val habitDao: HabitDao) {

    val allHabits: LiveData<List<Habit>> = habitDao.getAllHabits()

    suspend fun insert(habit: Habit) {
        habitDao.insertHabit(habit)
    }

    suspend fun update(habit: Habit) {
        habitDao.updateHabit(habit)
    }

    suspend fun delete(habit: Habit) {
        habitDao.deleteHabit(habit)
    }

    suspend fun insertLog(habitLog: HabitLog) {
        habitDao.insertHabitLog(habitLog)
    }

    fun getLogsForHabit(habitId: Int): LiveData<List<HabitLog>> {
        return habitDao.getLogsForHabit(habitId)
    }

    suspend fun getLogForToday(habitId: Int, startOfDay: Long, endOfDay: Long): HabitLog? {
        return habitDao.getLogForToday(habitId, startOfDay, endOfDay)
    }
}