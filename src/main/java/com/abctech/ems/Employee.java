package com.abctech.ems;

public class Employee {

    private int id;
    private String name;
    private String department;

    public Employee(int id, String name, String department) {
        this.id = id;
        this.name = name;
        this.department = department;
    }

    public void displayEmployee() {
        System.out.println("-------------------------");
        System.out.println("Employee ID : " + id);
        System.out.println("Employee Name : " + name);
        System.out.println("Department : " + department);
    }
}
