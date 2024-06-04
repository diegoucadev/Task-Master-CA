package com.durbina.taskmaster.feature_task.presentation.tasks.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.durbina.taskmaster.feature_task.domain.model.Task

val testTask = Task(
    title = "LOREM ",
    description = "LOREM IPSUM",
    category = "LOL",
    icon = "Test"
)


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TaskCard(task: Task, icon: ImageVector, backgroundColor: Color) {
    ElevatedCard(
        onClick = { TODO() },
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp)
            .height(75.dp),
        colors = CardDefaults.elevatedCardColors(
            containerColor = backgroundColor
        )
    ) {
        Box(
            modifier = Modifier
                .padding(20.dp)
                .fillMaxSize()
                //.background(backgroundColor)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = icon,
                    contentDescription = task.icon,
                    modifier = Modifier
                        .size(50.dp)
                )
                Spacer(modifier = Modifier.width(20.dp))
                Text(
                    text = task.title,
                    style = TextStyle(
                        fontSize = 18.sp,
                        letterSpacing = 3.sp
                    )
                )
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun TaskCardPreview() {
    TaskCard(task = testTask, icon = Icons.Default.ThumbUp, backgroundColor = Color.Green)
}