package com.durbina.taskmaster.feature_task.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Task(
    @PrimaryKey val id: Int? = null,
    var title: String,
    var description: String,
    var category: String
)
