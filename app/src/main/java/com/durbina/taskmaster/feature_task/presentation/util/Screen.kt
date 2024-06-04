package com.durbina.taskmaster.feature_task.presentation.util

sealed class Screen(val route: String) {
    data object TaskScreen: Screen("tasks_screen")
    data object AddEditTaskScreen: Screen("add_edit_task_screen")
}