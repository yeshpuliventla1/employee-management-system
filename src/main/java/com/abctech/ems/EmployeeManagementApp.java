package com.abctech.ems;

public class EmployeeManagementApp {

    public static void main(String[] args) {
	
	System.out.println("=================================");
        System.out.println("Employee Management System v2.0");
        System.out.println("Built by Jenkins CI Pipeline");
        System.out.println("=================================");
	
        EmployeeService service = new EmployeeService();

        service.addEmployee(new Employee(101, "Rahul", "IT"));
        service.addEmployee(new Employee(102, "Priya", "HR"));
        service.addEmployee(new Employee(103, "Arjun", "Finance"));

        service.displayEmployees();
    }
}
