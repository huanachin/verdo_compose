package com.example.bank.ui.custom

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.bank.ui.theme.BankTheme


@Preview
@Composable
fun NormalTextFieldPreview() {
    BankTheme {
        NormalTextField(value = "example@yourdomain.com")
    }

}

@Preview
@Composable
fun PasswordTextField() {
    BankTheme {
        PasswordTextField(value = "yoursecretpassword")
    }
}

@Composable
fun NormalTextField(
    modifier: Modifier = Modifier,
    value: String = "",
    onValueChange: (String) -> Unit = {},
    placeHolder: String = ""
) {
    TextField(
        modifier = modifier
            .background(
                color = MaterialTheme.colors.background,
                shape = RoundedCornerShape(size = 16.dp)
            )
            .border(
                border = BorderStroke(width = 1.dp, color = Color.LightGray),
                shape = RoundedCornerShape(size = 16.dp)
            ),
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = MaterialTheme.colors.background,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent
        ),
        value = value,
        onValueChange = onValueChange,
        placeholder = { Text(text = placeHolder) },
        shape = RoundedCornerShape(size = 16.dp)
    )
}

@Composable
fun PasswordTextField(
    modifier: Modifier = Modifier,
    value: String = "",
    onValueChange: (String) -> Unit = {},
    placeHolder: String = ""
) {

    var visible by remember { mutableStateOf(false) }

    TextField(
        modifier = modifier
            .background(
                color = MaterialTheme.colors.background,
                shape = RoundedCornerShape(size = 16.dp)
            )
            .border(
                border = BorderStroke(width = 1.dp, color = Color.LightGray),
                shape = RoundedCornerShape(size = 16.dp)
            ),
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = MaterialTheme.colors.background,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent
        ),
        value = value,
        onValueChange = onValueChange,
        placeholder = { Text(text = placeHolder) },
        shape = RoundedCornerShape(size = 16.dp),
        visualTransformation = if (visible) VisualTransformation.None else PasswordVisualTransformation(),
        trailingIcon = {
            val image = if (visible)
                Icons.Filled.Visibility
            else Icons.Filled.VisibilityOff
            IconButton(onClick = {
                visible = !visible
            }) {
                Icon(imageVector = image, contentDescription = null)
            }
        }
    )
}