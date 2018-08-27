package com.company;

public interface IPen {

    void createDryPen();
    void createPettingPen();
    void createPartWetPartDryPen();
    void createAquariumPen();
    void createAviaryPen();

    Pen penNameCheck();
    void checkIfAnimalSuitableForPen(Animal tempAnimal);

    double calcVol(Animal tempAnimal, Pen targetPen);
    double calcArea(Animal tempAnimal, Pen targetPen);


    //LIST DIFFERENT PEN TYPES
    void listDryPensIsPredator();
    void listPartWetPartDryPensIsPredator();
    void listAquariumPensIsPredator();
    void listAviaryPensIsPredator();

    void listDryPens();
    void listPettingPens();
    void listPartWetPartDryPens();
    void listAquariumPens();
    void listAviaryPens();
}
