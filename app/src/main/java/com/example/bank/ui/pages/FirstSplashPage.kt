package com.example.bank.ui.pages

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.bank.R
import com.example.bank.ui.theme.BankTheme

@Preview(uiMode = UI_MODE_NIGHT_YES, name = "Dark mode")
@Preview(name = "Light mode")
@Composable
fun FirstSplashPagePreview() {
    BankTheme {
        FirstSplashPage()
    }
}

@Composable
fun FirstSplashPage() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background)
    ) {
        Image(
            modifier = Modifier.align(alignment = Alignment.Center),
            painter = painterResource(id = R.drawable.ic_logo),
            contentDescription = null
        )
    }
}