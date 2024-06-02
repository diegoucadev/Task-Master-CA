package com.durbina.taskmaster.feature_task.presentation.add_edit_task

sealed class AddEditTaskEvent {
    data class OnEditTitle(val newTaskTitle: String): AddEditTaskEvent()
    data class OnEditDescription(val newTaskDescription: String): AddEditTaskEvent()
    data class OnSelectIcon(val selectedIcon: String): AddEditTaskEvent()
    data class OnSelectCategory(val selectedCategory: String): AddEditTaskEvent()
    data object OnSaveTask: AddEditTaskEvent()
    data object ToggleCategoryDropdown: AddEditTaskEvent()
    data object HideCategoryDropdown: AddEditTaskEvent()
}