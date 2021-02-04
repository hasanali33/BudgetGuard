package ui;

import model.Purchase;
import model.PurchaseManager;

import java.util.ArrayList;
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
        String userInput;

        initate();


        while (proceedFoward) {
            displayUserMenu();
            userInput = input.nextLine();
            userInput = userInput.toLowerCase();

            if (userInput.equals("quit")) {
                proceedFoward = false;
            } else {
                processUserInput(userInput);
            }

        }
        System.out.println("Goodbye and have a great day!");
    }

    // MODIFIES: this
    // EFFECTS: processes user input
    private void processUserInput(String userInput) {
        if (userInput.equals("view purchases")) {
            viewWhichPurchase();
        } else if (userInput.equals("add purchase")) {
            addPurchase();
        } else if (userInput.equals("delete purchase")) {
            deletePurchase();
        } else {
            System.out.println("Input invalid, please try again");
        }

    }

    // EFFECTS: displays full menu of options to user
    private void displayUserMenu() {
        System.out.println("What would you like to do today?:");
        System.out.println("- View Purchases");
        System.out.println("- Add Purchase");
        System.out.println("- Delete Purchase");
        System.out.println("- Quit");
    }

    // MODIFES: this
    // EFFECTS: Allows the user to choose which way to view purchases, by date or price or all of them
    private void viewWhichPurchase() {
        String selection = "";

        System.out.println("Which way would you like to view your purchases?");
        while (!selection.equals("bd") && !selection.equals("bp") && !selection.equals("all")) {
            System.out.println("bd for by date");
            System.out.println("bp for by price");
            System.out.println("all for show all purchases");
            selection = input.nextLine();
            selection = selection.toLowerCase();
        }

        if (selection.equals("bd")) {
            viewPurchasesByDate();
        } else if (selection.equals("bp")) {
            viewPurchasesByPrice();
        } else if (selection.equals("all")) {
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
