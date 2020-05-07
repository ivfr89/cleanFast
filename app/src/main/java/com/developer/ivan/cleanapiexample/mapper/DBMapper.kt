package com.developer.ivan.cleanapiexample.mapper

import com.developer.ivan.cleanapiexample.models.DBEmployee
import com.developer.ivan.cleanapiexample.models.DBTask
import com.developer.ivan.domain.Employee
import com.developer.ivan.domain.Task

fun DBEmployee.toDomain() = Employee(
    id,
    employee_name,
    employee_salary,
    employee_age.toInt(),
    profile_image,
    listTask.map { it.toDomain() },
    type
)

fun DBTask.toDomain() = Task(id, name)


fun Employee.toDB() = DBEmployee(
    id,
    employeeName,
    salary,
    age.toString(),
    profileImage,
    task.map { it.toDB() },
    type
)

fun Task.toDB() = DBTask(id, name)