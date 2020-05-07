package com.developer.ivan.data.datasources

import com.developer.ivan.domain.Employee

interface IRemoteDataSource {

    fun getEmployees(): List<Employee>
}