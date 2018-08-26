package com.company;



public class Employee extends LivingCreature {
    protected String last_name;
    protected String employeePenType;
    protected String employeePenType2;

    public Employee(String name, String last_name, String employeePenType, String employeePenType2) {
        super(name);
        this.last_name = last_name;
        this.employeePenType = employeePenType;
        this.employeePenType2 = employeePenType2;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmployeePenType() {
        return employeePenType;
    }

    public void setEmployeePenType(String employeePenType) {
        this.employeePenType = employeePenType;
    }

    public String getEmployeePenType2() {
        return employeePenType2;
    }

    public void setEmployeePenType2(String employeePenType2) {
        this.employeePenType2 = employeePenType2;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "last_name='" + last_name + '\'' +
                ", employeePenType='" + employeePenType + '\'' +
                ", employeePenType2='" + employeePenType2 + '\'' +
                ", id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}