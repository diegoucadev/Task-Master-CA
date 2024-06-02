package com.durbina.taskmaster.feature_task.presentation.add_edit_task

data class AddEditTaskState(
    var task: String = "",
    var description: String = "",
    var icon: String = "Default",
    var category: String = "Miscellaneous",
    var isExpanded: Boolean = false
)