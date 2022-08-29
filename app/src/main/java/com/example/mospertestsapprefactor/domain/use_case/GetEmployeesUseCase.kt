package com.example.mospertestsapprefactor.domain.use_case

import com.example.mospertestsapprefactor.data.remote.responses.EmployeesResponse
import com.example.mospertestsapprefactor.domain.respository.EmployeeRepository
import com.example.mospertestsapprefactor.utils.Resource
import javax.inject.Inject

class GetEmployeesUseCase @Inject constructor(
    private val employeeRepository: EmployeeRepository
) {
    suspend operator fun invoke(): Resource<EmployeesResponse> {
        return employeeRepository.getEmployees()
    }
}