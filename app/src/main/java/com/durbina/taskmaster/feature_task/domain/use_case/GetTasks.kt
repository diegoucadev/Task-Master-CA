package com.durbina.taskmaster.feature_task.domain.use_case

import com.durbina.taskmaster.feature_task.domain.model.Task
import com.durbina.taskmaster.feature_task.domain.repository.TaskRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetTasks(
    private val repository: TaskRepository
) {
    operator fun invoke(): Flow<List<Task>> {
        return repository.getTasks()
    }
}