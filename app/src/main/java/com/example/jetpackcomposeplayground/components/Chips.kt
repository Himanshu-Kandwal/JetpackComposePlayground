package com.example.jetpackcomposeplayground.components

import android.R
import android.util.Log
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview


@Composable
fun AssistChipSample() {
    AssistChip(
        label = { Text("Power Off") },
        onClick = { Log.d("Assist chip", "hello world") },
        leadingIcon = {
            Icon(
                painter = painterResource(id = R.drawable.ic_lock_power_off),
                contentDescription = "Search Icon",
                modifier = Modifier
                    .size(AssistChipDefaults.IconSize)
            )
        }
    )
}

@Composable
fun FilterChipExample() {
    var selected by remember { mutableStateOf(false) }

    FilterChip(
        onClick = { selected = !selected },
        label = {
            Text("Filter chip")
        },
        selected = selected,
        leadingIcon = if (selected) {
            {
                Icon(
                    Icons.Filled.Done, contentDescription = "secure icon",
                    modifier = Modifier
                        .size(AssistChipDefaults.IconSize)
                )
            }
        } else {
            null
        },
    )
}

@Preview(showBackground = true)
@Composable
fun AssistChipPreview() {
    AssistChipSample()
}

@Preview(showBackground = true)
@Composable
fun FilterChipPreview() {
    FilterChipExample()
}