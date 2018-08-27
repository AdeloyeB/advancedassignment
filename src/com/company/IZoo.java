package com.company;

public interface IZoo {

    void unlistedAnimailsAdd(Animal x);
    void unlistedAnimalRemove(Animal x);

    void penAdd(Pen pen);
    void employeeAdd(Employee employee);

    Employee newEmployee(String employeeFirstName, String employeeLastName, String employeePenType, String employeePenType2);
    Aquarium newAquarium(String name, String penType, Employee employeeOne, Employee employeeTwo);
    Aviary newAviary(String name, String penType, Employee employeeOne, Employee employeeTwo);
    Dry newDry(String name, String penType, Employee employeeOne, Employee employeeTwo);
    PartWetPartDry partWetPartDry(String name, String penType, Employee employeeOne, Employee employeeTwo);
    PettingPen newPettingPen(String name, String penType, Employee employeeOne, Employee employeeTwo);
}
