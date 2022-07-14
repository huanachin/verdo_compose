package com.example.bank.ui.custom

import android.content.res.Configuration
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.ButtonDefaults.elevation
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.bank.R
import com.example.bank.ui.theme.BankTheme


@Preview(widthDp = 400, uiMode = Configuration.UI_MODE_NIGHT_YES, name = "Dark mode")
@Preview(widthDp = 400, name = "Light mode")
@Composable
fun FacebookButtonPreview() {
    BankTheme {
        FacebookButton()
    }
}


@Preview(widthDp = 400, uiMode = Configuration.UI_MODE_NIGHT_YES, name = "Dark mode")
@Preview(widthDp = 400, name = "Light mode")
@Composable
fun GoogleButtonPreview() {
    BankTheme {
        GoogleButton()
    }
}

@Composable
fun FacebookButton(modifier: Modifier = Modifier) {
    OutlinedButton(
        modifier = modifier,
        onClick = {},
        colors = ButtonDefaults.outlinedButtonColors(
            backgroundColor = MaterialTheme.colors.background,
        ),
        shape = RoundedCornerShape(8.dp),
        elevation = elevation(defaultElevation = 8.dp),
        border = BorderStroke(width = 0.5.dp, color = Color.LightGray)
    ) {
        Image(painter = painterResource(R.drawable.ic_facebook), contentDescription = null)
        Spacer(Modifier.width(8.dp))
        Text(
            text = stringResource(R.string.facebook),
            color = if (isSystemInDarkTheme()) Color.White else Color.Black
        )
    }
}

@Composable
fun GoogleButton(modifier: Modifier = Modifier) {
    OutlinedButton(
        modifier = modifier,
        onClick = {},
        colors = ButtonDefaults.outlinedButtonColors(
            backgroundColor = MaterialTheme.colors.background,
        ),
        shape = RoundedCornerShape(8.dp),
        elevation = elevation(defaultElevation = 8.dp),
        border = BorderStroke(width = 0.5.dp, color = Color.LightGray)
    ) {
        Image(painter = painterResource(R.drawable.ic_google), contentDescription = null)
        Spacer(Modifier.width(8.dp))
        Text(
            text = stringResource(R.string.google),
            color = if (isSystemInDarkTheme()) Color.White else Color.Black
        )
    }
}