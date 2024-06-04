package com.durbina.taskmaster.feature_task.presentation.tasks

import com.durbina.taskmaster.feature_task.domain.model.Task

data class TaskState(
    var tasks: List<Task> = emptyList()
)