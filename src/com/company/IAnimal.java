package com.company;

public interface IAnimal {

    Animal createAnimal();
    void assignAnimal(Animal tempAnimal, Pen targetPen);
    String checkTypeAnimal();

    Animal getAnimal();

    void completeAssignAnimal();

    void checkIfAnimalSuitableForPen(Animal tempAnimal);

}
