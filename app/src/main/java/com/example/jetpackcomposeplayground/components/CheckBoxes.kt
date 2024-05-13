package com.example.jetpackcomposeplayground.components

import android.widget.CheckBox
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.material3.TriStateCheckbox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun SimpleCheckboxExample() {
    var checked by remember { mutableStateOf(true) }

    Row(
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            "Minimal checkbox"
        )
        Checkbox(
            checked = checked,
            onCheckedChange = { checked = it }
        )
    }

    Text(
        if (checked) "Checkbox is checked" else "Checkbox is unchecked"
    )
}

@Composable
fun TriStateCheckBoxSample() {
    var currState by remember { mutableStateOf(0) }
    var text by remember { mutableStateOf("Tri-state checkbox is Off") }
    Row(
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            text = text
        )
        TriStateCheckbox(
            state = when (currState) {
                0 -> ToggleableState.Off
                1 -> ToggleableState.Indeterminate
                else -> ToggleableState.On
            }, onClick = {
                currState = (currState + 1) % 3
                when (currState) {
                    0 -> text = "Tri-state checkbox is Off"
                    1 -> text = "Tri-state checkbox is Indeterminate"
                    else -> text = "Tri-state checkbox is On"
                }
            }

        )
    }
}


@Composable
fun NestedCheckBoxSample() {
    // Initialize states for the child checkboxes
    val childCheckedStates = remember { mutableStateListOf(false, false, false) }

    //state of parent checkbox on,off,indeterminate
    val parentCheckedState = when {

        childCheckedStates.all { it } -> { //iterating to all items to check if all are true
            ToggleableState.On
        }

        childCheckedStates.none { it } -> {
            ToggleableState.Off
        }

        else -> {
            ToggleableState.Indeterminate
        }
    }

    Column(horizontalAlignment = Alignment.End) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.height(25.dp)
        ) {
            Text(text = "Select All Checkbox")
            TriStateCheckbox(
                state = parentCheckedState,
                onClick = {
                    //if parent is checked ,children should unchecked on click
                    val newValueOfChildrens: Boolean =
                        ToggleableState.On != parentCheckedState//else children should be checked on click

                    childCheckedStates.forEachIndexed { index, isChecked ->
                        childCheckedStates[index] = newValueOfChildrens
                    }
                }
            )

        }

        childCheckedStates.forEachIndexed { index, checked -> //dyanamically creating checkbox with text upto lenth of childcheckedSTates list
            Row(
                verticalAlignment = Alignment.CenterVertically, modifier = Modifier.height(25.dp)
            ) {
                Text(text = "Select $index")
                Checkbox(checked = checked, onCheckedChange = { isChecked ->
                    childCheckedStates[index] = isChecked
                })
            }
        }

        if (childCheckedStates.all { it }) {
            Text(text = "All Selected", modifier = Modifier.align(Alignment.Start))
        } else {
            Text(text = "Not All Selected", modifier = Modifier.align(Alignment.Start))
        }
    }

}

@Preview(showBackground = true)
@Composable
fun TriStateCheckBoxSamplePreview() {
    TriStateCheckBoxSample()
}

@Preview(showBackground = true)
@Composable
fun SimpleCheckboxExamplePreview() {
    SimpleCheckboxExample()
}

@Preview(showBackground = true)
@Composable
fun NestedCheckBoxSamplePreview() {
    NestedCheckBoxSample()
}
