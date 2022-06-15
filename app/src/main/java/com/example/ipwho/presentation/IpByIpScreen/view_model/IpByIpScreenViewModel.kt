package com.example.ipwho.presentation.IpByIpScreen.view_model

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ipwho.common.Resource
import com.example.ipwho.domain.use_case.GetIpByIpUseCase
import com.example.ipwho.presentation.HomeScreen.HomeScreen
import com.example.ipwho.presentation.Screen
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class IpByIpScreenViewModel(
    private val useCase: GetIpByIpUseCase
) : ViewModel() {
    private val _state = mutableStateOf(IpByIpScreenViewModelState())
    val state: State<IpByIpScreenViewModelState> = _state
    private var ip = HomeScreen.ip

    init {
        if (ip != null) {
            getInfoIp(ip!!)
        }
    }

    private fun getInfoIp(ip : String) {
        useCase(ip).onEach { result ->
            when (result) {
                is Resource.Loading -> {
                    _state.value = IpByIpScreenViewModelState(Loading = true)
                }

                is Resource.Success -> {
                    _state.value = IpByIpScreenViewModelState(IpInfo = result.data)
                }

                is Resource.Error -> {
                    _state.value = IpByIpScreenViewModelState(Error = result.message)
                }

            }
        }.launchIn(viewModelScope)
    }
}