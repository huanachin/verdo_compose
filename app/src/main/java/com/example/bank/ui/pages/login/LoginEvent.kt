package com.example.bank.ui.pages.login

sealed class LoginEvent {
    object Error : LoginEvent()
    data class Success(val name: String) : LoginEvent()
}