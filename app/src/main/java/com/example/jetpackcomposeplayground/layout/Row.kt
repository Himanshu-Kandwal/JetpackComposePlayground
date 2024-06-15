package com.example.jetpackcomposeplayground.layout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Icon
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun RowSimple() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
            .background(Color.Gray)
    ) {
        Text("First Text In Row", fontSize = 20.sp)
        Icon(
            imageVector = Icons.Filled.Check,
            contentDescription = null,
            modifier = Modifier.size(40.dp), //SwitchDefaults.IconSize for default size
        )
        Text("Second Text In Row", fontSize = 20.sp)
    }
}

@Composable
fun RowWithAlignment() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
            .background(Color.Gray), horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Text("First Text", fontSize = 20.sp)
        Icon(
            imageVector = Icons.Filled.Check,
            contentDescription = null,
            modifier = Modifier.size(40.dp), //SwitchDefaults.IconSize for default size
        )
        Text("Second Text", fontSize = 20.sp)
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun RowWithAlignmentPreview() {
    RowWithAlignment()
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun RowSimplePreview() {
    RowSimple()
}