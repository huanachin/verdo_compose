package com.example.bank.ui.pages.login

sealed class LoginUiState {
    object Initial : LoginUiState()
    object Loading : LoginUiState()
    object Error : LoginUiState()
}