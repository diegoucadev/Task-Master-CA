package com.durbina.taskmaster.feature_task.presentation.tasks

import androidx.lifecycle.ViewModel
import com.durbina.taskmaster.feature_task.domain.use_case.TaskUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TasksViewModel @Inject constructor(
    private val taskUseCases: TaskUseCases
): ViewModel() {

}