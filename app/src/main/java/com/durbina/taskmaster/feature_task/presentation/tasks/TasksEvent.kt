package com.durbina.taskmaster.feature_task.presentation.tasks

import com.durbina.taskmaster.feature_task.domain.model.Task

sealed class TasksEvent {
    data class OnDeleteTask(val task: Task): TasksEvent()
}