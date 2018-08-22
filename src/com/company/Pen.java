package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Pen {
    protected String id;
    protected String name;
    private String penType;
    protected Employee employee;
    protected Employee employee2;
    protected double area;
    protected  double volume;
    private boolean isPettable;
    private boolean isPreyPen;
    private List<Animal> animalList;

    public Pen(String name, String penType, Employee employee, Employee employee2, double area, double volume, boolean isPettable, boolean isPreyPen) {
        id = UUID.randomUUID().toString();
        this.name = name;
        this.penType = penType;
        this.employee = employee;
        this.employee2 = employee2;
        this.area = area;
        this.volume = volume;
        this.isPettable = isPettable;
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

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public boolean isPettable() {
        return isPettable;
    }

    public void setPettable(boolean pettable) {
        isPettable = pettable;
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

    public void addAnimal(Animal animal){
        animalList.add(animal);
    }

    @Override
    public String toString() {
        return "Pen{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", penType='" + penType + '\'' +
                ", employee=" + employee +
                ", employee2=" + employee2 +
                ", area=" + area +
                ", volume=" + volume +
                ", isPettable=" + isPettable +
                ", isPreyPen=" + isPreyPen +
                ", animalList=" + animalList +
                '}';
    }
}
