package com.developer.ivan.cleanapiexample.models

import com.developer.ivan.domain.EmployeeType

data class DBTask (val id: Long, val name: String)

data class DBEmployee(val id: String,
                          val employee_name: String,
                          val employee_salary: String,
                          val employee_age: String,
                          val profile_image: String,
                          val listTask: List<DBTask>,
                          val type: EmployeeType
)
