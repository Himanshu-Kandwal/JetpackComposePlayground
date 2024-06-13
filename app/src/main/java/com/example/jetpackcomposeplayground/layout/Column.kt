package com.example.jetpackcomposeplayground.layout

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@Composable
fun ColumnSample() {
    Column {
        Text("Hello, this is first item of column", fontSize = 20.sp, color = Color.Blue)
        Text("column has all items from top to bottom manner", color = Color.Red)
        MemeBox()
        Text(
            "this column has four items, text text memebox text",
            fontSize = 20.sp,
            color = Color.Cyan
        )

    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ColumnSamplePreview() {
    ColumnSample()
}