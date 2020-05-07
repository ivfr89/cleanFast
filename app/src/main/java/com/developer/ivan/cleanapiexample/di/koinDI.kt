package com.developer.ivan.cleanapiexample.di

import com.developer.ivan.cleanapiexample.MainActivity
import com.developer.ivan.cleanapiexample.ViewModelController
import com.developer.ivan.cleanapiexample.datasources.DatabaseDataSource
import com.developer.ivan.cleanapiexample.datasources.NetworkDataSource
import com.developer.ivan.cleanapiexample.datasources.RemoteDataSource
import com.developer.ivan.data.EmployeeRepository
import com.developer.ivan.data.IEmployeeRepository
import com.developer.ivan.data.datasources.ILocalDataSource
import com.developer.ivan.data.datasources.INetworkDataSource
import com.developer.ivan.data.datasources.IRemoteDataSource
import com.developer.ivan.usecases.GetEmployees
import com.developer.ivan.usecases.InsertEmployee
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

val dataModule = module {

    factory<IEmployeeRepository> {
        EmployeeRepository(get(), get(), get())
    }

    factory<ILocalDataSource> {
        DatabaseDataSource()
    }

    factory<IRemoteDataSource> {
        RemoteDataSource()
    }


    factory<INetworkDataSource> {
        NetworkDataSource()
    }

}

val usecasesModule = module {

    factory {
        GetEmployees(get())
    }
    factory {
        InsertEmployee(get())
    }
}

val appModule = module {


    scope(named<MainActivity>()) {

        viewModel {
            ViewModelController(get(), get())
        }


    }
}