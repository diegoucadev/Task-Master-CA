package com.durbina.taskmaster.feature_task.presentation.add_edit_task

import androidx.lifecycle.ViewModel
import com.durbina.taskmaster.feature_task.domain.model.Task
import com.durbina.taskmaster.feature_task.domain.use_case.TaskUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class AddEditTaskViewModel @Inject constructor(
    private val taskUseCases: TaskUseCases
): ViewModel() {
    private val _addEditTaskState = MutableStateFlow(AddEditTaskState())
    val addEditTaskState = _addEditTaskState.asStateFlow()

    fun onEvent(event: AddEditTaskEvent) {
        when(event) {
            is AddEditTaskEvent.OnEditDescription -> {
                _addEditTaskState.value = addEditTaskState.value.copy(
                    description = event.newTaskDescription
                )
            }
            is AddEditTaskEvent.OnEditTitle -> {
                _addEditTaskState.value = addEditTaskState.value.copy(
                    task = event.newTaskTitle
                )
            }
            AddEditTaskEvent.OnSaveTask -> TODO()
            is AddEditTaskEvent.OnSelectCategory -> {
                _addEditTaskState.value = addEditTaskState.value.copy(
                    category = event.selectedCategory
                )
            }
            is AddEditTaskEvent.OnSelectIcon -> {
                _addEditTaskState.value = addEditTaskState.value.copy(
                    icon = event.selectedIcon
                )
            }
            is AddEditTaskEvent.ToggleCategoryDropdown -> {
                _addEditTaskState.value = addEditTaskState.value.copy(
                    isExpanded = !addEditTaskState.value.isExpanded
                )
            }
            is AddEditTaskEvent.HideCategoryDropdown -> {
                _addEditTaskState.update {
                    it.copy(isExpanded = false)
                }
            }
        }
    }
}