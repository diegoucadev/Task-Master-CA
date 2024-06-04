package com.durbina.taskmaster.feature_task.presentation.tasks

import android.content.ContentValues.TAG
import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.durbina.taskmaster.feature_task.domain.use_case.TaskUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TasksViewModel @Inject constructor(
    private val taskUseCases: TaskUseCases
): ViewModel() {
    private var getTasksJob: Job? = null
    private val _taskState = mutableStateOf(TaskState())
    val taskState = _taskState

    init {
        getTasks()
    }

    fun onEvent(event: TasksEvent) {
        when(event) {
            is TasksEvent.OnDeleteTask -> {
                viewModelScope.launch(Dispatchers.IO) {
                    taskUseCases.deleteTask(event.task)
                }
            }
        }
    }

    private fun getTasks() {
        getTasksJob?.cancel()
        getTasksJob = taskUseCases.getTasks().onEach {
            _taskState.value = taskState.value.copy(
                tasks = it
            )
        }.launchIn(viewModelScope)
    }

}