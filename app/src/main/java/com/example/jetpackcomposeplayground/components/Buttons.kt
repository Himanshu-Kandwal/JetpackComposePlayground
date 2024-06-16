package com.example.jetpackcomposeplayground.components

import android.os.Handler
import android.os.Looper
import android.view.MotionEvent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.compositeOver
import androidx.compose.ui.input.pointer.pointerInteropFilter
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun SimpleButton() {
    var clickCounter by remember { mutableIntStateOf(0) }
    Button(
        onClick = { clickCounter++ }, modifier = Modifier
            .padding(15.dp)
            .fillMaxWidth()
    ) {
        Text(text = "I've been clicked $clickCounter times")
    }
}

@Composable
fun FilledTonalButton() {
    var clickCounter by remember { mutableIntStateOf(0) }
    FilledTonalButton(
        onClick = { clickCounter++ }, modifier = Modifier
            .padding(15.dp)
            .fillMaxWidth()
    ) {
        Text(text = "I've been clicked $clickCounter times")
    }
}

@Composable
fun OutlinedButtonSample() {
    var clickCounter by remember { mutableIntStateOf(0) }
    OutlinedButton(
        onClick = { clickCounter++ }, modifier = Modifier
            .padding(15.dp)
            .fillMaxWidth()
    ) {
        Text(text = "I've been clicked $clickCounter times")
    }
}


/*@Composable
@Preview(showBackground = true)
fun FilledTonalButtonPreview() {
    FilledTonalButton()
}

@Composable
@Preview(showBackground = true)
fun SimpleButtonPreview() {
    SimpleButton()
}

@Composable
@Preview(showBackground = true)
fun SimpleSquareButtonPreview() {
    SimpleSquareButton()
}

@Composable
@Preview(showBackground = true)
fun SimpleOutlinedSquareButtonPreview() {
    SimpleOutlinedSquareButton()
}*/

@Composable
fun SimpleSquareButton() {
    var count by remember { mutableIntStateOf(0) }
    Button(
        onClick = { count++ },
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        shape = RectangleShape // shape = RoundedCornerShape(20) for rounded cornors shape
    ) {
        Text("Rectangular Button clicked $count times")
    }
}

@Composable
fun SimpleOutlinedSquareButton() {
    var count by remember { mutableIntStateOf(0) }
    OutlinedButton(
        shape = RectangleShape,
        onClick = { count++ },
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        border = BorderStroke(1.dp, Color.DarkGray) /*by default border is given which we can change here,
        border=null for no border stroke
        by default color of border in outlined button is MaterialTheme.colorScheme.onSurface
        */
    ) {
        Text("Rectangular Button clicked $count times")
    }
}

/*
In XML we have state selectors but in compose use pointerInteropFilter
 */
@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun ButtonOnTouch() {
    var isTouched by remember { mutableStateOf(false) }

    Button(
        onClick = { /*TODO*/ }, modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .pointerInteropFilter { event ->
                when (event.action) {
                    MotionEvent.ACTION_DOWN -> {
                        isTouched = true
                        true
                    }

                    MotionEvent.ACTION_UP -> {
                        isTouched = false
                        true
                    }

                    else -> false
                }
            }, colors = ButtonDefaults.buttonColors(
            containerColor = if (isTouched) Color.Red.darkenColor() else Color.Green.darkenColor()
        )

    ) {
        Text(
            text = "Tap Me",
            color = if (isTouched) Color.White else Color.Black
        )
    }

}

@Preview(showBackground = true)
@Composable
fun ButtonOnTouchPreview() {
    ButtonOnTouch()
}

@Composable
fun AutoDisableButton() {
    var count by remember { mutableIntStateOf(0) }
    var isButtonEnabled by remember { mutableStateOf(true) }
    val debounceTime = 5000L //3 sec

    val handler = Handler(Looper.getMainLooper())

    val runnable = Runnable {
        isButtonEnabled = true
    }

    Button(
        onClick = {
            count++
            isButtonEnabled = false
            handler.postDelayed(runnable, debounceTime)
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp), enabled = isButtonEnabled
    ) { Text(text = "Auto Disable Button clicked $count times") }
}

@Preview(showBackground = true)
@Composable
fun AutoDisableButtonPreview() {
    AutoDisableButton()
}

@Composable
@Preview(showBackground = true)
fun OutlinedButtonSamplePreview() {
    OutlinedButtonSample()
}

fun Color.darkenColor(factor: Float = 0.2f): Color {

    val validatedFactor = if (factor > 1f) 1f else if (factor < 0f) 0f else factor

    val blackOverlay = Color.Black.copy(alpha = validatedFactor)

    return blackOverlay.compositeOver(this)
}


