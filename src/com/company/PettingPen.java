package com.company;

import java.util.List;

public class PettingPen extends Pen {

    protected boolean isPettingPen;

    public PettingPen(String name, String penType, Employee employee, Employee employee2, double area, double volume, boolean isPettable, boolean isPreyPen) {
        super(name, penType, employee, employee2, area, volume, isPettable, isPreyPen);
        isPettingPen = true;
    }
}