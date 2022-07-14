package com.example.bank.ui.pages.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {

    private val _usernameFlow = MutableStateFlow("")
    val usernameFlow = _usernameFlow.asStateFlow()

    private val _passwordFlow = MutableStateFlow("")
    val passwordFlow = _passwordFlow.asStateFlow()

    val uiState = MutableStateFlow<LoginUiState>(LoginUiState.Initial)

    private val _eventFlow = Channel<LoginEvent>()
    val eventFlow = _eventFlow.receiveAsFlow()

    fun signIn() {
        uiState.value = LoginUiState.Loading
        viewModelScope.launch {
            delay(1000)
            _eventFlow.send(LoginEvent.Success("Jesus"))
        }
    }

    fun setUsername(username: String) {
        _usernameFlow.value = username
    }

    fun setPassword(password: String) {
        _passwordFlow.value = password
    }

}