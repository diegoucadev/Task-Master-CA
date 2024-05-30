package com.durbina.taskmaster.core.util

import androidx.compose.ui.graphics.Color

sealed class Categories(val name: String, val color: Color) {
    data object Study: Categories("Study", Color.Cyan)
    data object Family: Categories("Family", Color.Blue)
    data object Assignment: Categories("Assignment", Color.Yellow)
    data object Urgent: Categories("Urgent", Color.Red)
    data object Travel: Categories("Travel", Color.Magenta)
    data object Miscellaneous: Categories("Miscellaneous", Color.LightGray)
}