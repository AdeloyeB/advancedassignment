package com.company;

import java.util.List;

public class Aviary extends Pen {

    private double volume;
    private double area;

    public Aviary(String id, String name, String penType, Employee employee, Employee employee2, boolean isHappyPen, boolean isPreyPen, double volume, double area) {
        super(id, name, penType, employee, employee2, isHappyPen, isPreyPen);
        this.volume = volume;
        this.area = area;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }
}
