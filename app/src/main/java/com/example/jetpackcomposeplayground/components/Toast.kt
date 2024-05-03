package com.example.jetpackcomposeplayground.components

import android.widget.Toast
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun ShowToastButton() {
    var counter by remember { mutableStateOf(0) }
    val context = LocalContext.current
    Button(onClick = {
        counter++
        Toast.makeText(context, "Button Clicked $counter times!", Toast.LENGTH_SHORT).show()
    }) {
        Text(text = "Show Toast")
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ShowToastButtonPreview() {
    ShowToastButton()
}