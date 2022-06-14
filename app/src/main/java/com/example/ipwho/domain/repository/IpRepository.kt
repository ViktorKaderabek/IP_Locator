package com.example.ipwho.domain.repository

import com.example.ipwho.data.remote.dto.IpWhoDto
import com.example.ipwho.domain.model.MyIpInfo

interface IpRepository {

    suspend fun getMyIp() : IpWhoDto

    suspend fun getIpByIp(ip : String) : IpWhoDto
}