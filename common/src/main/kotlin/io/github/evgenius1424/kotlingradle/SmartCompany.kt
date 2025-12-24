package io.github.evgenius1424.kotlingradle

class SmartCompany : Company {
    private val employees = arrayListOf<Employee>()

    override fun getEmployees(): List<Employee> = employees

    override fun addEmployee(employee: Employee) {
        employees += employee
    }
}
