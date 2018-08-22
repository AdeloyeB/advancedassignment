package com.company;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Controller implements IPen, IAnimal, IProgram{
    private Gson gson;

    public Controller() {
        gson = new GsonBuilder().setPrettyPrinting().create();;

    }
    Zoo zoo;

    {
        zoo = new Zoo("mainZoo");
    }


    API api = new API();

    public void getAPIData(){
        //RETRIEVES OPENEATHERMAP API DATA: WIND, TEMP, HUMIDITY
        Scanner in = new Scanner(System.in);

        String choice = in.next();

        while(true){
            switch (choice.toLowerCase()) {
                case "r":
                    api.getAPI();
                    return;
                case "q":
                    break;

                default:
                    System.out.println("Wrong value");
            }
        }
    }

    //REFACTOR THIS CODE SO IT ONLY RUNS IF THE OBJECTS DON'T EXIST. CHEAT METHOD: RUN ONCE THEN DELETE THE OBJECTS ONCE PROPERLY STORED IN THE JSON
    public void globaLSave(){

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

    public Zoo globalLoad(){
        try {
            Path filePath = Paths.get("globalSave.json");
            String jsonString = new
                    String(Files.readAllBytes(filePath));
            System.out.println(jsonString);

             zoo =
                    gson.fromJson(jsonString, Zoo.class);
            System.out.println("Loaded!");
            return zoo;
        } catch (Exception e) {
            System.out.println("You must be a new User! \nHere is some fresh new zoo for you to manage");
            newDataLoad();
        }
        return null;
    }

    //ANIMAL() IS RAN HERE AND ANIMAL IS ADDED TO UNLISTED LIST
    public Animal createAnimal(){
        Animal x = Animal();
        zoo.unlistedAnimailsAdd(x);
        //String json = new Gson().toJson(unListedAnimals);
        System.out.println(zoo.getUnListedAnimals());
        globaLSave();
        return x;
    }

    //CREATES A NEW ANIMAL
    //IF AN ANIMAL BELONGS TO DRY OR PETTING PEN THEN THE VOLUME SHOULD BE ZERO
    public Animal Animal(){
        Scanner in = new Scanner(System.in);

        System.out.println("Enter name:\n");
        String name = in.next();

        System.out.println("Enter Specie:\n");
        String specie = in.next();

        System.out.println("Enter type:\n");
        String type = checkTypeAnimal();


        System.out.println("Is the animal going to remain in the water or/and in the air?");
        boolean airOrWaterChoice = checkValid();

        double area;
        System.out.println("Area that the Animal takes up?\n");
        if(airOrWaterChoice){
            area = 0;
        }
        else{
            area = in.nextDouble();
        }


        System.out.println("Is the animal going to remain on Land?");
        boolean landChoice = checkValid();
        double volume;

        if(landChoice){
            volume = 0;
        } else{
            System.out.println("Volume that the Animal takes up?\n");
            volume = in.nextDouble();
        }



        System.out.println("Is the animal a prey?\n");
        boolean isPrey = checkValid();

        System.out.println("Is the animal happy?\n");
        boolean isHappy = checkValid();



        Animal animal = new Animal(name, specie,type, area, volume, isPrey, isHappy);

        //String json = gson.toJson(animal);

        return animal;

    }

    public Employee assignEmployees(){
        Scanner in = new Scanner(System.in);
        System.out.println("Press 1 for Ian\nPress 2 for Alex\nPress 3 for Troy\nPress 4 for Kate\n");

        Employee assignedEmployee = null;

        int choice = in.nextInt();

        switch (choice) {

            case 1:
                assignedEmployee = zoo.getEmployee(choice);
                break;

            case 2:
                assignedEmployee = zoo.getEmployee(choice);
                break;

            case 3:
                assignedEmployee = zoo.getEmployee(choice);
                break;

            case 4:
                assignedEmployee = zoo.getEmployee(choice);
                break;

            default:
                System.out.println("Wrong input");
                break;
        }
        return assignedEmployee;
    }

    public void createDryPen(){
        Scanner in = new Scanner(System.in);

        System.out.println("Enter name:\n");
        String name = in.next();

        String penType = "dry";

        Employee assignedEmployee = assignEmployees();

        Employee assignedEmployee2 = assignEmployees();

        boolean isPettable = false;

        System.out.println("Is the pen for weak animals?\n");
        boolean isPrey = checkValid();

        System.out.println("Area of the pen takes up?\n");
        double area = in.nextDouble();

        Dry dry = new Dry(name,penType, assignedEmployee,assignedEmployee2, area, 0 ,isPettable, isPrey);

        String json = gson.toJson(dry);
        zoo.penListAdd(dry);
        System.out.println(json);
    }


    public void createAquariumPen(){
            Scanner in = new Scanner(System.in);

            System.out.println("Enter name:\n");
            String name = in.next();

            String penType = "aquarium";

            Employee assignedEmployee = assignEmployees();

            Employee assignedEmployee2 = assignEmployees();

            boolean isPettable = true;

            System.out.println("Is the pen for weak animals?\n");
            boolean isPrey = checkValid();


        System.out.println("Volume of the pen takes up?\n");
            double volume = in.nextDouble();

            System.out.println("Area of the pen takes up?\n");
            double area = in.nextDouble();

            Aquarium aquarium = new Aquarium(name,penType, assignedEmployee, assignedEmployee2,area, volume, isPettable, isPrey);

            String json = gson.toJson(aquarium);
            zoo.penListAdd(aquarium);
            System.out.println(json);
        }

        public void createPartWetPartDryPen(){
        Scanner in = new Scanner(System.in);

        System.out.println("Enter name:\n");
        String name = in.next();

        String penType = "partwetpartdry";

        boolean isPettable = true;

        System.out.println("Is the pen for weak animals?\n");
        boolean isPrey = checkValid();

        System.out.println("Area of the pen takes up?\n");
        double area = in.nextDouble();

        System.out.println("Volume of water the pen takes up?\n");
        double volume = in.nextDouble();

        Employee assignedEmployee = assignEmployees();

        Employee assignedEmployee2 = assignEmployees();

        PartWetPartDry partWetPartDry = new PartWetPartDry(name,penType, assignedEmployee, assignedEmployee2,area, volume, isPettable, isPrey);

        String json = gson.toJson(partWetPartDry);
        zoo.penListAdd(partWetPartDry);
        System.out.println(json);
    }

    public void createPettingPen(){
        Scanner in = new Scanner(System.in);

        System.out.println("Enter name:\n");
        String name = in.next();

        String penType = "pettingpen";

        Employee assignedEmployee = assignEmployees();

        Employee assignedEmployee2 = assignEmployees();

        boolean isPettable = true;

        System.out.println("Is the pen for weak animals?\n");
        boolean isPrey = checkValid();

        System.out.println("Area of the pen takes up?\n");
        double area = in.nextDouble();

        PettingPen pettingPen = new PettingPen(name,penType, assignedEmployee, assignedEmployee2,area, 0, isPettable, isPrey);

        String json = gson.toJson(pettingPen);
        zoo.penListAdd(pettingPen);
        System.out.println(json);
    }

    public void createAviaryPen(){
        Scanner in = new Scanner(System.in);

        System.out.println("Enter name:\n");
        String name = in.next();

        String penType = "aviary";

        Employee assignedEmployee = assignEmployees();

        Employee assignedEmployee2 = assignEmployees();

        boolean isPettable = true;

        System.out.println("Is the pen for weak animals?\n");
        boolean isPrey = checkValid();

        System.out.println("Volume of the pen takes up?\n");
        double volume = in.nextDouble();

        System.out.println("Area of the pen takes up?\n");
        double area = in.nextDouble();

        Aviary aviary = new Aviary(name,penType, assignedEmployee, assignedEmployee2,area, volume, isPettable, isPrey);

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
                    break;

                case 2:
                    createAquariumPen();
                    break;

                case 3:
                    createPartWetPartDryPen();
                    break;

                case 4:
                    createPettingPen();
                    break;

                case 5:
                    createAviaryPen();
                    break;

                default:
                    System.out.println("Wrong input");
                    break;
            }
        }


        public String checkTypeAnimal(){
            String animalType;

            Scanner in = new Scanner(System.in);
            System.out.println("Press 1 for Mammal\n Press 2 for Dinosaur\nPress 3 for Vertebrate\nPress 4 for Insect\n Press 5 for Amphibians");
            int choice = in.nextInt();

            switch (choice) {
                case 1:
                    animalType = "mammal";
                    break;

                case 2:
                    animalType = "dinosaur";
                    break;

                case 3:
                    animalType = "vertebrate";
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


        public boolean checkValid(){
            Scanner in = new Scanner(System.in);
            System.out.println("Please Press 1 for Yes and 2 for No!\n");

            boolean isValid = true;
            int choice = in.nextInt();
            switch(choice){
                case 1:
                    isValid = true;
                    break;

                case 2:
                    isValid =  false;
                    break;

                default:
                    System.out.println("Wrong Input");
                    break;
            }

            return isValid;
        }

        public Animal animalNameCheck(){
            Scanner in = new Scanner(System.in);
            listUnlistedAnimal();
            System.out.println("Enter name of wanted animal");

            String tempAnimal = in.next().toLowerCase();
            System.out.println(tempAnimal);
            Animal tempAnimalObject=null;

            for (Animal animal: zoo.getUnListedAnimals())
            {
                System.out.println(animal.name+"     "+tempAnimal);
                if(animal.name.toLowerCase().equals(tempAnimal)){
                    tempAnimalObject = animal;
                    System.out.println(tempAnimalObject);
                }
            }
            return tempAnimalObject;
        }

        public Pen penNameCheck(){
            Scanner in = new Scanner(System.in);
            System.out.println("Enter the name of the Pen you want");

            String tempPen = in.next().toLowerCase();
            Pen tempPenObject = null;

            for (Pen pen: zoo.getPenList()){
                if (pen.name.toLowerCase().equals(tempPen)){
                    tempPenObject = pen;
                }
            }
            return tempPenObject;
        }


        public void assignAnimal(Animal tempAnimal, Pen targetPen){
            targetPen.addAnimal(tempAnimal);
            zoo.unlistedAnimalRemove(tempAnimal);
        }

        public void completeAssignAnimal(){
            Animal getAnimal = getAnimal();
            checkIfAnimalSuitableForPen(getAnimal);
            Animal transferAnimal = animalNameCheck();
            Pen targetedPen = penNameCheck();
            assignAnimal(transferAnimal, targetedPen);
        }


    public void listUnlistedAnimal(){
        for (Animal animal: zoo.getUnListedAnimals())
        {
            System.out.println(animal.id + "\n");
            System.out.println(animal.getSpecie() + "\n");
            System.out.println(animal.getType() + "\n");
            System.out.println(animal.name);
        }
    }

    public Animal getAnimal(){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the name of the Animal you want");

        String tempAnimal = in.next().toLowerCase();
        Animal tempAnimalObject = null;

        for (Animal animal: zoo.getUnListedAnimals()){
            if (animal.name.toLowerCase().equals(tempAnimal)){
                tempAnimalObject = animal;
            }
        }
        return tempAnimalObject;
    }

    public void listPens(){
        for (Pen pen: zoo.getPenList())
        {
            System.out.println(pen.id + "\n");
            System.out.println(pen.name + "\n");
            System.out.println(pen.getPenType() + "\n");
            System.out.println(pen.employee.name + "\n");
            System.out.println(pen.employee2.name + "\n");
        }
    }

    public void checkIfAnimalSuitableForPen(Animal tempAnimal){
        if(tempAnimal.getType().equals("mammal")){
            listDryPens();
            listPartWetPartDryPens();
        }
        else if(tempAnimal.getType().equals("aquatic")){
            listAquariumPens();
            listPartWetPartDryPens();
            listAquariumPens();
        }
        else if(tempAnimal.getType().equals("dinosaur")){
            listDryPens();
            listPartWetPartDryPens();
        }
        else if(tempAnimal.getType().equals("insect")){
            listDryPens();
            listPartWetPartDryPens();
        }
        else if(tempAnimal.getType().equals("amphibians")){
            listDryPens();
            listPartWetPartDryPens();
            listAquariumPens();
        }
        else if(tempAnimal.getType().equals("flying")){
            listAviaryPens();
        }
        else if(tempAnimal.getType().equals("mammal") && tempAnimal.isHappy()){
            listDryPens();
            listPettingPens();
        }
        else if(tempAnimal.getType().equals("dinosaur") && tempAnimal.isHappy()){
            listDryPens();
            listPettingPens();
        }
        else if(tempAnimal.getType().equals("insect") && tempAnimal.isHappy()){
            listPettingPens();
        }
        else if(tempAnimal.getType().equals("amphibians") && tempAnimal.isHappy()){
            listPettingPens();
        }
        else if(tempAnimal.getType().equals("flying") && tempAnimal.isHappy()){
            listPettingPens();
        }

        else if(tempAnimal.getType().equals("flying") && !tempAnimal.isPrey()){
            listAviaryPensIsPredator();
        }
        else if(tempAnimal.getType().equals("mammal") && !tempAnimal.isPrey()){
            listPartWetPartDryPensIsPredator();
            listDryPensIsPredator();
        }
        else if(tempAnimal.getType().equals("aquatic") && !tempAnimal.isPrey()){
            listAquariumPensIsPredator();
            listPartWetPartDryPensIsPredator();
        }
        else if(tempAnimal.getType().equals("dinosaur") && !tempAnimal.isPrey()){
            listPartWetPartDryPensIsPredator();
            listDryPensIsPredator();
        }
        else if(tempAnimal.getType().equals("insect") && !tempAnimal.isPrey()){
            listDryPensIsPredator();
            listPartWetPartDryPensIsPredator();
        }
        else if(tempAnimal.getType().equals("amphibians") && !tempAnimal.isPrey()){
            listDryPens();
            listPartWetPartDryPensIsPredator();
            listAquariumPensIsPredator();
        }

    }

    private void listDryPensIsPredator() {
        for (Pen pen: zoo.getPenList())
        {
            System.out.println(pen.id + "\n");
            System.out.println(pen.name + "\n");
            System.out.println(pen.getPenType().equals("dry") + "\n");
            System.out.println(pen.isPreyPen());
            System.out.println(pen.employee.name + "\n");
            System.out.println(pen.employee2.name + "\n");
        }
    }

    private void listPartWetPartDryPensIsPredator(){

    }

    private void listAquariumPensIsPredator(){

    }

    private void listAviaryPensIsPredator(){

    }

    private void listDryPens() {
        for (Pen pen: zoo.getPenList())
        {
            System.out.println(pen.id + "\n");
            System.out.println(pen.name + "\n");
            System.out.println(pen.getPenType().equals("dry") + "\n");
            System.out.println(pen.employee.name + "\n");
            System.out.println(pen.employee2.name + "\n");
        }
    }

    private void listPettingPens(){
        for (Pen pen: zoo.getPenList())
        {
            System.out.println(pen.id + "\n");
            System.out.println(pen.name + "\n");
            System.out.println(pen.getPenType().equals("pettingpen") + "\n");
            System.out.println(pen.employee.name + "\n");
            System.out.println(pen.employee2.name + "\n");
        }
    }
    private void listPartWetPartDryPens(){
        for (Pen pen: zoo.getPenList())
        {
            System.out.println(pen.id + "\n");
            System.out.println(pen.name + "\n");
            System.out.println(pen.getPenType().equals("partwetpartdry") + "\n");
            System.out.println(pen.employee.name + "\n");
            System.out.println(pen.employee2.name + "\n");
        }
    }

    private void listAquariumPens(){
        for (Pen pen: zoo.getPenList())
        {
            System.out.println(pen.id + "\n");
            System.out.println(pen.name + "\n");
            System.out.println(pen.getPenType().equals("aquarium") + "\n");
            System.out.println(pen.employee.name + "\n");
            System.out.println(pen.employee2.name + "\n");
        }
    }

    private void listAviaryPens(){
        for (Pen pen: zoo.getPenList())
        {
            System.out.println(pen.id + "\n");
            System.out.println(pen.name + "\n");
            System.out.println(pen.getPenType().equals("aviary") + "\n");
            System.out.println(pen.employee.name + "\n");
            System.out.println(pen.employee2.name + "\n");
        }
    }

    public void employeeCheck(){
        if(zoo.getEmployeeList().isEmpty()){
            zoo.newEmployee("Ian", "Hemming");
            zoo.newEmployee("Alex", "Casper");
            zoo.newEmployee("John", "Smith");
            zoo.newEmployee("Ryan", "Reynolds");
        }
    }

    public void defaultPenCheck(){
        if(zoo.getPenList().isEmpty()){
            zoo.newDry("Default Dry", "dinosaur", zoo.getEmployee(0), zoo.getEmployee(2));
            zoo.newAquarium("Default Aquarium", "aquarium", zoo.getEmployee(1), zoo.getEmployee(0));
            zoo.newAviary("Default Aviary", "aviary", zoo.getEmployee(3), zoo.getEmployee(1));
            zoo.newPettingPen("Default PettingPen", "aquarium", zoo.getEmployee(2), zoo.getEmployee(1));
        }
    }

    public void newDataLoad(){
        employeeCheck();
        defaultPenCheck();
    }


}
