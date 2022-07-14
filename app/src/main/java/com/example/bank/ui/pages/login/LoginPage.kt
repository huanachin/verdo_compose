package com.example.bank.ui.pages.login

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.bank.R
import com.example.bank.ui.custom.FacebookButton
import com.example.bank.ui.custom.GoogleButton
import com.example.bank.ui.custom.NormalTextField
import com.example.bank.ui.custom.PasswordTextField
import com.example.bank.ui.pages.custom.LoadingComponent
import com.example.bank.ui.theme.BankTheme

@Preview(widthDp = 400, uiMode = Configuration.UI_MODE_NIGHT_YES, name = "Dark mode")
@Preview(widthDp = 400, name = "Light mode")
@Composable
fun LoginPagePreview() {
    BankTheme {
        LoginPage()
    }
}

@Composable
fun LoginPage(viewModel: LoginViewModel) {

    val username = viewModel.usernameFlow.collectAsState()
    val password = viewModel.passwordFlow.collectAsState()
    val uiState = viewModel.uiState.collectAsState()

    val state = viewModel.eventFlow.collectAsState(initial = null)
    val event = state.value

    LaunchedEffect(event) {
        when (event) {
            LoginEvent.Error -> {

            }
            is LoginEvent.Success -> {

            }
            null -> {}
        }
    }

    LoginPage(
        username = username.value,
        onUsernameChanged = { viewModel.setUsername(it) },
        onSignIn = { viewModel.signIn() },
        password = password.value,
        onPasswordChanged = { viewModel.setPassword(it) },
        uiState = uiState.value
    )
}

@Composable
fun LoginPage(
    username: String = "",
    onUsernameChanged: (String) -> Unit = {},
    password: String = "",
    onPasswordChanged: (String) -> Unit = {},
    onSignIn: () -> Unit = {},
    uiState: LoginUiState = LoginUiState.Initial
) {

    Surface(color = MaterialTheme.colors.background) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(all = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                modifier = Modifier.height(200.dp),
                painter = painterResource(R.drawable.ic_logo),
                contentDescription = null
            )
            Spacer(Modifier.height(18.dp))
            Text(stringResource(R.string.sing_into_your_account))
            Spacer(Modifier.height(32.dp))
            Column(horizontalAlignment = Alignment.Start) {
                Text("Email*")
                Spacer(Modifier.height(8.dp))
                NormalTextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = username,
                    onValueChange = onUsernameChanged
                )
                Spacer(Modifier.height(20.dp))
                Text("Password*")
                Spacer(Modifier.height(8.dp))
                PasswordTextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = password,
                    onValueChange = onPasswordChanged
                )
            }
            Spacer(Modifier.height(18.dp))
            Button(
                modifier = Modifier
                    .height(48.dp)
                    .fillMaxWidth(),
                shape = RoundedCornerShape(16.dp),
                onClick = {}) {
                Text("Sign in", color = Color.White)
            }
            Spacer(Modifier.height(16.dp))
            Text(
                stringResource(R.string.forgot_password),
                color = MaterialTheme.colors.primary,
                fontWeight = FontWeight.Bold
            )
            Spacer(Modifier.height(16.dp))
            Text(stringResource(R.string.or_continue_with))
            Spacer(Modifier.height(32.dp))
            Row {
                FacebookButton(modifier = Modifier.weight(1f))
                Spacer(Modifier.width(16.dp))
                GoogleButton(modifier = Modifier.weight(1f))
            }
            Spacer(Modifier.height(32.dp))
            Row {
                Text(stringResource(R.string.dont_have_an_account))
                Spacer(Modifier.width(4.dp))
                Text(
                    stringResource(R.string.sign_up), color = MaterialTheme.colors.primary,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
    LoadingComponent(uiState is LoginUiState.Loading)
}