package com.company;



public class Animal extends LivingCreature {
    private String specie;
    private String type;
    private double area;
    private double volume;
    private boolean isPrey;
    private boolean isPettable;

    public Animal(String name, String specie, String type, double area, double volume, boolean isPrey, boolean isPettable) {
        super(name);
        this.specie = specie;
        this.type = type;
        this.area = area;
        this.volume = volume;
        this.isPrey = isPrey;
        this.isPettable = isPettable;
    }

    public String getSpecie() {
        return specie;
    }

    public void setSpecie(String specie) {
        this.specie = specie;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public boolean isPrey() {
        return isPrey;
    }

    public void setPrey(boolean prey) {
        isPrey = prey;
    }

    public boolean isPettable() {
        return isPettable;
    }

    public void setPettable(boolean pettable) {
        isPettable = pettable;
    }
}

