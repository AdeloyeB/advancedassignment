package com.company;

import java.util.ArrayList;
import java.util.List;

public class Zoo { //ALL ZOO INFO: PENS, ANIMALS AND EMPLOYEES ARE ALL STORED HERE
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

    public void penAdd(Pen pen){penListAdd(pen);}

    public void employeeAdd(Employee employee){employeeList.add(employee);}

    public Employee getEmployee(int x){
        Employee foundEmployee = employeeList.get(x);
        return foundEmployee;
    }


    public Employee newEmployee(String employeeFirstName, String employeeLastName, String employeePenType, String employeePenType2){
        Employee employee =  new Employee(employeeFirstName,employeeLastName, employeePenType, employeePenType2);
        employeeAdd(employee);
        return employee;
    }

    public Aquarium newAquarium(String name, String penType, Employee employeeOne, Employee employeeTwo){
        Aquarium aquarium = new Aquarium(name, penType, employeeOne, employeeTwo, 0, 120, false, false);
        penAdd(aquarium);
        return aquarium;
    }

    public Aviary newAviary(String name, String penType, Employee employeeOne, Employee employeeTwo){
        Aviary aviary = new Aviary(name, penType, employeeOne, employeeTwo, 0, 120, false, false);
        penAdd(aviary);
        return aviary;
    }

    public Dry newDry(String name, String penType, Employee employeeOne, Employee employeeTwo){
        Dry dry = new Dry(name, penType, employeeOne, employeeTwo, 120, 0, false, false);
        penAdd(dry);
        return dry;
    }

    public PartWetPartDry partWetPartDry(String name, String penType, Employee employeeOne, Employee employeeTwo){
        PartWetPartDry partWetPartDry = new PartWetPartDry(name, penType, employeeOne, employeeTwo, 60, 60, false, false);
        penAdd(partWetPartDry);
        return partWetPartDry;
    }

    public PettingPen newPettingPen(String name, String penType, Employee employeeOne, Employee employeeTwo){
        PettingPen pettingPen = new PettingPen(name, penType, employeeOne, employeeTwo, 120, 0, true, false);
        penAdd(pettingPen);
        return pettingPen;
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
