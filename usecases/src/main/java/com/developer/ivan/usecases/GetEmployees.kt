package com.developer.ivan.usecases

import com.developer.ivan.data.IEmployeeRepository
import com.developer.ivan.domain.Employee

class GetEmployees(private val repository: IEmployeeRepository) : UseCase<Unit,List<Employee>>()
{
    override suspend fun body(param: Unit): List<Employee> = repository.getEmployees()
}