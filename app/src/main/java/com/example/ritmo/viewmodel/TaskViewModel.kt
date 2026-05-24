package com.example.ritmo.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.ritmo.data.local.RitmoDatabase
import com.example.ritmo.data.local.TaskRepository
import com.example.ritmo.model.Task
import kotlinx.coroutines.launch

class TaskViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: TaskRepository
    val allTasks: LiveData<List<Task>>
    val activeTasks: LiveData<List<Task>>

    init {
        val taskDao = RitmoDatabase.getDatabase(application).taskDao()
        repository = TaskRepository(taskDao)
        allTasks = repository.allTasks
        activeTasks = repository.activeTasks
    }

    fun insert(task: Task) = viewModelScope.launch {
        repository.insert(task)
    }

    fun update(task: Task) = viewModelScope.launch {
        repository.update(task)
    }

    fun delete(task: Task) = viewModelScope.launch {
        repository.delete(task)
    }

    fun updateCompletion(taskId: Int, isCompleted: Boolean) = viewModelScope.launch {
        repository.updateCompletion(taskId, isCompleted)
    }
}
