package com.github.evgenius1424

class SmartCompany : Company {
    private val employees = arrayListOf<Employee>()

    override fun getEmployees(): List<Employee> = employees

    override fun addEmployee(employee: Employee) {
        employees += employee
    }
}
