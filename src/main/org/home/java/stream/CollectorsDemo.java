package org.home.java.stream;

import java.util.*;
import java.util.stream.Collectors;

public class CollectorsDemo {
    class Employee {
        private String name;
        private String dept;
        private int salary;

        Employee(String name, String dept, int salary) {
            this.name = name;
            this.dept = dept;
            this.salary = salary;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDept() {
            return dept;
        }

        public void setDept(String dept) {
            this.dept = dept;
        }

        public int getSalary() {
            return salary;
        }

        public void setSalary(int salary) {
            this.salary = salary;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Employee employee = (Employee) o;
            return salary == employee.salary &&
                    Objects.equals(name, employee.name) &&
                    Objects.equals(dept, employee.dept);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, dept, salary);
        }

        @Override
        public String toString() {
            return "Employee{" +
                    "name='" + name + '\'' +
                    ", dept='" + dept + '\'' +
                    ", salary=" + salary +
                    '}';
        }
    }

    public static void main(String[] args) {
        CollectorsDemo demo = new CollectorsDemo();
        demo.accumulateNameIntoList();
        demo.accumulateNameIntoSet();
    }

    private void accumulateNameIntoList() {
        List<Employee> employees = getEmployeeList();
        List<String> employeeNames = employees.stream().map(Employee::getName).collect(Collectors.toList());
        System.out.println(employeeNames);
    }

    private void accumulateNameIntoSet() {
        List<Employee> employees = getEmployeeList();
        TreeSet<String> employeeNames = employees.stream().map(Employee::getName)
                .collect(Collectors.toCollection(TreeSet::new));
        System.out.println(employeeNames);
    }

    private List<Employee> getEmployeeList() {
        List<Employee> list = new ArrayList<>();
        list.add(new Employee("Rudra", "Store", 10000));
        list.add(new Employee("Kartikeya", "Store", 20000));
        list.add(new Employee("Abhisekh", "Store", 15000));
        list.add(new Employee("Aritra", "Agenr", 10000));
        list.add(new Employee("Kalyan", "Agent", 50000));
        list.add(new Employee("Pooja", "Admin", 10000));
        list.add(new Employee("Nimish", "Admin", 20000));
        return list;
    }
}
