package com.durbina.taskmaster.feature_task.domain.repository

import com.durbina.taskmaster.feature_task.domain.model.Task
import kotlinx.coroutines.flow.Flow

interface TaskRepository {
    fun getTasks(): Flow<List<Task>>

    suspend fun insertTask(task: Task)

    suspend fun deleteNote(task: Task)
}