package com.durbina.taskmaster.feature_task.data.repository

import com.durbina.taskmaster.feature_task.data.data_source.dummyTasks
import com.durbina.taskmaster.feature_task.domain.model.Task
import com.durbina.taskmaster.feature_task.domain.repository.TaskRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class DummyRepoImpl(private var dummyData: MutableList<Task>): TaskRepository {
    override fun getTasks(): Flow<List<Task>> = flow {
        emit(dummyData)
    }

    override suspend fun insertTask(task: Task) {
        dummyData.add(task)
    }

    override suspend fun deleteTask(task: Task) {
        TODO("Not yet implemented")
    }

}