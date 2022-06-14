package com.example.ipwho.data.remote.dto

data class Timezone(
    val abbr: String,
    val current_time: String,
    val id: String,
    val is_dst: Boolean,
    val offset: Int,
    val utc: String
)