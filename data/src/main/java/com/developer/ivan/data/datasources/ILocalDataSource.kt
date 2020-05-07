package com.developer.ivan.data.datasources

import com.developer.ivan.domain.Employee
import com.developer.ivan.domain.Task

interface ILocalDataSource {

    fun saveEmployees(employees: List<Employee>)
    fun retrieveEmployees(): List<Employee>
    fun getTask(employee: Employee): List<Task>
    fun insertEmployee(employee: Employee): Boolean

}