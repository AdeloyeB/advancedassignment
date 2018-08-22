package com.company;



public class Employee extends LivingCreature {
    private String last_name;


    public Employee(String name, String last_name) {
        super(name);
        this.last_name = last_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }


    @Override
    public String toString() {
        return "Employee{" +
                ", id='" + id + '\'' +
                ", name='" + name + '\'' +
                "last_name='" + last_name + '\'' +
                '}';
    }
}