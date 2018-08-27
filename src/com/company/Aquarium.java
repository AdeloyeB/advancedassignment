package com.company;

import java.util.List;

public class Aquarium extends Pen {

    protected boolean isAquarium;

    public Aquarium(String name, String penType, Employee employee, Employee employee2, double area, double volume, boolean isPettable, boolean isPreyPen) {
        super(name, penType, employee, employee2, area, volume, isPettable, isPreyPen);
        isAquarium = true;
    }

    public boolean isAquarium() {
        return isAquarium;
    }

    public void setAquarium(boolean aquarium) {
        isAquarium = aquarium;
    }
}

