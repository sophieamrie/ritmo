package com.example.ritmo.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.ritmo.data.local.RitmoDatabase
import com.example.ritmo.data.local.HabitRepository
import com.example.ritmo.model.Habit
import com.example.ritmo.model.HabitLog
import kotlinx.coroutines.launch
import java.sql.RowId

class HabitViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: HabitRepository
    val allHabits: LiveData<List<Habit>>

    init {
        val habitDao = RitmoDatabase.getDatabase(application).habitDao()
        repository = HabitRepository(habitDao)
        allHabits = repository.allHabits
    }

    fun insert(habit: Habit) = viewModelScope.launch {
        repository.insert(habit)
    }

    fun update(habit: Habit) = viewModelScope.launch {
        repository.update(habit)
    }

    fun delete(habit: Habit) = viewModelScope.launch {
        repository.delete(habit)
    }

    fun insertLog(habitLog: HabitLog) = viewModelScope.launch {
        repository.insertLog(habitLog)
    }

    fun getLogsForHabit(habitId: Int): LiveData<List<HabitLog>> {
        return repository.getLogsForHabit(habitId)
    }
}