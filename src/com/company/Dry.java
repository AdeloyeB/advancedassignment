package com.company;

import java.util.List;

public class Dry extends Pen {

   protected boolean isDry;

    public Dry( String name, String penType, Employee employee, Employee employee2, double area, double volume, boolean isPettable, boolean isPreyPen) {
        super(name, penType, employee, employee2, area, volume, isPettable, isPreyPen);
        isDry = true;
    }

    public boolean isDry() {
        return isDry;
    }

    public void setDry(boolean dry) {
        isDry = dry;
    }
}