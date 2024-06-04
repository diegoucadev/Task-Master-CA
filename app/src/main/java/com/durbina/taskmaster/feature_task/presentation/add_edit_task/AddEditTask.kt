package com.durbina.taskmaster.feature_task.presentation.add_edit_task

import android.content.ContentValues.TAG
import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.durbina.taskmaster.R
import com.durbina.taskmaster.feature_task.presentation.util.Categories
import com.durbina.taskmaster.core.Constants
import com.durbina.taskmaster.feature_task.domain.model.Task
import com.durbina.taskmaster.feature_task.presentation.add_edit_task.components.IconSelector
import com.durbina.taskmaster.feature_task.presentation.util.Screen
import dagger.hilt.android.lifecycle.HiltViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddEditTask(
    navController: NavController,
    viewModel: AddEditTaskViewModel = hiltViewModel()
) {
    val addEditTaskState = viewModel.addEditTaskState.collectAsState()
    val taskState = addEditTaskState.value.task
    val descriptionState = addEditTaskState.value.description
    val selectedIcon = addEditTaskState.value.icon
    val selectedCategory = addEditTaskState.value.category
    val isExpanded = addEditTaskState.value.isExpanded

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = Constants.APP_NAME.uppercase())
                },
                colors = topAppBarColors(
                    containerColor = Color.Cyan,
                    titleContentColor = Color.Black
                )
            )

        },
        floatingActionButton = {
            FloatingActionButton(onClick = {
                viewModel.onEvent(AddEditTaskEvent.OnSaveTask)
                navController.navigate(Screen.TaskScreen.route)
            }) {
                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.save),
                    contentDescription = "Save task button"
                )
            }
        }
    ) {
        Column(
            modifier = Modifier
                .padding(it)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Spacer(modifier = Modifier.height(20.dp))

            IconSelector(
                selectedIcon = selectedIcon,
                onIconSelected = {userSelectedIcon ->
                    viewModel.onEvent(AddEditTaskEvent.OnSelectIcon(userSelectedIcon))
                }
            )

            OutlinedTextField(
                value = taskState,
                singleLine = true,
                modifier = Modifier.width(300.dp),
                onValueChange = {
                    viewModel.onEvent(AddEditTaskEvent.OnEditTitle(it))
                },
                label = {
                    Text(text = "Title")
                }

            )

            OutlinedTextField(
                value = descriptionState,
                modifier = Modifier
                    .width(300.dp)
                    .height(200.dp),
                onValueChange = {
                    viewModel.onEvent(AddEditTaskEvent.OnEditDescription(it))
                },
                label = {
                    Text(text = "Description")
                }
            )

            Spacer(modifier = Modifier.height(10.dp))

            ExposedDropdownMenuBox(
                expanded = isExpanded,
                onExpandedChange = {
                    viewModel.onEvent(AddEditTaskEvent.ToggleCategoryDropdown)
                }
            ) {
                TextField(
                    value = selectedCategory,
                    onValueChange = {},
                    readOnly = true,
                    trailingIcon = {
                        ExposedDropdownMenuDefaults.TrailingIcon(expanded = isExpanded)
                    },
                    modifier = Modifier
                        .menuAnchor()
                        .width(300.dp)
                )
                ExposedDropdownMenu(
                    expanded = isExpanded,
                    onDismissRequest = {
                        viewModel.onEvent(AddEditTaskEvent.HideCategoryDropdown)
                    }
                ) {
                    Categories.entries.forEach {
                        DropdownMenuItem(
                            text = { Text(text = it.categoryName) },
                            onClick = {
                                viewModel.onEvent(AddEditTaskEvent.OnSelectCategory(it.categoryName))
                                viewModel.onEvent(AddEditTaskEvent.HideCategoryDropdown)
                            }
                        )
                    }
                }
            }
        }
    }
}