package com.durbina.taskmaster.feature_task.data.repository

import com.durbina.taskmaster.feature_task.data.data_source.TaskDao
import com.durbina.taskmaster.feature_task.domain.model.Task
import com.durbina.taskmaster.feature_task.domain.repository.TaskRepository
import kotlinx.coroutines.flow.Flow

class TaskRepositoryImpl(private val taskDao: TaskDao): TaskRepository {
    override fun getTasks(): Flow<List<Task>> {
        return taskDao.getTasks()
    }

    override suspend fun insertTask(task: Task) {
        taskDao.insertTask(task)
    }

    override suspend fun deleteNote(task: Task) {
        taskDao.deleteNote(task)
    }

}
