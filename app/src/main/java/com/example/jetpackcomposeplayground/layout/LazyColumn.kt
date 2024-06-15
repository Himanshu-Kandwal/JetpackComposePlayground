package com.example.jetpackcomposeplayground.layout

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun LazyColumnSample() {
    val context = LocalContext.current

    val list = (1..200).toList()
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(count = list.size) { index ->
            Text(
                text = "Item is " + list[index].toString(),
                modifier = Modifier
                    .height(56.dp)
                    .fillMaxWidth()
                    .clickable {
                        Toast
                            .makeText(
                                context,
                                "Item is " + list[index].toString(),
                                Toast.LENGTH_SHORT
                            )
                            .show()
                    }
                    .padding(bottom = 8.dp, start = 8.dp, end = 8.dp)
                    .background(color = Color.Yellow)
            )
        }
    }
}

@Composable
fun LazyColumnWithMultipleTypesSample() {
    val numList = (1..200).toList()
    val alphabetList = ('A'..'Z').toList()
    val context = LocalContext.current

    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(count = numList.size + alphabetList.size) { index ->


            /*
            for index=0, index%5 will always be zero and our alphabet item will be
            displayd at 0th index which is wrong.
            so we make sure index is equal or more than 5
            i.e we are at sixth item on lazy list and first 5 items(0th index to 4th index) were
            NumberItem,
            in index / 5 <= alphabetList.size , index/5 gives us index value to iterate
            alphabetlist and index value is  less than or equal to alphabetList.size because we are reducing
            1 while accessing its value in line char = alphabetList[-1 + index / 5], //-1 so 0th index also be seen

following will also work:
 if (index % 5 == 0 && (index / 5 - 1) in 0..alphabetList.lastIndex) {
                // Display alphabet item
                AlphabetItem(
                    char = alphabetList[index / 5 - 1], //-1 so 0th index also be seen
                    onClick = { char ->
                        Toast.makeText(context, "Alphabet clicked: $char", Toast.LENGTH_SHORT)
                            .show()
                    }
                )
            }

             */
            if (index >= 5 && index % 5 == 0 && index / 5 <= alphabetList.size) {
                // Display alphabet item
                AlphabetItem(
                    char = alphabetList[-1 + index / 5], //-1 so 0th index also be seen
                    onClick = { char ->
                        Toast.makeText(context, "Alphabet clicked: $char", Toast.LENGTH_SHORT)
                            .show()
                    }
                )
            }
            // Display number item
            val numIndex = index
            if (numIndex < numList.size) //checking index overflow is not there
                NumberItem(
                    number = numList[numIndex],
                    onClick = { number ->
                        Toast.makeText(context, "Number clicked: $number", Toast.LENGTH_SHORT)
                            .show()
                    }
                )

        }
    }
}

@Composable
fun LazyColumnAddingRemovingItemsSample() {
    val context = LocalContext.current
    var textAddField by remember { mutableStateOf("") }
    var textRemoveFieldIndex by remember { mutableStateOf("") }
    var list = remember { mutableStateListOf<Int>() }

    Column(modifier = Modifier.fillMaxSize()) {


        Row(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            verticalAlignment = Alignment.CenterVertically
        ) {
            TextField(
                placeholder = { Text("Enter Value") },
                value = textAddField,
                onValueChange = {
                    textAddField = it
                },
                modifier = Modifier.weight(0.5f),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
            Button(onClick = {
                if (textAddField.isNotEmpty())
                    list.add(textAddField.toInt())

            }, modifier = Modifier.weight(0.4f)) {
                Text("Add At Index")
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            verticalAlignment = Alignment.CenterVertically
        ) {
            TextField(
                placeholder = { Text("Index") },
                value = textRemoveFieldIndex,
                onValueChange = {
                    textRemoveFieldIndex = it
                },
                modifier = Modifier
                    .weight(0.6f)
                    .padding(start = 4.dp),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
            Button(onClick = {
                if (textRemoveFieldIndex.toInt() in 0 until list.size)
                    list.removeAt(textRemoveFieldIndex.toInt())
            }, modifier = Modifier.weight(0.4f)) {
                Text("Remove At")
            }
        }

        LazyColumn(modifier = Modifier.weight(10f)) {
            items(count = list.size) { index ->
                NumberItem(
                    list[index],
                    onClick = { number ->
                        Toast.makeText(
                            context,
                            "Number clicked: $number",
                            Toast.LENGTH_SHORT
                        ).show()
                    })
            }
        }

    }
}


@Composable
fun NumberItem(number: Int, onClick: (Int) -> Unit) {
    Text(
        "Number Item : Value = $number",
        modifier = Modifier
            .fillMaxWidth()
            .height(64.dp)
            .padding(bottom = 8.dp)
            .background(color = Color.Yellow)
            .clickable { onClick(number) }
    )
}

@Composable
fun AlphabetItem(char: Char, onClick: (Char) -> Unit) {
    Text(
        "Alphabet Item : Value = $char",
        modifier = Modifier
            .fillMaxWidth()
            .height(64.dp)
            .padding(bottom = 8.dp)
            .background(color = Color.Green)
            .clickable { onClick(char) }
    )
}

@Preview(showBackground = true)
@Composable
fun LazyColumnWithMultipleTypesSamplePreview() {
    LazyColumnWithMultipleTypesSample()
}

@Preview(showBackground = true)
@Composable
fun LazyColumnSamplePreview() {
    LazyColumnSample()
}

@Preview(showBackground = true)
@Composable
fun LazyColumnAddingRemovingItemsSamplePreview() {
    LazyColumnAddingRemovingItemsSample()
}