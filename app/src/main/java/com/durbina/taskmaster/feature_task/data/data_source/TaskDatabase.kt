package com.durbina.taskmaster.feature_task.data.data_source

import androidx.room.Database
import com.durbina.taskmaster.feature_task.domain.model.Task

@Database(
    entities = [Task::class],
    version = 1
)
abstract class TaskDatabase {
    abstract val taskDao: TaskDao
}