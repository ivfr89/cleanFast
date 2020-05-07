package com.developer.ivan.cleanapiexample.mapper

import com.developer.ivan.cleanapiexample.models.DBEmployee
import com.developer.ivan.cleanapiexample.models.DBTask
import com.developer.ivan.cleanapiexample.models.EntityEmployee
import com.developer.ivan.domain.Employee
import com.developer.ivan.domain.EmployeeType
import com.developer.ivan.domain.Task

fun EntityEmployee.toDomain() = Employee(
    id,
    employee_name,
    employee_salary,
    employee_age.toInt(),
    profile_image,
    emptyList(),
    EmployeeType.NORMAL
)