package com.developer.ivan.domain




enum class EmployeeType {
    GOLD,
    NORMAL
}

data class Employee(val id: String,
                    val employeeName: String,
                    val salary: String,
                    val age: Int,
                    val profileImage: String,
                    val task: List<Task>,
                    val type: EmployeeType
                    )



data class Task (val id: Long, val name: String)
