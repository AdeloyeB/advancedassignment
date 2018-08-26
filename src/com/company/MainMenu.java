package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.*;
import java.io.IOException;

public class MainMenu {

    Controller controller = new Controller();

    public void activeMenu(){
        controller.globalLoad();

        Scanner in = new Scanner(System.in);

        //Display the main menu
        welcomeMsg();

        boolean running = false;

        while(!running) {

            selectMenu();


            try {
                int choice = in.nextInt();
                switch (choice) {
                    //SWITCH CASE for the main menu
                    case 1:
                        System.out.println("Loading Unassigned Animal List!");
                        controller.listUnlistedAnimal();
                        break;

                    case 2:
                        System.out.println("Create Animal!");
                        controller.createAnimal();
                        break;

                    case 3:
                        System.out.println("Assign animals");
                        controller.completeAssignAnimal();
                        break;

                    case 4:
                        System.out.println("Loading Employee List!");
                        controller.listEmployees();
                        break;

                    case 5:
                        System.out.println("Loading Pen List");
                        controller.listPens();
                        break;

                    case 6:
                        System.out.println("Create Pen!");
                        controller.typeOfPen();
                        break;

                    case 7:
                        controller.getAPIData();
                        break;

                    case 8:
                        controller.globaLSave();
                        running = false;
                        System.exit(0);
                        break;

                    default:
                        System.out.println("Wrong input... Try again please");
                        break;
                }

            } catch (java.util.InputMismatchException err) {
                System.out.println("Invalid input");
                activeMenu();
            }

        }


    }

    private void selectMenu() {
            System.out.println("\nSelect '1' to load unassigned animals");
            System.out.println("Select '2' to create a new animal");
            System.out.println("Select '3' to assign the animals");
            System.out.println("Select '4' to load the employee list");
            System.out.println("Select '5' to load the pen list");
            System.out.println("Select '6' to create a new pen");
            System.out.println("Select '7' to get weather data about the zoo");
            System.out.println("Select '8' exit program");
    }

    private void welcomeMsg() {
        System.out.println("Welcome to Zoo Keeper! \nHere you can manage your own Zoo by creating new animals and pens! " +
                "\nYou have to exit the program through the command line in order for the program to save properly! DO NOT EXIT FORCEFULLY!");
    }
}

