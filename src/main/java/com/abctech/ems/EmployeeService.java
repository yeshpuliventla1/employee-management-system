package com.abctech.ems;

import java.util.ArrayList;
import java.util.List;

public class EmployeeService {

    private List<Employee> employees = new ArrayList<>();

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }
	
    public List<Employee> getEmployees() {
        return employees;
    }

    public void displayEmployees() {

        System.out.println("===== Employee List =====");

        for (Employee employee : employees) {
            employee.displayEmployee();
        }
    }
}
