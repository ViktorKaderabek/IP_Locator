package com.example.ipwho.data.remote

import com.example.ipwho.data.remote.dto.IpWhoDto
import retrofit2.http.GET
import retrofit2.http.Path

interface IpWhoApi {

    @GET("/")
    suspend fun getMyIpAdressInformation() : IpWhoDto

    @GET("/{ip}")
    suspend fun getIpByIp(@Path("ip") ip : String) : IpWhoDto
}