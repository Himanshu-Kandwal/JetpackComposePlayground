package com.example.jetpackcomposeplayground.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RangeSlider
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun BasicSlider() {
    var sliderPosition by remember { mutableFloatStateOf(0f) }
    Column {
        Slider(
            value = sliderPosition,
            onValueChange = { sliderPosition = it }
        )
        Text(text = sliderPosition.toString())
    }

}

@Composable
fun SliderWithSteps() {
    var sliderPosition by remember { mutableFloatStateOf(0f) }
    Column {
        Slider(
            value = sliderPosition,
            onValueChange = { sliderPosition = it },
            colors = SliderDefaults.colors(
                thumbColor = MaterialTheme.colorScheme.secondary,
                activeTrackColor = MaterialTheme.colorScheme.secondary,
                inactiveTrackColor = MaterialTheme.colorScheme.secondaryContainer,
            ),
            steps = 3,
            valueRange = 0f..50f
        )
        Text(text = sliderPosition.toString())
    }
}

@Composable
fun SliderWithRange() {
    var sliderPosition by remember { mutableStateOf(30f..60f) } //default selected range
    Column {
        RangeSlider(
            value = sliderPosition,
            steps = 10, //number of partition on the slider
            onValueChange = { range -> sliderPosition = range },
            valueRange = 0f..100f, //range of the slider can we selected
            onValueChangeFinished = {
                // launch some business logic update with the state you hold
                // viewModel.updateSelectedSliderValue(sliderPosition)
            },

            )
        Text(text = sliderPosition.toString())
    }
}


@Preview(showBackground = true)
@Composable
fun BasicSliderPreview() {
    BasicSlider()
}

@Preview(showBackground = true)
@Composable
fun SliderWithStepsPreview() {
    SliderWithSteps()
}

@Preview(showBackground = true)
@Composable
fun SliderWithRangePreview() {
    SliderWithRange()
}