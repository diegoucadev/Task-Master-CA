package com.durbina.taskmaster.feature_task.presentation.tasks

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.durbina.taskmaster.core.Constants
import com.durbina.taskmaster.feature_task.presentation.tasks.components.TaskCard
import com.durbina.taskmaster.feature_task.presentation.util.Categories
import com.durbina.taskmaster.feature_task.presentation.util.IconType
import com.durbina.taskmaster.feature_task.presentation.util.Screen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Tasks(
    navController: NavController,
    viewModel: TasksViewModel = hiltViewModel()
) {
    val tasksState = viewModel.taskState.value
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = Constants.APP_NAME.uppercase())
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.Cyan,
                    titleContentColor = Color.Black
                )
            )

        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    navController.navigate(Screen.AddEditTaskScreen.route)
                }) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Add a new task"
                )
            }
        }
    ) {
        LazyColumn(
            modifier = Modifier
                .padding(it)
                .fillMaxSize()
        ) {
            items(tasksState.tasks) {
                val backgroundColor = when(it.category) {
                    Categories.STUDY.categoryName -> Categories.STUDY.color
                    Categories.FAMILY.categoryName -> Categories.FAMILY.color
                    Categories.ASSIGNMENT.categoryName -> Categories.ASSIGNMENT.color
                    Categories.URGENT.categoryName -> Categories.URGENT.color
                    Categories.TRAVEL.categoryName -> Categories.TRAVEL.color
                    Categories.MISCELLANEOUS.categoryName -> Categories.MISCELLANEOUS.color
                    else -> Color.Gray
                }
                val icon = when(it.icon) {
                    IconType.URGENT.iconName -> IconType.URGENT.icon
                    IconType.STUDY.iconName -> IconType.URGENT.icon
                    IconType.PLACE.iconName -> IconType.PLACE.icon
                    else -> IconType.DEFAULT.icon
                }
                TaskCard(
                    task = it,
                    icon = icon,
                    backgroundColor = backgroundColor,
                    onDeleteTask = {
                        viewModel.onEvent(TasksEvent.OnDeleteTask(it))
                    }
                )

            }
        }
    }
}