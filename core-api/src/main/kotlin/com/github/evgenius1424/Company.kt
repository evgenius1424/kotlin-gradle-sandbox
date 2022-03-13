package com.github.evgenius1424

interface Company {

    fun getEmployees(): List<Employee>

    fun addEmployee(employee: Employee)
}
