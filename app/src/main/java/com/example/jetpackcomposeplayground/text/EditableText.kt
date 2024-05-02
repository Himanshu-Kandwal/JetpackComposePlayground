package com.example.jetpackcomposeplayground.text

import androidx.annotation.Dimension
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewScreenSizes
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcomposeplayground.R

@Composable
fun SimpleTextField() {
    var text by remember { mutableStateOf("") }
    val charCapacity = 10
    TextField(
        value = text,
        onValueChange = { text = it },
        label = { Text("Full Name") },
        maxLines = 1,
        isError = text.length > 10, //turns color of label to red if text length exceeds
        supportingText = { //text below the textfield to show error if limit crossed
            if (text.length > 10) {
                Text(
                    "Limit exceeded ${text.length.toString() + "/" + charCapacity}",
                    color = Color.Red
                )
            }
        }

    )
}

@Composable
fun TextFieldOutlined() {
    var text by remember { mutableStateOf("") }
    val maxLength = 10
    OutlinedTextField(
        value = text,
        onValueChange = { text = it },
        label = { Text("Full Name") },
        maxLines = 1,
        isError = text.length > maxLength,
        supportingText = {
            if (text.length > maxLength) {
                Text("Limit exceeded ${text.length.toString() + "/" + maxLength}")
            }
        }, placeholder = { Text("Alex , Robert etc.") }
    )
}


@Composable
fun PasswordTextField() {
    var passText by remember { mutableStateOf("") }
    var isPasswordVisible by remember { mutableStateOf(false) }
    val minLength = 8
    OutlinedTextField(
        value = passText,
        onValueChange = { passText = it },
        label = { Text("Password") },
        singleLine = true,
        isError = passText.length < minLength,
        supportingText = {
            if (passText.length < minLength) {
                Text("Password is too short", color = Color.Red)
            }
        },
        visualTransformation = if (isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
        trailingIcon = { //icon toggle
            val iconImage = if (isPasswordVisible) {
                R.drawable.visibility_off_24px
            } else {
                R.drawable.visibility_24px
            }

            IconButton(onClick = { isPasswordVisible = !isPasswordVisible }) {
                Icon(
                    tint = Color.LightGray,
                    painter = painterResource(id = iconImage),
                    contentDescription = "Password Toggle"
                )
            }
        }
    )
}

@Composable
fun RoundedCornorTextfield() {
    var enteredText by remember {
        mutableStateOf("");
    }
    TextField(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        value = enteredText,
        onValueChange = { enteredText = it },
        placeholder = { Text(text = "Enter Text", fontSize = 30.sp) },
        shape = RoundedCornerShape(50), //rounded corner shape
        //making indicator i.e underline etc color transparent
        colors = TextFieldDefaults.colors(
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        ),
        //font size i.e text size
        textStyle = TextStyle(fontSize = 30.sp)
    )
}


@Composable
fun SearchRoundedCornorTextfield() {
    var searchText by remember {
        mutableStateOf("")
    }

    val textSize = 20.sp;

    TextField(
        modifier = Modifier
            .height(85.dp)
            .fillMaxWidth()
            .padding(15.dp),
        value = searchText, onValueChange = { searchText = it },
        colors = TextFieldDefaults.colors(
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        ),
        shape = RoundedCornerShape(50),
        placeholder = { Text("Search", fontSize = textSize) },
        leadingIcon = {
            Icon(
                painter = painterResource(id = android.R.drawable.ic_menu_search),
                contentDescription = "Search Icon",
                modifier = Modifier.padding(start = 10.dp)
            )
        },
        textStyle = TextStyle(fontSize = textSize),
        singleLine = true,
        maxLines = 1,
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SearchRoundedCornorTextfieldPreview() {
    SearchRoundedCornorTextfield()
}

@Preview(showBackground = true)
@Composable
fun TextFieldOutlinedPreview() {
    TextFieldOutlined()
}

@Preview(showBackground = true)
@Composable
fun SimpleTextFieldPreview() {
    SimpleTextField()
}

/*@Preview(showBackground = true, showSystemUi = true)
@Composable
fun RoundedCornorTextfieldPreview() {
    RoundedCornorTextfield()
}*/


@Preview(showBackground = true)
@Composable
fun PasswordTextFieldPreview() {
    PasswordTextField()
}

