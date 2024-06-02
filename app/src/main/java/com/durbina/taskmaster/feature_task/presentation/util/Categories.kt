package com.durbina.taskmaster.feature_task.presentation.util

import androidx.compose.ui.graphics.Color

enum class Categories(val categoryName: String, val color: Color) {
    STUDY("Study", Color.Cyan),
    FAMILY("Family", Color.Blue),
    ASSIGNMENT("Assignment", Color.Yellow),
    URGENT("Urgent", Color.Red),
    TRAVEL("Travel", Color.Magenta),
    MISCELLANEOUS("Miscellaneous", Color.LightGray)
}