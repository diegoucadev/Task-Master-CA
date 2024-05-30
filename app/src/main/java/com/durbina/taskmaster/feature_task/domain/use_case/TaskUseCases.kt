package com.durbina.taskmaster.feature_task.domain.use_case

data class TaskUseCases(
    val addTask: AddTask,
    val deleteTask: DeleteTask,
    val getTasks: GetTasks
)
