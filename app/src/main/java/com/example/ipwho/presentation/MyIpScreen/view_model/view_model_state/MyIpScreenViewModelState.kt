package com.example.ipwho.presentation.MyIpScreen.view_model.view_model_state

import com.example.ipwho.domain.model.MyIpInfo

data class MyIpScreenViewModelState(
    val Error : String? = null,
    val Loading : Boolean = false,
    val IpInfo : MyIpInfo? = null
)