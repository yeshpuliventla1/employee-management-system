package com.abctech.ems;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class EmployeeServiceTest {

    @Test
    void testAddEmployee() {

        // Arrange
        EmployeeService service = new EmployeeService();
        Employee employee = new Employee(101, "Rahul", "IT");

        // Act
        service.addEmployee(employee);

        // Assert
        assertEquals(1, service.getEmployees().size());
    }
}
