package com.company;

import java.util.List;

public class Dry extends Pen {

    private double area;

    public Dry(String id, String name, String penType, Employee employee, Employee employee2, boolean isHappyPen, boolean isPreyPen, double area) {
        super(id, name, penType, employee, employee2, isHappyPen, isPreyPen);
        this.area = area;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }
}