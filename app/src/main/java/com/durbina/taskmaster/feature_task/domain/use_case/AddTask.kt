package com.durbina.taskmaster.feature_task.domain.use_case

import com.durbina.taskmaster.feature_task.domain.model.Task
import com.durbina.taskmaster.feature_task.domain.repository.TaskRepository

class AddTask(
    private val repository: TaskRepository
) {
    suspend operator fun invoke(task: Task) {
        repository.insertTask(task)
    }
}