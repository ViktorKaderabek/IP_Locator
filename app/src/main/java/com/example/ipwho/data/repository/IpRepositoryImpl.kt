package com.example.ipwho.data.repository

import com.example.ipwho.data.remote.IpWhoApi
import com.example.ipwho.data.remote.dto.IpWhoDto
import com.example.ipwho.domain.repository.IpRepository

class IpRepositoryImpl(
    private val api: IpWhoApi
) : IpRepository {
    override suspend fun getMyIp(): IpWhoDto {
        return api.getMyIpAdressInformation()
    }

    override suspend fun getIpByIp(ip: String): IpWhoDto {
        return api.getIpByIp(ip)
    }
}