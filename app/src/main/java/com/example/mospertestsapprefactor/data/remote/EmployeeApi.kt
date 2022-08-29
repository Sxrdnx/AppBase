package com.example.mospertestsapprefactor.data.remote

import com.example.mospertestsapprefactor.data.remote.responses.EmployeesResponse
import retrofit2.Response
import retrofit2.http.GET

interface EmployeeApi {
    @GET(".")
    suspend fun getListEmployees():Response <EmployeesResponse>
}