package com.company;



public class Animal extends LivingCreature {
    private String specie;
    private String type;
    private double area;
    private double volume;
    private boolean isPrey;
    private boolean isHappy;

    public Animal(String name, String specie, String type, double area, double volume, boolean isPrey, boolean isHappy) {
        super(name);
        this.specie = specie;
        this.type = type;
        this.area = area;
        this.volume = volume;
        this.isPrey = isPrey;
        this.isHappy = isHappy;
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

    public boolean isHappy() {
        return isHappy;
    }

    public void setHappy(boolean happy) {
        isHappy = happy;
    }

    @Override
    public String toString() {
        return "Animal{" +
                ", id='" + id + '\'' +
                ", name='" + name + '\'' +
                "specie='" + specie + '\'' +
                ", type='" + type + '\'' +
                ", area=" + area +
                ", volume=" + volume +
                ", isPrey=" + isPrey +
                ", isHappy=" + isHappy +
                '}';
    }
}

