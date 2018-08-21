package com.company;

import java.util.ArrayList;
import java.util.List;

public class Zoo {
    private String zoo_name;
    private List<Employee> employeeList;
    private List<Pen> penList;
    private List<Animal> unListedAnimals;

    public Zoo(String zoo_name) {
        this.zoo_name = zoo_name;
        employeeList = new ArrayList<>();
        penList = new ArrayList<>();
        unListedAnimals = new ArrayList<>();
    }

    public String getZoo_name() {
        return zoo_name;
    }

    public void setZoo_name(String zoo_name) {
        this.zoo_name = zoo_name;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    public List<Pen> getPenList() {
        return penList;
    }

    public void setPenList(List<Pen> penList) {
        this.penList = penList;
    }

    public List<Animal> getUnListedAnimals() {
        return unListedAnimals;
    }

    public void setUnListedAnimals(List<Animal> unListedAnimals) {
        this.unListedAnimals = unListedAnimals;
    }

    public void unlistedAnimailsAdd(Animal x) {
        unListedAnimals.add(x);
    }

    public void unlistedAnimalRemove(Animal x){
        int removedAnimal = unListedAnimals.indexOf(x);
        unListedAnimals.remove(removedAnimal);
    }

    public void penListAdd(Pen x){penList.add(x);}

    @Override
    public String toString() {
        return "Zoo{" +
                "zoo_name='" + zoo_name + '\'' +
                ", employeeList=" + employeeList +
                ", penList=" + penList +
                ", unListedAnimals=" + unListedAnimals +
                '}';
    }
}
