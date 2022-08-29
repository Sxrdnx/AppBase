package com.example.mospertestsapprefactor.data.remote.dto

import com.example.mospertestsapprefactor.domain.model.Employee
import com.google.gson.annotations.SerializedName

data class EmployeeDto(@SerializedName("id") val id: Int = 0,
                       @SerializedName("firstName") val name: String = "",
                       @SerializedName("lastName") val last_name: String = "",
                       @SerializedName("image") val image: String="",
                       @SerializedName("description") val description: String="",
                       @SerializedName("rating") val rate: Float = 0.0f)
fun EmployeeDto.toEmployee(): Employee {
    return Employee(
        id, name, last_name, image, description, rate)
}