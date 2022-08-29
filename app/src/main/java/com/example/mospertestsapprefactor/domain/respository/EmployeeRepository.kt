package com.example.mospertestsapprefactor.domain.respository

import androidx.lifecycle.LiveData
import com.example.mospertestsapprefactor.data.local.entities.EmployeeEntity
import com.example.mospertestsapprefactor.data.remote.responses.EmployeesResponse
import com.example.mospertestsapprefactor.domain.model.Employee
import com.example.mospertestsapprefactor.utils.Resource

interface EmployeeRepository {

    suspend fun getEmployees(): Resource<EmployeesResponse>

    fun getSavedEmployees(): LiveData<List<EmployeeEntity>>

    suspend fun saveEmployee(employee: Employee)

    suspend fun removeEmployee(employee: Employee)

}