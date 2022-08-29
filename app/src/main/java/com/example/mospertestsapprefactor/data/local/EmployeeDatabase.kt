package com.example.mospertestsapprefactor.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.mospertestsapprefactor.data.local.entities.EmployeeEntity

@Database(entities =[EmployeeEntity::class], version = 1, exportSchema = false)

abstract class EmployeeDatabase:RoomDatabase() {
    abstract fun employeeDao():EmployeeDao
}