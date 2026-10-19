package ru.seroglazov.company;

import java.util.ArrayList;

import ru.seroglazov.validation.Validate;

public class Employee {
    private String name;
    private Department department;

    public Employee(String name) {
        if (Validate.isNull(name) || name.isBlank()) name = "unknown";
        this.name = name;
    }

    public Employee(String name, Department department) {
        this(name);
        if (Validate.isNull(department)) department = new Department("unknown", null);
        setDepartment(department);
    }

    //region getters
    public String getName() {
        return name;
    }

    public Department getDepartment() {
        return department;
    }

    //endregion

    //region setters
    public void setName(String name) {
        if (Validate.isNull(name) || name.isBlank()) name = "unknown";
        this.name = name;
    }

    public void setDepartment(Department department) {
        if (this.department == department) {
            if (!Validate.isNull(department)) department.addEmployees(this);
            return;
        }
        Department oldDepartment = this.department;
        this.department = department;
        if (!Validate.isNull(oldDepartment)) oldDepartment.removeEmployees(this);
        if (!Validate.isNull(department)) department.addEmployees(this);
    }
    //endregion

    @Override
    public String toString() {
        String isInDep = "";
        String isHaveBoss = "";

        if (!Validate.isNull(department) && department.getBoss().equals(this)){
            return name + " начальник отдела " + department.getTitle();
        }

        if (!Validate.isNull(department) &&
                !(department.getTitle().equals("unknown"))) isInDep = " работает в отделе " + department.getTitle();
        if (!Validate.isNull(department) &&
                !(department.getBoss().getName().equals("unknown"))) isHaveBoss = " начальник которого " + department.getBoss().getName();

        return name + isInDep + isHaveBoss;
    }
}

