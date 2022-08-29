package com.example.mospertestsapprefactor.data.local

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.mospertestsapprefactor.data.local.entities.EmployeeEntity

@Dao
interface EmployeeDao {
    @Query("SELECT * FROM employees")
    fun getEmployees():LiveData<List<EmployeeEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertEmployee(employee: EmployeeEntity)

    @Delete
    suspend fun removeEmployee(employee: EmployeeEntity)
}