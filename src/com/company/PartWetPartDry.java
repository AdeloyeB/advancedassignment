package com.company;

import java.util.List;

public class PartWetPartDry extends Pen {

    private double areaofLand;
    private double areaofWater;
    private double volumeofWater;

    public PartWetPartDry(String id, String name, String penType, Employee employee, Employee employee2, double areaofLand, double areaofWater, double volumeofWater) {
        super(id, name, penType, employee, employee2);
        this.areaofLand = areaofLand;
        this.areaofWater = areaofWater;
        this.volumeofWater = volumeofWater;
    }

    public double getAreaofLand() {
        return areaofLand;
    }

    public void setAreaofLand(double areaofLand) {
        this.areaofLand = areaofLand;
    }

    public double getAreaofWater() {
        return areaofWater;
    }

    public void setAreaofWater(double areaofWater) {
        this.areaofWater = areaofWater;
    }

    public double getVolumeofWater() {
        return volumeofWater;
    }

    public void setVolumeofWater(double volumeofWater) {
        this.volumeofWater = volumeofWater;
    }
}
