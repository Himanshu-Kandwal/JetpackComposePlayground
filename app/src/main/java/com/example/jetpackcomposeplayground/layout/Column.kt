package com.example.jetpackcomposeplayground.layout

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcomposeplayground.R

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

@Composable
fun ColumnWithAlignment() {
    Column(
        modifier = Modifier
            .background(Color.Gray)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally, //alignment tells children to be positioned horizontally(in column) in start,end,CenterHorizontally etc

        verticalArrangement = Arrangement.spacedBy(16.dp) //alignment tells children to have spacing vertically
        //Arrangement.spacedBy(16.dp) can be used to given equal spacing between children , Arrangement.SpaceEvenly ,space between can be used also
    ) {

        Text(
            "Hello, this is column with alignment and arrangement",
            fontSize = 20.sp,
            color = Color.Blue
        )
        Image(
            modifier = Modifier
                .height(200.dp)
                .width(200.dp),
            contentScale = ContentScale.Crop,
            painter = painterResource(id = R.drawable.profile),
            contentDescription = "background image"
        )
        Image(
            modifier = Modifier
                .height(200.dp)
                .width(200.dp),
            contentScale = ContentScale.Crop,
            painter = painterResource(id = R.drawable.profile),
            contentDescription = "background image"
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ColumnWithAlignmentPreview() {
    ColumnWithAlignment()
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ColumnSamplePreview() {
    ColumnSample()
}