package com.developer.ivan.usecases

import com.developer.ivan.data.IEmployeeRepository
import com.developer.ivan.domain.Employee

class InsertEmployee(private val employeeRepository: IEmployeeRepository) : UseCase<Employee, Boolean>() {
    override suspend fun body(param: Employee): Boolean = employeeRepository.insertEmployee(param)

}