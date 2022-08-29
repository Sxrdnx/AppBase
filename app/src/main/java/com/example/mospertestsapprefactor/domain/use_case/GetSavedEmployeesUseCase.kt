package com.example.mospertestsapprefactor.domain.use_case

import androidx.lifecycle.LiveData
import com.example.mospertestsapprefactor.domain.model.Employee
import com.example.mospertestsapprefactor.domain.respository.EmployeeRepository
import javax.inject.Inject

class GetSavedEmployeesUseCase @Inject constructor(
    private val employeeRepository: EmployeeRepository
) {
    operator fun invoke()=employeeRepository.getSavedEmployees()


}