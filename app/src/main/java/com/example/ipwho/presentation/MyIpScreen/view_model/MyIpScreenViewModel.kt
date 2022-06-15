package com.example.ipwho.presentation.MyIpScreen.view_model

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ipwho.common.Resource
import com.example.ipwho.domain.use_case.GetMyIpUseCase
import com.example.ipwho.presentation.MyIpScreen.view_model.view_model_state.MyIpScreenViewModelState
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class MyIpScreenViewModel(
    private val useCase: GetMyIpUseCase
) : ViewModel() {

    private val _state = mutableStateOf(MyIpScreenViewModelState())
    val state: State<MyIpScreenViewModelState> = _state


    init {
        getInfoIp()
    }

    private fun getInfoIp() {
        useCase().onEach { result ->
            when (result) {
                is Resource.Loading -> {
                    _state.value = MyIpScreenViewModelState(Loading = true)
                }

                is Resource.Success -> {
                    _state.value = MyIpScreenViewModelState(IpInfo = result.data)
                }

                is Resource.Error -> {
                    _state.value = MyIpScreenViewModelState(Error = result.message)
                }

            }
        }.launchIn(viewModelScope)
    }
}