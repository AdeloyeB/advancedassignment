/*
PLEASE READ!!!
I HAVE NOT PLACED COMMENTS EVERYWHERE BECAUSE AS I HAVE ATTEMPTED TO USE
USEFUL FUNCTION NAME WHICH TELLS OTHER PROGRAMMERS WHAT THE FUNCTION DOES
 */

package com.company;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.IOException;

import java.io.File;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Controller implements IPen, IAnimal, IEmployee {
    private Gson gson;

    public Controller() {
        gson = new GsonBuilder().setPrettyPrinting().create();
        ;

    }

    Zoo zoo;

    {
        zoo = new Zoo("mainZoo");
    }


    API api = new API();

    public void getAPIData() { //RETRIEVES OPENEATHERMAP API DATA: WIND, TEMP, HUMIDITY

        api.getCurrentTime();
        api.getAPI();
    }

    public void globaLSave() { //STORE ALL DATA INTO THE ZOO OBJECT

        String zooJson = gson.toJson(zoo);

        try {
            File file = new File("globalSave.json");
            PrintWriter fileWriter =
                    new PrintWriter(file);
            fileWriter.write(zooJson);
            fileWriter.close();
        } catch (Exception e) {
            System.out.println(
                    "Error saving file: " + e.getMessage());
        }
    }

    public Zoo globalLoad() { //LOADS UP THE ZOO OBJECT AND TURNS IT INTO JAVA OBJECT. IF THE JSON DOES NOT EXIST IT WILL LOAD A FRESH SET OF DATA
        try {
            Path filePath = Paths.get("globalSave.json");
            String jsonString = new
                    String(Files.readAllBytes(filePath));
            System.out.println("Successfully Load Previous Data!");

            zoo =
                    gson.fromJson(jsonString, Zoo.class);
            return zoo;
        } catch (Exception e) {
            System.out.println("You must be a new User! \nHere is some fresh new zoo for you to manage");
            newDataLoad(); //LOAD FRESH SET OF DATA
        }
        return null;
    }

    //ANIMAL() IS RAN HERE AND ANIMAL IS ADDED TO UNLISTED LIST
    public Animal createAnimal() {
        try {
            Animal x = Animal();
            zoo.unlistedAnimailsAdd(x);
            System.out.println("Animal has successfully been created!");
            return x;
        } catch(Exception e){
            return null;
        }
    }

    //CREATES A NEW ANIMAL
    //IF AN ANIMAL BELONGS TO DRY OR PETTING PEN THEN THE VOLUME SHOULD BE ZERO
    public Animal Animal() {
        Scanner in = new Scanner(System.in);

        System.out.println("Enter name:");
        String name = in.next();

        System.out.println("Enter Specie:");
        String specie = in.next();

        System.out.println("Enter type:");
        String type = checkTypeAnimal();


        System.out.println("Is the animal going to remain in the water or/and in the air?");
        boolean airOrWaterChoice = checkValid();

        double area;
        double volume;
        if (airOrWaterChoice) {
            System.out.println("Volume that the Animal takes up?");
            area = 0;
            volume = in.nextDouble();
        } else {
            System.out.println("Area that the Animal takes up?");
            volume = 0;
            area = in.nextDouble();
        }


        System.out.println("Is the animal a prey?");
        boolean isPrey = checkValid();

        System.out.println("Is the animal happy?");
        boolean isPettable = checkValid();


        Animal animal = new Animal(name, specie, type, area, volume, isPrey, isPettable);


        return animal;

    }

    public Employee assignEmployeesDry() {
        Scanner in = new Scanner(System.in);
        System.out.println("Press 1 for Hardip\nPress 2 for Alan");

        Employee assignedEmployee = null;

        int choice = in.nextInt();

        switch (choice) {

            case 1:
                assignedEmployee = zoo.getEmployee(0);
                break;

            case 2:
                assignedEmployee = zoo.getEmployee(3);
                break;

            default:
                System.out.println("Wrong input");
                break;
        }
        return assignedEmployee;
    }

    public Employee assignEmployeesAquarium() {
        Scanner in = new Scanner(System.in);
        System.out.println("Press 1 for Alex\nPress 2 for Farhad");

        Employee assignedEmployee = null;

        int choice = in.nextInt();

        switch (choice) {

            case 1:
                assignedEmployee = zoo.getEmployee(1);
                break;

            case 2:
                assignedEmployee = zoo.getEmployee(2);
                break;

            default:
                System.out.println("Wrong input");
                break;
        }
        return assignedEmployee;
    }

    public Employee assignEmployeesAviary() {
        Scanner in = new Scanner(System.in);
        System.out.println("Press 1 for Hardip\nPress 2 for Farhad");

        Employee assignedEmployee = null;

        int choice = in.nextInt();

        switch (choice) {

            case 1:
                assignedEmployee = zoo.getEmployee(0);
                break;

            case 2:
                assignedEmployee = zoo.getEmployee(2);
                break;

            default:
                System.out.println("Wrong input");
                break;
        }
        return assignedEmployee;
    }

    public Employee assignEmployeesPartWetPartDry() {
        Scanner in = new Scanner(System.in);
        System.out.println("Press 1 for Alex");

        Employee assignedEmployee = null;

        int choice = in.nextInt();

        switch (choice) {

            case 1:
                assignedEmployee = zoo.getEmployee(1);
                break;


            default:
                System.out.println("Wrong input");
                break;
        }
        return assignedEmployee;
    }


    public Employee assignEmployeesPettingPen() {
        Scanner in = new Scanner(System.in);
        System.out.println("Press 1 for Alan");

        Employee assignedEmployee = null;

        int choice = in.nextInt();

        switch (choice) {

            case 1:
                assignedEmployee = zoo.getEmployee(3);
                break;


            default:
                System.out.println("Wrong input");
                break;
        }
        return assignedEmployee;
    }


    public void createDryPen() {
        Scanner in = new Scanner(System.in);

        System.out.println("Enter name:\n");
        String name = in.next();

        String penType = "dry";

        Employee assignedEmployee = assignEmployeesDry();

        Employee assignedEmployee2 = assignEmployeesDry();

        boolean isPettable = false;

        System.out.println("Is the pen for weak animals?");
        boolean isPrey = checkValid();

        System.out.println("Area of the pen takes up?");
        double area = in.nextDouble();

        Dry dry = new Dry(name, penType, assignedEmployee, assignedEmployee2, area, 0, isPettable, isPrey);

        String json = gson.toJson(dry);
        zoo.penListAdd(dry);
    }


    public void createAquariumPen() {
        Scanner in = new Scanner(System.in);

        System.out.println("Enter name:");
        String name = in.next();

        String penType = "aquarium";

        Employee assignedEmployee = assignEmployeesAquarium();

        Employee assignedEmployee2 = assignEmployeesAquarium();

        boolean isPettable = true;

        System.out.println("Is the pen for weak animals?");
        boolean isPrey = checkValid();


        System.out.println("Volume of the pen takes up?");
        double volume = in.nextDouble();


        Aquarium aquarium = new Aquarium(name, penType, assignedEmployee, assignedEmployee2, 0, volume, isPettable, isPrey);

        String json = gson.toJson(aquarium);
        zoo.penListAdd(aquarium);
    }

    public void createPartWetPartDryPen() {
        Scanner in = new Scanner(System.in);

        System.out.println("Enter name:");
        String name = in.next();

        String penType = "partwetpartdry";

        boolean isPettable = true;

        System.out.println("Is the pen for weak animals?");
        boolean isPrey = checkValid();

        System.out.println("Area of the pen takes up?");
        double area = in.nextDouble();

        System.out.println("Volume of water the pen takes up?");
        double volume = in.nextDouble();

        Employee assignedEmployee = assignEmployeesPartWetPartDry();

        Employee assignedEmployee2 = assignedEmployee; //REQUIREMENTS ONLY REQUIRE FOR ONE ZOOKEEPER

        PartWetPartDry partWetPartDry = new PartWetPartDry(name, penType, assignedEmployee, assignedEmployee2, area, volume, isPettable, isPrey);

        String json = gson.toJson(partWetPartDry);
        zoo.penListAdd(partWetPartDry);
    }

    public void createPettingPen() {
        Scanner in = new Scanner(System.in);

        System.out.println("Enter name:");
        String name = in.next();

        String penType = "pettingpen";

        Employee assignedEmployee = assignEmployeesPettingPen();

        Employee assignedEmployee2 = assignedEmployee;

        boolean isPettable = true;

        System.out.println("Is the pen for weak animals?");
        boolean isPrey = checkValid();

        System.out.println("Area of the pen takes up?");
        double area = in.nextDouble();

        PettingPen pettingPen = new PettingPen(name, penType, assignedEmployee, assignedEmployee2, area, 0, isPettable, isPrey);

        String json = gson.toJson(pettingPen);
        zoo.penListAdd(pettingPen);
    }

    public void createAviaryPen() {
        Scanner in = new Scanner(System.in);

        System.out.println("Enter name:");
        String name = in.next();

        String penType = "aviary";

        Employee assignedEmployee = assignEmployeesAviary();

        Employee assignedEmployee2 = assignEmployeesAviary();

        boolean isPettable = true;

        System.out.println("Is the pen for weak animals?");
        boolean isPrey = checkValid();

        System.out.println("Volume of the pen takes up?");
        double volume = in.nextDouble();

        System.out.println("Area of the pen takes up?");
        double area = in.nextDouble();

        Aviary aviary = new Aviary(name, penType, assignedEmployee, assignedEmployee2, area, volume, isPettable, isPrey);

        String json = gson.toJson(aviary);
        zoo.penListAdd(aviary);
        System.out.println(json);
    }

    public void typeOfPen() { //ASKS USER FOR THE TYPE OF PEN THEY WANT TO CREATE AND FUNCTION CREATES THE TYPE
        Scanner in = new Scanner(System.in);
        System.out.println("Press 1 for Dry\nPress 2 for Aquarium\nPress 3 for PartWetPartDry\nPress 4 for PettingPen\nPress 5 for Aviary\n");

        int choice = in.nextInt();

        switch (choice) {

            case 1:
                createDryPen();
                System.out.println("Sucessfully Created!");
                break;

            case 2:
                createAquariumPen();
                System.out.println("Sucessfully Created!");
                break;

            case 3:
                createPartWetPartDryPen();
                System.out.println("Sucessfully Created!");
                break;

            case 4:
                createPettingPen();
                System.out.println("Sucessfully Created!");
                break;

            case 5:
                createAviaryPen();
                System.out.println("Sucessfully Created!");
                break;

            default:
                System.out.println("Wrong input");
                break;
        }
    }


    public String checkTypeAnimal() {
        String animalType;

        Scanner in = new Scanner(System.in);
        System.out.println("Press 1 for Mammal\nPress 2 for Dinosaur\nPress 3 for Aquatic\nPress 4 for Insect\nPress 5 for Amphibians");
        int choice = in.nextInt();

        switch (choice) {
            case 1:
                animalType = "mammal";
                break;

            case 2:
                animalType = "dinosaur";
                break;

            case 3:
                animalType = "aquatic";
                break;

            case 4:
                animalType = "insect";
                break;

            case 5:
                animalType = "amphibians";
                break;

            case 6:
                animalType = "flying";
                break;

            default:
                System.out.println("Wrong input");
                animalType = null;
                break;
        }
        return animalType;
    }


    public boolean checkValid() {
        Scanner in = new Scanner(System.in);
        System.out.println("Please Press 1 for Yes and 2 for No:");

        boolean isValid = true;
        int choice = in.nextInt();
        switch (choice) {
            case 1:
                isValid = true;
                break;

            case 2:
                isValid = false;
                break;

            default:
                System.out.println("Wrong Input");
                break;
        }

        return isValid;
    }

    public Animal animalNameCheck() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter name of the animal you want to assign to confirm with the program");

        String tempAnimal = in.next().toLowerCase();
        Animal tempAnimalObject = null;

        for (Animal animal : zoo.getUnListedAnimals()) {
            //System.out.println(animal.name+"     "+tempAnimal);
            if (animal.name.toLowerCase().equals(tempAnimal)) {
                tempAnimalObject = animal;
                //System.out.println(tempAnimalObject);
            }
        }
        return tempAnimalObject;
    }

    public Pen penNameCheck() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the name of the Pen you want");

        String tempPen = in.next().toLowerCase();
        Pen tempPenObject = null;

        for (Pen pen : zoo.getPenList()) {
            if (pen.name.toLowerCase().equals(tempPen)) {
                tempPenObject = pen;
            }
        }
        return tempPenObject;
    }


    public void assignAnimal(Animal tempAnimal, Pen targetPen) {
        targetPen.setRemainingArea(calcArea(tempAnimal, targetPen));
        targetPen.setRemainingVolume(calcVol(tempAnimal, targetPen));
    }

    public double calcArea(Animal tempAnimal, Pen targetPen) {
        double x = tempAnimal.getArea();
        double y = targetPen.remainingArea;

        double value = y - x;
        if (value >= 0) {
            targetPen.addAnimal(tempAnimal);
            zoo.unlistedAnimalRemove(tempAnimal);
            System.out.println("Animal Successfuly Transferred as a Land animal");
            return value;
        } else {
            System.out.println("Not enough space as a land animal");
            return targetPen.remainingArea;
        }
    }

    public double calcVol(Animal tempAnimal, Pen targetPen) {
        double x = tempAnimal.getVolume();
        double y = targetPen.remainingVolume;

        double value = y - x;
        if (value > 0) {
            targetPen.addAnimal(tempAnimal);
            zoo.unlistedAnimalRemove(tempAnimal);
            System.out.println("Animal Successfuly Transferred as a air or Water animal");
            return value;
        } else {
            System.out.println("Not enough space as a air or water animal");
            return targetPen.remainingVolume;
        }
    }

    public void completeAssignAnimal() {

        //ALL PENS ARE PRINTED TO THE SCREEN REGARDLESS OF WHAT THE ANIMAL CAN GO INTO.
        Animal getAnimal = getAnimal();
        checkIfAnimalSuitableForPen(getAnimal);
        Animal transferAnimal = animalNameCheck();
        Pen targetedPen = penNameCheck();
        assignAnimal(transferAnimal, targetedPen);
    }


    public void listUnlistedAnimal() {
        System.out.println("Unlisted Animals:");
        for (Animal animal : zoo.getUnListedAnimals()) {
            System.out.println("Animal ID: " + animal.id);
            System.out.println("Animal Name: " + animal.name);
            System.out.println("Animal Specie: " + animal.getSpecie());
            System.out.println("Animal Pen Type: " + animal.getType());

        }
    }

    public Animal getAnimal() {
        listUnlistedAnimal();
        Scanner in = new Scanner(System.in);
        System.out.println("Enter name of the animal you want to assign");

        String tempAnimal = in.next().toLowerCase();
        Animal tempAnimalObject = null;

        for (Animal animal : zoo.getUnListedAnimals()) {
            if (animal.name.toLowerCase().equals(tempAnimal)) {
                tempAnimalObject = animal;
            }
        }
        return tempAnimalObject;

    }

    public void listPens() {
        for (Pen pen : zoo.getPenList()) {
            System.out.println("Pen ID: " + pen.id);
            System.out.println("Pen Name: " + pen.name);
            System.out.println("Pen Type: " + pen.getPenType());
            System.out.println("Total Pen Area: " + pen.getArea());
            System.out.println("Remaining Pen Area: " + pen.getRemainingArea());
            System.out.println("Total Pen Volume: " + pen.getVolume());
            System.out.println("Remaining Pen Volume: " + pen.getRemainingVolume());
            if (pen.employee.equals(pen.employee2)) {
                System.out.println("Assigned Employee One: " + pen.employee.name);
            } else {
                System.out.println("Assigned Employee One: " + pen.employee.name);
                System.out.println("Assigned Employee Two: " + pen.employee2.name);
            }
            System.out.println("Animals in this pen: " + pen.getAnimalList() + "\n");
        }
    }

    public void checkIfAnimalSuitableForPen(Animal tempAnimal) {
        try {
            if (tempAnimal.getType().equals("mammal")) {
                listDryPens();
                listPartWetPartDryPens();
            } else if (tempAnimal.getType().equals("aquatic")) {
                listAquariumPens();
                listPartWetPartDryPens();
                listAquariumPens();
            } else if (tempAnimal.getType().equals("dinosaur")) {
                listDryPens();
                listPartWetPartDryPens();
            } else if (tempAnimal.getType().equals("insect")) {
                listDryPens();
                listPartWetPartDryPens();
            } else if (tempAnimal.getType().equals("amphibians")) {
                listDryPens();
                listPartWetPartDryPens();
                listAquariumPens();
            } else if (tempAnimal.getType().equals("flying")) {
                listAviaryPens();
            } else if (tempAnimal.getType().equals("mammal") && tempAnimal.isPettable()) {
                listDryPens();
                listPettingPens();
            } else if (tempAnimal.getType().equals("dinosaur") && tempAnimal.isPettable()) {
                listDryPens();
                listPettingPens();
            } else if (tempAnimal.getType().equals("insect") && tempAnimal.isPettable()) {
                listPettingPens();
            } else if (tempAnimal.getType().equals("amphibians") && tempAnimal.isPettable()) {
                listPettingPens();
            } else if (tempAnimal.getType().equals("flying") && tempAnimal.isPettable()) {
                listPettingPens();
            } else if (tempAnimal.getType().equals("flying") && !tempAnimal.isPrey()) {
                listAviaryPensIsPredator();
            } else if (tempAnimal.getType().equals("mammal") && !tempAnimal.isPrey()) {
                listPartWetPartDryPensIsPredator();
                listDryPensIsPredator();
            } else if (tempAnimal.getType().equals("aquatic") && !tempAnimal.isPrey()) {
                listAquariumPensIsPredator();
                listPartWetPartDryPensIsPredator();
            } else if (tempAnimal.getType().equals("dinosaur") && !tempAnimal.isPrey()) {
                listPartWetPartDryPensIsPredator();
                listDryPensIsPredator();
            } else if (tempAnimal.getType().equals("insect") && !tempAnimal.isPrey()) {
                listDryPensIsPredator();
                listPartWetPartDryPensIsPredator();
            } else if (tempAnimal.getType().equals("amphibians") && !tempAnimal.isPrey()) {
                listDryPens();
                listPartWetPartDryPensIsPredator();
                listAquariumPensIsPredator();
            } else {
                System.out.println("Animal is not suitable for this pen. please try again");
            }
        } catch (Exception e) {
            System.out.println("Wrong input. please try again");
        }

    }

    public void listDryPensIsPredator() {
        try {
            for (Pen pen : zoo.getPenList()) {
                if ((pen.getPenType().equals("dry")) && (!pen.isPreyPen()))
                    System.out.println("Pen ID: " + pen.id);
                System.out.println("Pen Name: " + pen.name);
                System.out.println("Pen Type: " + pen.getPenType());
                System.out.println("Total Pen Area: " + pen.getArea());
                System.out.println("Remaining Pen Area: " + pen.getRemainingArea());
                System.out.println("Total Pen Volume: " + pen.getVolume());
                System.out.println("Remaining Pen Volume: " + pen.getRemainingVolume());
                if (pen.employee.equals(pen.employee2)) {
                    System.out.println("Assigned Employee One: " + pen.employee.name);
                } else {
                    System.out.println("Assigned Employee One: " + pen.employee.name);
                    System.out.println("Assigned Employee Two: " + pen.employee2.name);
                }
                System.out.println("Animals in this pen: " + pen.getAnimalList() + "\n");
            }
        } catch (Exception e) {
            System.out.println("We couldn't list the Dry Predator Pens!");
        }
    }

    public void listPartWetPartDryPensIsPredator() {
        try {
            for (Pen pen : zoo.getPenList()) {
                if ((pen.getPenType().equals("partwetpartdry")) && (!pen.isPreyPen()))
                    System.out.println("Pen ID: " + pen.id);
                System.out.println("Pen Name: " + pen.name);
                System.out.println("Pen Type: " + pen.getPenType());
                System.out.println("Total Pen Area: " + pen.getArea());
                System.out.println("Remaining Pen Area: " + pen.getRemainingArea());
                System.out.println("Total Pen Volume: " + pen.getVolume());
                System.out.println("Remaining Pen Volume: " + pen.getRemainingVolume());
                if (pen.employee.equals(pen.employee2)) {
                    System.out.println("Assigned Employee One: " + pen.employee.name);
                } else {
                    System.out.println("Assigned Employee One: " + pen.employee.name);
                    System.out.println("Assigned Employee Two: " + pen.employee2.name);
                }
                System.out.println("Animals in this pen: " + pen.getAnimalList() + "\n");
            }
        } catch (Exception e) {
            System.out.println("We couldn't list the part wat part dry predator pens!");
        }
    }

    public void listAquariumPensIsPredator() {
        for (Pen pen : zoo.getPenList()) {
            if ((pen.getPenType().equals("aquarium")) && (!pen.isPreyPen())) {
                System.out.println("Pen ID: " + pen.id);
                System.out.println("Pen Name: " + pen.name);
                System.out.println("Pen Type: " + pen.getPenType());
                System.out.println("Total Pen Area: " + pen.getArea());
                System.out.println("Remaining Pen Area: " + pen.getRemainingArea());
                System.out.println("Total Pen Volume: " + pen.getVolume());
                System.out.println("Remaining Pen Volume: " + pen.getRemainingVolume());
                if (pen.employee.equals(pen.employee2)) {
                    System.out.println("Assigned Employee One: " + pen.employee.name);
                } else {
                    System.out.println("Assigned Employee One: " + pen.employee.name);
                    System.out.println("Assigned Employee Two: " + pen.employee2.name);
                }
                System.out.println("Animals in this pen: " + pen.getAnimalList() + "\n");
            }
        }
    }

    public void listAviaryPensIsPredator() {
        for (Pen pen : zoo.getPenList()) {
            if (pen.getPenType().equals("aviary") && (!pen.isPreyPen())) {
                System.out.println("Pen ID: " + pen.id);
                System.out.println("Pen Name: " + pen.name);
                System.out.println("Pen Type: " + pen.getPenType());
                System.out.println("Total Pen Area: " + pen.getArea());
                System.out.println("Remaining Pen Area: " + pen.getRemainingArea());
                System.out.println("Total Pen Volume: " + pen.getVolume());
                System.out.println("Remaining Pen Volume: " + pen.getRemainingVolume());
                if (pen.employee.equals(pen.employee2)) {
                    System.out.println("Assigned Employee One: " + pen.employee.name);
                } else {
                    System.out.println("Assigned Employee One: " + pen.employee.name);
                    System.out.println("Assigned Employee Two: " + pen.employee2.name);
                }
                System.out.println("Animals in this pen: " + pen.getAnimalList() + "\n");
            }
        }
    }

    public void listDryPens() {
        for (Pen pen : zoo.getPenList()) {
            if (pen.getPenType().equals("dry")) {
                System.out.println("Pen ID: " + pen.id);
                System.out.println("Pen Name: " + pen.name);
                System.out.println("Pen Type: " + pen.getPenType());
                System.out.println("Total Pen Area: " + pen.getArea());
                System.out.println("Remaining Pen Area: " + pen.getRemainingArea());
                System.out.println("Total Pen Volume: " + pen.getVolume());
                System.out.println("Remaining Pen Volume: " + pen.getRemainingVolume());
                if (pen.employee.equals(pen.employee2)) {
                    System.out.println("Assigned Employee One: " + pen.employee.name);
                } else {
                    System.out.println("Assigned Employee One: " + pen.employee.name);
                    System.out.println("Assigned Employee Two: " + pen.employee2.name);
                }
                System.out.println("Animals in this pen: " + pen.getAnimalList() + "\n");
            }
        }
    }

    public void listPettingPens() {
        for (Pen pen : zoo.getPenList()) {
            if (pen.getPenType().equals("pettingpen")) {
                System.out.println("Pen ID: " + pen.id);
                System.out.println("Pen Name: " + pen.name);
                System.out.println("Pen Type: " + pen.getPenType());
                System.out.println("Total Pen Area: " + pen.getArea());
                System.out.println("Remaining Pen Area: " + pen.getRemainingArea());
                System.out.println("Total Pen Volume: " + pen.getVolume());
                System.out.println("Remaining Pen Volume: " + pen.getRemainingVolume());
                if (pen.employee.equals(pen.employee2)) {
                    System.out.println("Assigned Employee One: " + pen.employee.name);
                } else {
                    System.out.println("Assigned Employee One: " + pen.employee.name);
                    System.out.println("Assigned Employee Two: " + pen.employee2.name);
                }
                System.out.println("Animals in this pen: " + pen.getAnimalList() + "\n");
            }
        }
    }

    public void listPartWetPartDryPens() {
        for (Pen pen : zoo.getPenList()) {
            if (pen.getPenType().equals("partwetpartdry")) {
                System.out.println("Pen ID: " + pen.id);
                System.out.println("Pen Name: " + pen.name);
                System.out.println("Pen Type: " + pen.getPenType());
                System.out.println("Total Pen Area: " + pen.getArea());
                System.out.println("Remaining Pen Area: " + pen.getRemainingArea());
                System.out.println("Total Pen Volume: " + pen.getVolume());
                System.out.println("Remaining Pen Volume: " + pen.getRemainingVolume());
                if (pen.employee.equals(pen.employee2)) {
                    System.out.println("Assigned Employee One: " + pen.employee.name);
                } else {
                    System.out.println("Assigned Employee One: " + pen.employee.name);
                    System.out.println("Assigned Employee Two: " + pen.employee2.name);
                }
                System.out.println("Animals in this pen: " + pen.getAnimalList() + "\n");
            }
        }
    }

    public void listAquariumPens() {
        for (Pen pen : zoo.getPenList()) {
            if (pen.getPenType().equals("aquarium")) {
                System.out.println("Pen ID: " + pen.id);
                System.out.println("Pen Name: " + pen.name);
                System.out.println("Pen Type: " + pen.getPenType());
                System.out.println("Total Pen Area: " + pen.getArea());
                System.out.println("Remaining Pen Area: " + pen.getRemainingArea());
                System.out.println("Total Pen Volume: " + pen.getVolume());
                System.out.println("Remaining Pen Volume: " + pen.getRemainingVolume());
                if (pen.employee.equals(pen.employee2)) {
                    System.out.println("Assigned Employee One: " + pen.employee.name);
                } else {
                    System.out.println("Assigned Employee One: " + pen.employee.name);
                    System.out.println("Assigned Employee Two: " + pen.employee2.name);
                }
                System.out.println("Animals in this pen: " + pen.getAnimalList() + "\n");
            }
        }
    }

    public void listAviaryPens() {
        for (Pen pen : zoo.getPenList()) {
            if (pen.getPenType().equals("aviary")) {
                System.out.println("Pen ID: " + pen.id);
                System.out.println("Pen Name: " + pen.name);
                System.out.println("Pen Type: " + pen.getPenType());
                System.out.println("Total Pen Area: " + pen.getArea());
                System.out.println("Remaining Pen Area: " + pen.getRemainingArea());
                System.out.println("Total Pen Volume: " + pen.getVolume());
                System.out.println("Remaining Pen Volume: " + pen.getRemainingVolume());
                if (pen.employee.equals(pen.employee2)) {
                    System.out.println("Assigned Employee One: " + pen.employee.name);
                } else {
                    System.out.println("Assigned Employee One: " + pen.employee.name);
                    System.out.println("Assigned Employee Two: " + pen.employee2.name);
                }
                System.out.println("Animals in this pen: " + pen.getAnimalList() + "\n");
            }
        }
    }

    public void employeeCheck() { //CREATE EMPLOYEES THAT USERS WILL USE, USERS ARE UNABLE TO CREATE NEW EMPLOYEES
        if (zoo.getEmployeeList().isEmpty()) {
            zoo.newEmployee("Hardip", "Ian", "dry", "aviary");
            zoo.newEmployee("Alex", "Casper", "aquarium", "partwetpartdry");

            zoo.newEmployee("Farhad", "Keissarian", "aquarium", "aviary");
            zoo.newEmployee("Alan", "Reynolds", "dry", "pettingpen");
        }
    }

    public void listEmployees() {
        for (Employee employee : zoo.getEmployeeList()) {
            System.out.println("ID: " + employee.id);
            System.out.println("Full Name: " + employee.name + " " + employee.getLast_name());
            System.out.println("Manages " + employee.employeePenType + " and " + employee.employeePenType2 + "\n");
        }
    }

    public void defaultPenCheck() { //CREATES BASIC PENS
        try {
            if (zoo.getPenList().isEmpty()) {
                zoo.newDry("Dry", "dry", zoo.getEmployee(0), zoo.getEmployee(2));
                zoo.newAquarium("Aquarium", "aquarium", zoo.getEmployee(1), zoo.getEmployee(0));
                zoo.newAviary("Aviary", "aviary", zoo.getEmployee(3), zoo.getEmployee(1));
                zoo.newPettingPen("PettingPen", "pettingpen", zoo.getEmployee(2), zoo.getEmployee(1));
            }
        } catch (Exception e) {
            System.out.println("We couldn't create a fresh new save for you! Try again please");
        }
    }

    public void newDataLoad() { // GETS EMPLOYEE DATA AND DEFAULT PEN DATA
        System.out.println("New Save File Created!");
        employeeCheck();
        defaultPenCheck();
    }
}


