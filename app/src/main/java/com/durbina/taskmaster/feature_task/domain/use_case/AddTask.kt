package com.durbina.taskmaster.feature_task.domain.use_case

import com.durbina.taskmaster.feature_task.domain.model.InvalidTaskException
import com.durbina.taskmaster.feature_task.domain.model.Task
import com.durbina.taskmaster.feature_task.domain.repository.TaskRepository
import javax.inject.Inject

class AddTask(
    private val repository: TaskRepository
) {
    @Throws(InvalidTaskException::class)
    suspend operator fun invoke(task: Task) {
        if (task.title.isBlank() || task.description.isBlank()) {
            throw InvalidTaskException("The task title or description cannot be blank")
        }
        repository.insertTask(task)
    }
}