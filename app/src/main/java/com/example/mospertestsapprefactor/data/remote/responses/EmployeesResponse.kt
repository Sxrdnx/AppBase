package com.example.mospertestsapprefactor.data.remote.responses

import com.example.mospertestsapprefactor.data.remote.dto.EmployeeDto
import com.google.gson.annotations.SerializedName

data class EmployeesResponse(@SerializedName("employees")
                             val employees: List<EmployeeDto>)
