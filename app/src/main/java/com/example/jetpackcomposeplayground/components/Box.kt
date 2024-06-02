package com.example.jetpackcomposeplayground.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcomposeplayground.R

/*
Box are framelayout alternative for compose
 */
@Composable
fun BoxComposable() {/*
    0.5f inside height width function tells that this percentage of height/width of screen
    is height width of our composable
     */
    Box(
        modifier = Modifier
            .background(Color.Gray)
            .fillMaxWidth()
            .fillMaxHeight(0.5f), contentAlignment = Alignment.Center
    ) {

        ProfilePhotoTickBox()

        /*Icon(
            modifier = Modifier
                .size(100.dp)
                .align(Alignment.BottomEnd),
            painter = painterResource(id = R.drawable.ic_tick_mark),
            contentDescription = "tick"
        )*/
    }
}

@Composable
fun ProfilePhotoTickBox() {
    //content alignment inside box will aign all child of box with same alignment
    Box(modifier = Modifier.fillMaxSize(0.5f) /*contentAlignment = Alignment.Center*/) {
        Image(
            modifier = Modifier
                .fillMaxSize()
                .clip(CircleShape),
            contentScale = ContentScale.Crop,
            painter = painterResource(id = R.drawable.profile),
            contentDescription = "background image"
        )
        Icon(
            modifier = Modifier
                .fillMaxSize(0.30f)
                .border(5.dp, Color.Gray, CircleShape)
                .fillMaxSize(0.2f)
                .align(Alignment.BottomEnd), //align helps composable to align with respective to parent
            imageVector = Icons.Filled.CheckCircle, contentDescription = "check icon"
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun PreviewBoxComposable() {
    BoxComposable()
}