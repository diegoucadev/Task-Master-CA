package com.durbina.taskmaster.feature_task.presentation.add_edit_task

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(showSystemUi = true)
@Composable
fun AddEditTask() {
    var taskTitle = remember {
        mutableStateOf("")
    }
    var taskDescription = remember {
        mutableStateOf("")
    }
    Scaffold {
        Column(
            modifier = Modifier
                .padding(it)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
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
        }
    }
}