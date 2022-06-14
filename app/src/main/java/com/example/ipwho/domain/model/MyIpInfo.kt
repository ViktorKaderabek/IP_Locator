package com.example.ipwho.domain.model

import com.example.ipwho.data.remote.dto.Connection
import com.example.ipwho.data.remote.dto.Flag
import com.example.ipwho.data.remote.dto.Timezone

data class MyIpInfo(
    val borders: String,
    val calling_code: String,
    val capital: String,
    val city: String,
    val connection: Connection,
    val continent: String,
    val continent_code: String,
    val country: String,
    val country_code: String,
    val flag : Flag,
    val ip: String,
    val is_eu: Boolean,
    val latitude: Double,
    val longitude: Double,
    val postal: String,
    val region: String,
    val region_code: String,
    val success: Boolean,
    val timezone: Timezone,
    val type: String
)