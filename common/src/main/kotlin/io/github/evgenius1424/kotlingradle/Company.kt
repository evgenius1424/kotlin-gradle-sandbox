package io.github.evgenius1424.kotlingradle

interface Company {
    fun getEmployees(): List<Employee>

    fun addEmployee(employee: Employee)
}
