package com.example.ipwho.data.remote.dto

data class Connection(
    val asn: Int,
    val domain: String,
    val isp: String,
    val org: String
)