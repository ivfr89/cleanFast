package com.developer.ivan.cleanapiexample.datasources

import com.developer.ivan.cleanapiexample.mapper.toDB
import com.developer.ivan.cleanapiexample.mapper.toDomain
import com.developer.ivan.cleanapiexample.models.DBEmployee
import com.developer.ivan.cleanapiexample.models.DBTask
import com.developer.ivan.data.datasources.ILocalDataSource
import com.developer.ivan.domain.Employee
import com.developer.ivan.domain.EmployeeType
import com.developer.ivan.domain.Task


sealed class Response {

    class Success<T>(element: T) : Response()

    object Fail : Response()
}

class DatabaseDataSource : ILocalDataSource {

    private val listEmployees: MutableList<DBEmployee> = mutableListOf()
    val listTask: MutableList<DBTask> = mutableListOf()


    override fun saveEmployees(employees: List<Employee>) {
        listEmployees.addAll(employees.map { it.toDB() })
    }

    /*fun mirespuesta(): Response{

        val listado = listOf<Employee>()

        return if(listado.isEmpty()) Response.Fail() else Response.Success(listado)

    }*/
    override fun retrieveEmployees(): List<Employee> =
        listEmployees.map { it.toDomain() }

    override fun getTask(employee: Employee): List<Task> =
        listEmployees.find { it == employee.toDB() }?.listTask?.map { it.toDomain() } ?: emptyList()

    override fun insertEmployee(employee: Employee): Boolean {

        return when (employee.type) {
            EmployeeType.GOLD -> false
            EmployeeType.NORMAL -> {

                listEmployees.add(employee.toDB())
                true
            }
        }
    }

}