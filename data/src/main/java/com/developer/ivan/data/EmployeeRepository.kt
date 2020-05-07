package com.developer.ivan.data

import com.developer.ivan.data.datasources.ILocalDataSource
import com.developer.ivan.data.datasources.INetworkDataSource
import com.developer.ivan.data.datasources.IRemoteDataSource
import com.developer.ivan.domain.Employee

interface IEmployeeRepository{
    fun getEmployees() : List<Employee>
    fun insertEmployee(param: Employee): Boolean
}

class EmployeeRepository(
    private val localDataSource: ILocalDataSource,
    private val remoteDataSource: IRemoteDataSource,
    private val networkDataSource: INetworkDataSource
) : IEmployeeRepository
{
    override fun getEmployees(): List<Employee> {

        return if(!networkDataSource.isConnectedInternet()){
            localDataSource.retrieveEmployees()
        }else{
            with(remoteDataSource){
                getEmployees().map { employee ->  employee.copy(task = localDataSource.getTask(employee)) }
            }
        }

    }

    override fun insertEmployee(param: Employee): Boolean  = localDataSource.insertEmployee(param)

}