package com.example.ipwho.di

import com.example.ipwho.common.Constants
import com.example.ipwho.data.remote.IpWhoApi
import com.example.ipwho.data.repository.IpRepositoryImpl
import com.example.ipwho.domain.repository.IpRepository
import com.example.ipwho.domain.use_case.GetIpByIpUseCase
import com.example.ipwho.domain.use_case.GetMyIpUseCase
import com.example.ipwho.presentation.IpByIpScreen.view_model.IpByIpScreenViewModel
import com.example.ipwho.presentation.MyIpScreen.view_model.MyIpScreenViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val AppModule = module {

    fun provideCoinPaprikaApi(): IpWhoApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(IpWhoApi::class.java)
    }

    fun provideCoinRepository(
        api: IpWhoApi
    ): IpRepository {
        return IpRepositoryImpl(api)
    }

    fun getUseCase(repository: IpRepository): GetMyIpUseCase {
        return GetMyIpUseCase(repository)
    }

    fun getDeatilUseCase(repository: IpRepository): GetIpByIpUseCase {
        return GetIpByIpUseCase(repository)
    }

    single { provideCoinRepository(get()) }
    single { provideCoinPaprikaApi() }
    single { getDeatilUseCase(get()) }
    single { getUseCase(get()) }

}
val myIpInfoVm = module { viewModel { MyIpScreenViewModel(get()) } }
val ipByIpVm = module { viewModel { IpByIpScreenViewModel(get()) } }