package com.example.jetpackcomposeplayground.layout

import android.widget.Toast
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp

@Composable
fun LazyRowSample() {
    val context = LocalContext.current

    val list = ('A'..'Z').toList()
    LazyRow(modifier = Modifier.fillMaxSize()) {
        items(count = list.size) { index ->
            RowItemSample(list[index], index) {
                Toast.makeText(
                    context,
                    "Clicked on Value ${list[index]} at $it",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}

@Composable
fun RowItemSample(dataToShow: Char, index: Int, onClick: (Int) -> Unit) {
    Box(
        modifier = Modifier
            .padding(8.dp)
            .height(100.dp)
            .width(100.dp)
            .border(2.dp, Color.Black, shape = CircleShape)
            .clickable {
                onClick(index)
            }) {
        Text(
            fontSize = TextUnit(30f, TextUnitType.Sp),
            text = dataToShow.toString(),
            modifier = Modifier.align(Alignment.Center)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun LazyRowSamplePreview() {
    LazyRowSample()
}
