package com.example.mospertestsapprefactor.domain.use_case

import com.example.mospertestsapprefactor.domain.model.Employee
import com.example.mospertestsapprefactor.domain.respository.EmployeeRepository
import javax.inject.Inject

class SavedEmployeeUseCase @Inject constructor(
    private val employeeRepository: EmployeeRepository
) {
    suspend operator fun invoke(employee:Employee){
        employeeRepository.saveEmployee(employee)
    }
}