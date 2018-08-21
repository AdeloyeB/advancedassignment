package com.company;

public interface IPen {

    void createDryPen();
    void createPettingPen();
    void createPartWetPartDryPen();
    void createAquariumPen();
    void createAviaryPen();

    Pen penNameCheck();
    void checkIfAnimalSuitableForPen(Animal tempAnimal);

    //LIST DIFFERENT PEN TYPES


}
