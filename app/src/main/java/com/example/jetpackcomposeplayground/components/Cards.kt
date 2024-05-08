package com.example.jetpackcomposeplayground.components

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun SimpleCard() {
    Card(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
            .height(200.dp)
    ) {
        Text(text = "This is a simple card", modifier = Modifier.padding(16.dp))
    }
}


@Composable
fun OutlinedCardSample() {
    Card(
        border = BorderStroke(2.dp, MaterialTheme.colorScheme.secondary),
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
            .height(200.dp)
    ) {
        Text(text = "This is a Outlined card", modifier = Modifier.padding(16.dp))
    }
}

@Composable
fun ElevatedCardExample() {
    val context = LocalContext.current
    var counter by remember { mutableIntStateOf(0) }
    ElevatedCard(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ),
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .padding(16.dp), onClick = {
                counter++
            Toast.makeText(context, "Elevated Card Clicked $counter times", Toast.LENGTH_SHORT)
                .show()
        }
    ) {
        Text(
            text = "Elevated",
            modifier = Modifier
                .padding(16.dp),
            textAlign = TextAlign.Center,
        )
    }
}


@Preview(showBackground = true)
@Composable
fun SimpleCardPreview() {
    SimpleCard()
}

@Preview(showBackground = true)
@Composable
fun OutlinedCardSamplePreview() {
    OutlinedCardSample()
}

@Preview(showBackground = true)
@Composable
fun ElevatedCardExamplePreview() {
    ElevatedCardExample()
}