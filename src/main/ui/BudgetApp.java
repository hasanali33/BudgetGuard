package ui;

import model.Purchase;
import model.PurchaseManager;

import java.util.Scanner;

public class BudgetApp {
    private PurchaseManager aliH;
    private Scanner input;

    // Effects: runs the Budget application
    public BudgetApp() {
        runBudgetApp();
    }

    // MODIFIES: this
    // EFFECTS: processes the input given from the user
    private void runBudgetApp() {
        boolean proceedFoward = true;
        String userInput = null;

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
        System.out.println("Welcome!");
        System.out.println("What would you like to do today?:");
        System.out.println("- View Purchases");
        System.out.println("- Add Purchase");
        System.out.println("- Delete Purchase");
        System.out.println("- Quit");
    }

    // MODIFES: this
    // EFFECTS: shows user all purchases
    private void viewWhichPurchase() {
        String selection = "";

        System.out.println("Which way would you like to view your purchases?");
        while (!(selection.equals("bd") || selection.equals("bp")) || selection.equals("all")) {
            System.out.println("bd for by date");
            System.out.println("bp for by price");
            System.out.println("all for show all purchases");
            selection = input.next();
            selection = selection.toLowerCase();
        }

        if (selection.equals("bd")) {
            System.out.println("Please enter the date you would like to see from the following list: ");

            for (int i = 0; i < aliH.getListOfDates().size(); i++) {
                System.out.println(aliH.getListOfDates().get(i));
            }

            String date = input.nextLine();
            aliH.viewPurchasesByDate(date);
        } else if (selection.equals("bp")) {
            viewPurchasesByPrice();
        } else if (selection.equals("all")) {
            viewAllPurchases();
        } else {
            System.out.println("Invalid input, please try again");
        }

    }

    private void viewAllPurchases() {
        aliH.showAllPurchases();
    }

    private void initate() {
        input = new Scanner(System.in);
        aliH = new PurchaseManager();
    }

    // how?
    private void viewPurchasesByPrice() {
        aliH.showAllPurchases();
    }


    private void addPurchase() {
        System.out.println("Please enter the date you made the purchase (ex: July 11)");
        String date = input.nextLine();
        System.out.println("Please enter the type of purchase you made (ex: Food)");
        String type = input.nextLine();
        System.out.println("Please enter the name of purchase you made (ex: Taco Bell)");
        String name = input.nextLine();
        System.out.println("Please enter the cost of purchase you made (ex: if $3, then enter 3");
        int price = input.nextInt();

        Purchase purchase = new Purchase(date, type, name, price);

        aliH.addPurchase(purchase);

        System.out.println("Purchase has been successfully added!");

        // do i need to add this code here?

        System.out.println("Would you like to go back to the main menu?");

    }


    private void deletePurchase() {
        System.out.println("Please enter the number you would like to delete");
        aliH.showAllPurchasesWithIndex();
        String userInput = input.nextLine();

        aliH.getListOfPurchases().remove(userInput);

        System.out.println("Purchase has been successfully removed!");




    }





}
