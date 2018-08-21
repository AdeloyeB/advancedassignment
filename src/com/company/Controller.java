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
        api.getAPI();
    }

    //REFACTOR THIS CODE SO IT ONLY RUNS IF THE OBJECTS DON'T EXIST. CHEAT METHOD: RUN ONCE THEN DELETE THE OBJECTS ONCE PROPERLY STORED IN THE JSON
    Employee employee = new Employee(UUID.randomUUID().toString(), "Ian", "hemming");
    Employee employee2 = new Employee(UUID.randomUUID().toString(), "alex","richard");
    Employee employee3 = new Employee(UUID.randomUUID().toString(), "troy","lucky");
    Employee employee4 = new Employee(UUID.randomUUID().toString(), "kate","hopkins");

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

            Zoo loaded =
                    gson.fromJson(jsonString, Zoo.class);
            System.out.println("Loaded!");
            return loaded;
        } catch (Exception e) {
            System.out.println(
                    "Error loading file: " + e.getMessage());
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

        System.out.println("Area that the Animal takes up?\n");
        double area = in.nextDouble();

        System.out.println("Volume that the Animal takes up?\n");
        double volume = in.nextDouble();

        System.out.println("Is the animal a prey?\n");
        boolean isPrey = checkValid();

        System.out.println("Is the animal happy?\n");
        boolean isHappy = checkValid();



        Animal animal = new Animal(UUID.randomUUID().toString(),name, specie,type, area, volume, isPrey, isHappy);

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
                assignedEmployee = employee;
                break;

            case 2:
                assignedEmployee = employee2;
                break;

            case 3:
                assignedEmployee = employee3;
                break;

            case 4:
                assignedEmployee = employee4;
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

        boolean isHappy = true;

        System.out.println("Is the pen for weak animals?\n");
        boolean isPrey = checkValid();

        System.out.println("Area of the pen takes up?\n");
        double area = in.nextDouble();

        Dry dry = new Dry(UUID.randomUUID().toString(), name,penType, assignedEmployee,assignedEmployee2, isHappy, isPrey, area);

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

            boolean isHappy = true;

            System.out.println("Is the pen for weak animals?\n");
            boolean isPrey = checkValid();


        System.out.println("Volume of the pen takes up?\n");
            double volume = in.nextDouble();

            System.out.println("Area of the pen takes up?\n");
            double area = in.nextDouble();

            Aquarium aquarium = new Aquarium(UUID.randomUUID().toString(), name,penType, assignedEmployee, assignedEmployee2,isHappy, isPrey, volume, area);

            String json = gson.toJson(aquarium);
            zoo.penListAdd(aquarium);
            System.out.println(json);
        }

        public void createPartWetPartDryPen(){
        Scanner in = new Scanner(System.in);

        System.out.println("Enter name:\n");
        String name = in.next();

        String penType = "partwetpartdry";

        Employee assignedEmployee = assignEmployees();

        Employee assignedEmployee2 = assignEmployees();

        boolean isHappy = true;

        System.out.println("Is the pen for weak animals?\n");
        boolean isPrey = checkValid();


        System.out.println("Volume of the water takes up?\n");
        double areaOfLand = in.nextDouble();

        System.out.println("Area of the pen takes up?\n");
        double areaOfWater = in.nextDouble();

        System.out.println("Volume of water  the pen takes up?\n");
        double volumeOfWater = in.nextDouble();

        Employee employee = new Employee(UUID.randomUUID().toString(), "john", "farhad");

        PartWetPartDry partWetPartDry = new PartWetPartDry(UUID.randomUUID().toString(), name,penType, assignedEmployee, assignedEmployee2,isHappy, isPrey, areaOfLand, areaOfWater, volumeOfWater);

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

        boolean isHappy = true;

        System.out.println("Is the pen for weak animals?\n");
        boolean isPrey = checkValid();

        System.out.println("Area of the pen takes up?\n");
        double area = in.nextDouble();

        Employee employee = new Employee(UUID.randomUUID().toString(), "john", "farhad");

        PettingPen pettingPen = new PettingPen(UUID.randomUUID().toString(), name,penType, assignedEmployee, assignedEmployee2, isHappy, isPrey, area);

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

        boolean isHappy = true;

        System.out.println("Is the pen for weak animals?\n");
        boolean isPrey = checkValid();

        System.out.println("Volume of the pen takes up?\n");
        double volume = in.nextDouble();

        System.out.println("Area of the pen takes up?\n");
        double area = in.nextDouble();

        Aviary aviary = new Aviary(UUID.randomUUID().toString(), name,penType, assignedEmployee, assignedEmployee2, isHappy, isPrey, volume, area);

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
            listPens();
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

    }
    private void listPartWetPartDryPens(){

    }

    private void listAquariumPens(){

    }

    private void listAviaryPens(){

    }


}
