package com.codefirstgirls;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in); // Scanner class is used to get user input

    public static void main(String[] args) {

        System.out.println("WELCOME TO THE OBJECT GENERATOR");
        System.out.println("*******************************");



        ArrayList<String> groceryItems = new ArrayList<>();
        groceryItems.add("1. Apple");
        groceryItems.add("2. Banana");

        boolean validSelection = false;
//        assign as null so that it can assigned later on in the switch statment
        Item itemSelected = null;

        while (!validSelection){
            System.out.println("PLEASE ENTER ONE OF THE FOLLOWING OBJECTS TO CREATE");
            groceryItems.forEach((n)->
                    System.out.println(n));
//            get users choice and store in variable to be used for switch statement
            String itemChoice = scanner.nextLine();

            switch(itemChoice){
                case "Apple":
                    itemSelected = new Item("Apple","Fruit", 1.29);
//                    change to true so that while loop can be broken as user has input what they have selected
                    validSelection = true;
                    System.out.println("Apple selected");
                    break;
                case "Banana":
                    System.out.println("Banana selected");
                    itemSelected = new Item("Banana","Fruit", 0.79);
                    validSelection = true;
                    break;
                default:
                    System.out.println("You didn't select anything!");
//                return statement so that it returns if user does not select appropriately
                    break;

            }
        }

        System.out.println("THANKS! HOW MANY WOULD YOU LIKE TO CREATE?");
        String amountToCreate = scanner.nextLine();
        int amountToCreateInteger = Integer.parseInt(amountToCreate);

        if(amountToCreateInteger > 0){
            double totalPrice = itemSelected.getTotalPrice(amountToCreateInteger);
            System.out.println("The total price for " + amountToCreateInteger + " " + itemSelected.getProductName() + "(s) is: £" + totalPrice);
//            originally tried to assign to string, but cannot assign voids to string as they will just show what is written in the void method
            itemSelected.displayItem();
        } else {
            System.out.println("Invalid quantity.");
        }


    }
}