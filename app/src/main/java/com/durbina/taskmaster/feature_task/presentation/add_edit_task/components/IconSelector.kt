package com.durbina.taskmaster.feature_task.presentation.add_edit_task.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.durbina.taskmaster.core.util.IconType

@Composable
fun IconSelector(
    onIconSelected: (String) -> Unit
) {
    var selectedIcon = remember {
        mutableStateOf("")
    }
    Box(
        modifier = Modifier
            .padding(20.dp)
            .fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        Row(
            modifier = Modifier
                .background(Color.Cyan, shape = RoundedCornerShape(16.dp))
                .height(75.dp)
                .fillMaxWidth()
                .padding(10.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconType.entries.forEach {
                val isSelected = selectedIcon.value == it.iconName
                Icon(
                    imageVector = it.icon,
                    contentDescription = it.iconName,
                    modifier = Modifier
                        .size(48.dp)
                        .clickable {
                            selectedIcon.value = it.iconName
                            onIconSelected(it.iconName)

                        },
                        tint = if (isSelected) Color.Magenta else Color.Black
                )
                Spacer(modifier = Modifier.width(20.dp))
            }
        }
    }
}