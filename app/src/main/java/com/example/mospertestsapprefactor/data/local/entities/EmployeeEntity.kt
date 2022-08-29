package com.example.mospertestsapprefactor.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "employees")
data class EmployeeEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String = "",
    val last_name: String = "",
    val image: String="",
    val description: String="",
    val rate: Float = 0.0f)