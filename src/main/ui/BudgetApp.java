package ui;

import model.Purchase;
import model.PurchaseManager;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BudgetApp {
    private PurchaseManager aliH;
    private Scanner input;
    private Scanner inputTwo;

    // Effects: runs the Budget application
    public BudgetApp() {
        runBudgetApp();
    }

    // MODIFIES: this
    // EFFECTS: processes the input given from the user
    private void runBudgetApp() {
        boolean proceedFoward = true;
        int userInput;

        initate();


        while (proceedFoward) {
            displayUserMenu();

            userInput = input.nextInt();
            input.nextLine();

            if (userInput == 4) {
                proceedFoward = false;
            } else {
                processUserInput(userInput);
            }

        }
        System.out.println("Goodbye and have a great day!");
    }

    // MODIFIES: this
    // EFFECTS: processes user input
    private void processUserInput(int userInput) {
        if (userInput == 1) {
            viewWhichPurchase();
        } else if (userInput == 2) {
            addPurchase();
        } else if (userInput == 3) {
            deletePurchase();
        } else {
            System.out.println("Input invalid, please try again");
        }

    }

    // EFFECTS: displays full menu of options to user
    private void displayUserMenu() {
        System.out.println("What would you like to do today?:");
        System.out.println("1) View Purchases");
        System.out.println("2) Add Purchase");
        System.out.println("3) Delete Purchase");
        System.out.println("4) Quit");
    }

    // MODIFES: this
    // EFFECTS: Allows the user to choose which way to view purchases, by date or price or all of them
    private void viewWhichPurchase() {
        int selection = 0;

        System.out.println("Which way would you like to view your purchases?");
        while (selection != 1 && selection != 2 && selection != 3) {
            System.out.println("1) bd for by date");
            System.out.println("2) bp for by price");
            System.out.println("3) all for show all purchases");
            selection = input.nextInt();
            input.nextLine();
        }

        if (selection == 1) {
            viewPurchasesByDate();
        } else if (selection == 2) {
            viewPurchasesByPrice();
        } else if (selection == 3) {
            viewAllPurchases();
        } else {
            System.out.println("Invalid input, please try again");
        }

    }

    public void viewPurchasesByDate() {
        System.out.println("Please enter the date you would like to see from the following list: ");

        for (int i = 0; i < aliH.getListOfDates().size(); i++) {
            System.out.println(aliH.getListOfDates().get(i));
        }

        // if print line before nextline, add another nextline
        // does not stop and ask user what date to specify
        String date = input.nextLine();
        date = date.toLowerCase();


        ArrayList<Purchase> dateSorted = aliH.viewPurchasesByDate(date);

        int total = 0;
        for (int i = 0; i < dateSorted.size(); i++) {
            System.out.println(dateSorted.get(i).toString());
            total += dateSorted.get(i).getPrice();
        }
        System.out.println("Total spent: $" + total);

    }

    // EFFECTS: prints back a list of all the purchases in the list
    private void viewAllPurchases() {
        showAllPurchases();
    }

    // EFFECTS: initates the system input and the purchasemanager object
    private void initate() {
        input = new Scanner(System.in);
        inputTwo = new Scanner(System.in);
        aliH = new PurchaseManager();
        //aliH.addPurchase(new Purchase("july 11", "food", "taco bell", 20));
        //aliH.addPurchase(new Purchase("july 15", "food", "taco bell", 20));
    }

    // how?
    private void viewPurchasesByPrice() {
        showAllPurchases();
    }


    // EFFECTS: adds purchase to the list
    private void addPurchase() {
        String userInputAnotherItem = "";
        //System.out.println("Would you like to add to a new budget or an existing budget?");
        //String inputFromUser = input.nextLine();



        // when user gets into app, create a new purchase manager and user id


        // add to new budget
        // create new list
        // add name
        // then add purchases

        // otherwise add to an existing budget
        // list budgets
        // choose budget to add
        // add purchase

        System.out.println("Please enter the date you made the purchase (ex: July 11)");
        String date = input.nextLine();
        System.out.println("Please enter the type of purchase you made (ex: Food)");
        String type = input.nextLine();
        System.out.println("Please enter the name of purchase you made (ex: Taco Bell)");
        String name = input.nextLine();
        System.out.println("Please enter the cost of purchase you made (ex: if $3, then enter 3)");
        int price = input.nextInt();
        input.nextLine();

        Purchase purchase = new Purchase(date, type, name, price);

        aliH.addPurchase(purchase);

        System.out.println("Purchase has been successfully added!");

        System.out.println("Would you like to add another item?");
        System.out.println("y for yes");
        System.out.println("n for no, return back to main menu");


        userInputAnotherItem = inputTwo.nextLine();

        if (userInputAnotherItem.toLowerCase().equals("y")) {
            addPurchase();
        }
    }

    // EFFECTS: prints all the purchases with the specificed index next to them
    public void showAllPurchasesWithIndex() {
        int i = 0;
        for (Purchase p : aliH.getListOfPurchases()) {
            System.out.println(i + " " + p.toString());
            i++;
        }
    }

    // EFFECTS: prints out all the purchases that have been made
    public void showAllPurchases() {
        int total = 0;
        for (Purchase p : aliH.getListOfPurchases()) {
            System.out.println(p.toString());
            total += p.getPrice();
        }
        System.out.println("Total spent: $" + total);
    }



    // EFFECTS: deletes the specificed purchase the user wants deleted from the list
    private void deletePurchase() {
        System.out.println("Please enter the number you would like to delete");
        showAllPurchasesWithIndex();

        int userInput = input.nextInt();
        input.nextLine();

        aliH.getListOfPurchases().remove(userInput);

        System.out.println("Purchase has been successfully removed!");


    }


}
