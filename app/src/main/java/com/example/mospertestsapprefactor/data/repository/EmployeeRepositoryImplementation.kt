package com.example.mospertestsapprefactor.data.repository

import androidx.lifecycle.LiveData
import com.example.mospertestsapprefactor.data.local.EmployeeDao
import com.example.mospertestsapprefactor.data.local.entities.EmployeeEntity
import com.example.mospertestsapprefactor.data.remote.EmployeeApi
import com.example.mospertestsapprefactor.data.remote.responses.EmployeesResponse
import com.example.mospertestsapprefactor.domain.model.Employee
import com.example.mospertestsapprefactor.domain.respository.EmployeeRepository
import com.example.mospertestsapprefactor.utils.Resource
import javax.inject.Inject

class EmployeeRepositoryImplementation @Inject constructor(
    private val employeeDao: EmployeeDao,
    private val employeeApi: EmployeeApi,
): EmployeeRepository {

    override suspend fun getEmployees(): Resource<EmployeesResponse> {
      val response= employeeApi.getListEmployees()

        return if(response.isSuccessful){
            response.body()?.let {
                return@let Resource.success(it)
            } ?: Resource.error("error unexpected",null)
        }else{
            Resource.error("error unexpected",null)
        }
    }


    override fun getSavedEmployees(): LiveData<List<EmployeeEntity>> {
        return employeeDao.getEmployees()
    }

    override suspend fun saveEmployee(employee: Employee) {
        employeeDao.insertEmployee(employee= EmployeeEntity(
            name = employee.name,
            last_name = employee.last_name,
            image = employee.image,
            description = employee.description,
            rate = employee.rate
        ))
    }

    override suspend fun removeEmployee(employee: Employee) {
        employeeDao.removeEmployee(employee= EmployeeEntity(
            id=employee.id,
            name = employee.name,
            last_name = employee.last_name,
            image = employee.image,
            description = employee.description,
            rate = employee.rate
        ))
    }


}