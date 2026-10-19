package ru.seroglazov.company;

import java.util.ArrayList;
import java.util.Arrays;

import ru.seroglazov.validation.Validate;

public class Department {
    private String title;
    private Employee boss;
    private ArrayList<Employee> employees;

    public Department(String title, Employee boss, Employee... employees) {
        if (Validate.isNull(title) || title.isBlank()) title = "unknown";
        this.title = title;
        this.employees = new ArrayList<>();
        addEmployees(employees);
        if (Validate.isNull(boss)) boss = new Employee("unknown", this);
        else addEmployees(boss);
        this.boss = boss;
    }

    //region getters

    public String getTitle() {
        return title;
    }

    public Employee getBoss() {
        return boss;
    }

    public ArrayList<Employee> getEmployees() {
        return new ArrayList<>(employees);
    }

    //endregion

    //region setters
    public void setTitle(String title) {
        if (Validate.isNull(title) || title.isBlank()) title = "unknown";
        this.title = title;
    }

    public void setBoss(Employee boss) {
        if (Validate.isNull(boss)) boss = new Employee("unknown", this);
        else addEmployees(boss);
        this.boss = boss;
    }

    public void setEmployees(ArrayList<Employee> employees) {
        ArrayList<Employee> newEmployees = new ArrayList<>();
        if (!Validate.isNull(employees)) newEmployees.addAll(employees);
        ArrayList<Employee> toRemove = new ArrayList<>(this.employees);
        toRemove.removeAll(newEmployees);
        toRemove.remove(boss);
        removeEmployees(toRemove);
        addEmployees(newEmployees);
    }

    public void setEmployees(Employee... employees) {
        ArrayList<Employee> newEmployees = new ArrayList<>();
        if (employees != null) newEmployees.addAll(Arrays.asList(employees));
        setEmployees(newEmployees);
    }

    //endregion

    public void addEmployees(Employee... employees) {
        if (employees == null) return;
        for (Employee employee : employees) {
            if (Validate.isNull(employee) || this.employees.contains(employee)) continue;
            this.employees.add(employee);
            if (employee.getDepartment() != this) employee.setDepartment(this);
        }
    }

    public void addEmployees(ArrayList<Employee> employees) {
        if (Validate.isNull(employees)) return;
        addEmployees(employees.toArray(new Employee[0]));
    }

    public void removeEmployees(Employee... employees) {
        if (employees == null) return;
        for (Employee employee : employees) {
            if (Validate.isNull(employee) || !this.employees.remove(employee)) continue;
            if (employee.getDepartment() == this) employee.setDepartment(null);
            if (employee == boss) boss = new Employee("unknown", this);
        }
    }

    public void removeEmployees(ArrayList<Employee> employees) {
        if (Validate.isNull(employees)) return;
        removeEmployees(employees.toArray(new Employee[0]));
    }

    @Override
    public String toString() {
        return "Department{" +
                "title='" + title + '\'' +
                ", boss=" + boss +
                ", employees=" + employees +
                '}';
    }
}

