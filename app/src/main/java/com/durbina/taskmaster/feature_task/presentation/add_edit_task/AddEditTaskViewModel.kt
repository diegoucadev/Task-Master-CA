package com.durbina.taskmaster.feature_task.presentation.add_edit_task

import androidx.lifecycle.ViewModel
import com.durbina.taskmaster.feature_task.domain.use_case.TaskUseCases
import javax.inject.Inject

class AddEditTaskViewModel @Inject constructor(
    private val taskUseCases: TaskUseCases
): ViewModel() {

}