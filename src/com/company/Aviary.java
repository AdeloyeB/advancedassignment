package com.company;

import java.util.List;

public class Aviary extends Pen {

    protected boolean isAviary;

    public Aviary(String name, String penType, Employee employee, Employee employee2, double area, double volume, boolean isPettable, boolean isPreyPen) {
        super(name, penType, employee, employee2, area, volume, isPettable, isPreyPen);
        isAviary = true;
    }
}
