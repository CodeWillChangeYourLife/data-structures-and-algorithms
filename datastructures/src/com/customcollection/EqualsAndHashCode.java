package com.customcollection;

import java.util.HashMap;

public class EqualsAndHashCode {

    public static void main(String[] args) {
        Employee e1 = new Employee(1, "a");
        Employee e2 = new Employee(2, "b");
        Employee e3 = new Employee(1, "a");

        System.out.println(e1.hashCode());
        System.out.println(e2.hashCode());
        System.out.println(e3.hashCode());
        System.out.println(e1.equals(e3));

    }
}

class Employee {
    int empId;
    String empName;

    public Employee(int empId, String empName) {
        this.empId = empId;
        this.empName = empName;
    }

    public int hashCode() {
        int hashCode = this.empId + empName.hashCode();
        return hashCode;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        } else if (this.getClass() != obj.getClass()) {
            return false;
        }
        Employee otherEmployee = (Employee) obj;
        return this.empId == otherEmployee.empId && this.empName.equals(otherEmployee.empName);
    }
}
