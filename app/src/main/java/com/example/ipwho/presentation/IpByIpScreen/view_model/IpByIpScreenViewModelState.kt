package com.example.ipwho.presentation.IpByIpScreen.view_model

import com.example.ipwho.domain.model.MyIpInfo

data class IpByIpScreenViewModelState(
    val Error : String? = null,
    val Loading : Boolean = false,
    val IpInfo : MyIpInfo? = null
)