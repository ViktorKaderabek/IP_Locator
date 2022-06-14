package com.example.ipwho.data.remote

import retrofit2.http.GET

interface IpWhoApi {
    @GET
    suspend fun getMyIpAdressInformation() :
}