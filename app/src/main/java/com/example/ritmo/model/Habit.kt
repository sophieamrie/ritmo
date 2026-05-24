package com.example.ritmo.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "habits")
data class Habit(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val title: String,
    val description: String = "",
    val iconEmoji: String = "⭐",
    val currentStreak: Int = 0,
    val longestStreak: Int = 0,
    val lastCompleteDate: Long? = null,
    val createdAt: Long = System.currentTimeMillis()
)
