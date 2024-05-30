package com.durbina.taskmaster.core.util

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Warning
import androidx.compose.ui.graphics.vector.ImageVector

enum class IconType(val iconName: String, val icon: ImageVector) {
    STUDY("Study", Icons.Default.Edit),
    PLACE("Place", Icons.Default.LocationOn),
    URGENT("Urgent", Icons.Default.Warning),
    DEFAULT("Default", Icons.Default.Check)
}