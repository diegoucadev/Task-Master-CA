package com.durbina.taskmaster.feature_task.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.durbina.taskmaster.feature_task.presentation.add_edit_task.AddEditTask
import com.durbina.taskmaster.feature_task.presentation.tasks.Tasks
import com.durbina.taskmaster.feature_task.presentation.util.Screen
import com.durbina.taskmaster.ui.theme.TaskMasterCleanArchitectureTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TaskMasterCleanArchitectureTheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = Screen.TaskScreen.route
                ) {
                    composable(route = Screen.TaskScreen.route) {
                        Tasks(navController = navController)
                    }
                    composable(route = Screen.AddEditTaskScreen.route) {
                        AddEditTask(navController = navController)
                    }
                }
            }
        }
    }
}
