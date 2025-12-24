package io.github.evgenius1424.kotlingradle

interface EmployeeService {
    fun getAllEmployees(): List<Employee>

    fun addEmployee(employee: Employee)

    fun getEmployeeCount(): Int
}
