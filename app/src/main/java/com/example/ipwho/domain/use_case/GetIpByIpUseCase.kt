package com.example.ipwho.domain.use_case

import com.example.ipwho.common.Resource
import com.example.ipwho.data.remote.dto.toMyIpInfo
import com.example.ipwho.domain.model.MyIpInfo
import com.example.ipwho.domain.repository.IpRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetIpByIpUseCase(
    private val repository : IpRepository
) {
    operator fun invoke(ip : String) : Flow<Resource<MyIpInfo>> = flow{
        try {
            emit(Resource.Loading())
            val ipInfo = repository.getIpByIp(ip).toMyIpInfo()
            emit(Resource.Success(ipInfo))
        }catch (e : Exception){
            emit(Resource.Error("An Unexpected error has occurred"))
        }
    }
}