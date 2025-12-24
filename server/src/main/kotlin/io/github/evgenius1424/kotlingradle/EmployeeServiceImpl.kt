package io.github.evgenius1424.kotlingradle

class EmployeeServiceImpl(private val company: Company) : EmployeeService {
    init {
        // Add some initial employees for demonstration
        company.addEmployee(Employee("John Doe"))
        company.addEmployee(Employee("Jane Smith"))
        company.addEmployee(Employee("Bob Johnson"))
    }

    override fun getAllEmployees(): List<Employee> {
        return company.getEmployees()
    }

    override fun addEmployee(employee: Employee) {
        company.addEmployee(employee)
    }

    override fun getEmployeeCount(): Int {
        return company.getEmployees().size
    }
}
