package com.example.mospertestsapprefactor.domain.model

data class Employee(val id: Int = 0,
                    val name: String = "",
                     val last_name: String = "",
                     val image: String="",
                     val description: String="",
                    val rate: Float = 0.0f)