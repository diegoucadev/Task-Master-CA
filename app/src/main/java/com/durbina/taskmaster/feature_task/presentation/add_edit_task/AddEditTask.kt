package com.durbina.taskmaster.feature_task.presentation.add_edit_task

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.toUpperCase
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.durbina.taskmaster.core.util.Constants
import com.durbina.taskmaster.feature_task.presentation.add_edit_task.components.IconSelector

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showSystemUi = true)
@Composable
fun AddEditTask() {
    var taskTitle = remember {
        mutableStateOf("")
    }
    var taskDescription = remember {
        mutableStateOf("")
    }
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

    ) {
        Column(
            modifier = Modifier
                .padding(it)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Spacer(modifier = Modifier.height(20.dp))
            OutlinedTextField(
                value = taskTitle.value,
                onValueChange = {
                    taskTitle.value = it
                },
                label = {
                    Text(text = "Title")
                }

            )

            OutlinedTextField(
                value = taskTitle.value,
                onValueChange = {
                    taskTitle.value = it
                },
                label = {
                    Text(text = "Description")  
                }
            )

            Spacer(modifier = Modifier.height(40.dp))

            IconSelector()
        }
    }
}