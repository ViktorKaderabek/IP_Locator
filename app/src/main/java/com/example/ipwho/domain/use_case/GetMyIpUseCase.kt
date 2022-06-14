package com.example.ipwho.domain.use_case

import com.example.ipwho.common.Resource
import com.example.ipwho.data.remote.dto.toMyIpInfo
import com.example.ipwho.domain.model.MyIpInfo
import com.example.ipwho.domain.repository.IpRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okhttp3.OkHttp
import okhttp3.OkHttpClient
import okio.IOException

class GetMyIpUseCase(
  private val repository : IpRepository
) {
    operator fun invoke() : Flow<Resource<MyIpInfo>> = flow{
        try {
            emit(Resource.Loading())
            val ipInfo = repository.getMyIp()
            emit(Resource.Success(ipInfo.toMyIpInfo()))
        }catch (e : IOException){
            emit(Resource.Error(e.toString()))
        }
    }
}