package com.company;

import java.util.ArrayList;
import java.util.List;

public class Pen {
    protected String id;
    protected String name;
    private String penType;
    protected Employee employee;
    protected Employee employee2;
    private boolean isHappyPen;
    private boolean isPreyPen;
    private List<Animal> animalList;

    public Pen(String id, String name, String penType, Employee employee, Employee employee2, boolean isHappyPen, boolean isPreyPen) {
        this.id = id;
        this.name = name;
        this.penType = penType;
        this.employee = employee;
        this.employee2 = employee2;
        this.isHappyPen = isHappyPen;
        this.isPreyPen = isPreyPen;
        animalList = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPenType() {
        return penType;
    }

    public void setPenType(String penType) {
        this.penType = penType;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Employee getEmployee2() {
        return employee2;
    }

    public void setEmployee2(Employee employee2) {
        this.employee2 = employee2;
    }

    public boolean isHappyPen() {
        return isHappyPen;
    }

    public void setHappyPen(boolean happyPen) {
        isHappyPen = happyPen;
    }

    public boolean isPreyPen() {
        return isPreyPen;
    }

    public void setPreyPen(boolean preyPen) {
        isPreyPen = preyPen;
    }

    public List<Animal> getAnimalList() {
        return animalList;
    }

    public void setAnimalList(List<Animal> animalList) {
        this.animalList = animalList;
    }

    public void addAnim

    @Override
    public String toString() {
        return "Pen{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", penType='" + penType + '\'' +
                ", employee=" + employee.toString() +
                ", employee2=" + employee2.toString() +
                ", isHappyPen=" + isHappyPen +
                ", isPreyPen=" + isPreyPen +
                ", animalList=" + animalList +
                '}';
    }
}
