package ui;

import model.Budget;
import model.BudgetManager;
import model.PriceIsNegative;
import model.Purchase;
import persistence.JsonReader;
import persistence.JsonWriter;
//import model.PurchaseManager;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class BudgetApp {

    // Source: some UI Code taken from TellerApp and WorkRoom app

    private Scanner input;
    private Scanner inputTwo;
    private BudgetManager budgetManager;
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;
    private static final String JSON_STORE = "./data/budgets.json";

    // EFFECTS: runs the Budget application
    public BudgetApp() {
        runBudgetApp();
    }

    // EFFECTS: processes the input given from the user
    private void runBudgetApp() {
        boolean proceedForward = true;
        int userInput;

        initate();

        while (proceedForward) {
            displayUserMenu();

            userInput = input.nextInt();
            input.nextLine();

            if (userInput == 6) {
                proceedForward = false;
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
            if (budgetManager.getListOfBudgets().size() == 0) {
                System.out.println("There are no budgets to show!");
            } else {
                viewWhichBudget();
            }
        } else if (userInput == 2) {
            addToNewBudgetOrExisting();
        } else if (userInput == 3) {
            if (budgetManager.getListOfBudgets().size() == 0) {
                System.out.println("There are no budgets to delete from!");
            } else {
                deleteFromWhichBudget();
            }
        } else if (userInput == 4) {
            saveBudgets();
        } else if (userInput == 5) {
            loadBudgets();
        } else {
            System.out.println("Input invalid, please try again");
        }

    }

    // EFFECTS: asks the user's which budget to delete from and passes it into the deletePurchase method
    public void deleteFromWhichBudget() {
        String userInput = "";
        System.out.println("Which budget would you like to delete from?");

        viewAllBudgets();

        userInput = input.nextLine();

        Budget specifiedBudget = budgetManager.viewBudgetsByName(userInput);

        deletePurchase(specifiedBudget);

    }


    // EFFECTS: asks the user if to add to new budget or existing, and passes the input into another method
    public void addToNewBudgetOrExisting() {
        String userInput = "";
        System.out.println("Select 1) create and add to a new budget or 2) add to an existing budget");
        int inputFromUser = input.nextInt();
        input.nextLine();

        if (inputFromUser == 1) {
            createNewBudget();
        } else {
            if (budgetManager.getListOfBudgets().size() == 0) {
                System.out.println("There are no budgets to add to!");
            } else {
                System.out.println("Which budget would you like to add too?");
                viewAllBudgets();

                userInput = input.nextLine();
                userInput.toLowerCase();

                Budget specifiedBudget = budgetManager.viewBudgetsByName(userInput);

                addPurchase(specifiedBudget);
            }

        }
    }


    // EFFECTS: Creates new budget, adds it to list of Budgets in the budgetmanager, then passes it into add purchase
    public void createNewBudget() {
        String userInput = "";
        System.out.println("What would you like to name the budget?");

        userInput = input.nextLine();

        Budget budget = new Budget(userInput);

        budgetManager.getListOfBudgets().add(budget);

        addPurchase(budget);

    }

    // EFFECTS: displays full menu of options to user
    private void displayUserMenu() {
        System.out.println("What would you like to do today?:");
        System.out.println("1) View Budgets");
        System.out.println("2) Add Purchase");
        System.out.println("3) Delete Purchase");
        System.out.println("4) Save budgets to file");
        System.out.println("5) Load budgets from file");
        System.out.println("6) Quit");
    }

    // EFFECTS: prints the names of all the budgets in the list
    private void viewAllBudgets() {
        for (Budget budget : budgetManager.getListOfBudgets()) {
            System.out.println(budget.getName());
        }
    }


    // EFFECTS: takes the users input of what budget they would like to view
    private void viewWhichBudget() {
        String userInput = "";

        System.out.println("Which budget would you like to view?");
        viewAllBudgets();

        userInput = input.nextLine();

        Budget specifiedBudget = budgetManager.viewBudgetsByName(userInput);

        viewWhichPurchase(specifiedBudget);

    }



    // EFFECTS: Allows the user to choose which way to view purchases, by date or price or all of them
    private void viewWhichPurchase(Budget p) {
        int selection = 0;

        System.out.println("Which way would you like to view your purchases?");
        while (selection != 1 && selection != 2 && selection != 3) {
            System.out.println("1) by date");
            System.out.println("2) by type");
            System.out.println("3) show all purchases");
            selection = input.nextInt();
            input.nextLine();
        }

        if (selection == 1) {
            viewPurchasesByDate(p);
        } else if (selection == 2) {
            viewPurchasesByType(p);
        } else if (selection == 3) {
            viewAllPurchases(p);
        } else {
            System.out.println("Invalid input, please try again");
        }

    }

    // EFFECTS: prints a list of purchases made on the date given by the user and the total spent
    public void viewPurchasesByDate(Budget p) {
        System.out.println("Please enter the date you would like to see from the following list: ");

        for (int i = 0; i < p.getListOfDates().size(); i++) {
            System.out.println(p.getListOfDates().get(i));
        }

        // if print line before nextline, add another nextline
        // does not stop and ask user what date to specify
        String date = input.nextLine();
        date = date.toLowerCase();


        ArrayList<Purchase> dateSorted = p.viewPurchasesByDate(date);

        int total = 0;
        for (int i = 0; i < dateSorted.size(); i++) {
            System.out.println(dateSorted.get(i).toString());
            total += dateSorted.get(i).getPrice();
        }
        System.out.println("Total spent: $" + total);
    }

    // EFFECTS: prints back a list of all the purchases in the list
    private void viewAllPurchases(Budget p) {
        showAllPurchases(p);
    }

    // EFFECTS: initates the system input and the BudgetManager object
    private void initate() {
        input = new Scanner(System.in);
        inputTwo = new Scanner(System.in);
        //aliH = new PurchaseManager();
        budgetManager = new BudgetManager();
        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);
    }

    // EFFECTS: prints a list of purchases of that type given by the user and the total spent
    private void viewPurchasesByType(Budget p) {
        System.out.println("Please enter the following type of purchase you would like to view");

        for (int i = 0; i < p.getListOfTypes().size(); i++) {
            System.out.println(p.getListOfTypes().get(i));
        }

        // if print line before nextline, add another nextline
        // does not stop and ask user what date to specify
        String type = input.nextLine();
        type = type.toLowerCase();


        ArrayList<Purchase> typeSorted = p.viewPurchasesByType(type);

        int total = 0;
        for (int i = 0; i < typeSorted.size(); i++) {
            System.out.println(typeSorted.get(i).toString());
            total += typeSorted.get(i).getPrice();
        }
        System.out.println("Total spent: $" + total);
    }

    // MODIFIES: Budget p adds purchase to its list
    // EFFECTS: adds purchase to the Budget list
    private void addPurchase(Budget p) {
        String userInputAnotherItem = "";

        //System.out.println("Please enter the date you made the purchase (ex: July 11)");
        String date = input.nextLine();
       // System.out.println("Please enter the type of purchase you made (ex: Food)");
        String type = input.nextLine();
        //System.out.println("Please enter the name of purchase you made (ex: Taco Bell)");
        String name = input.nextLine();
        //System.out.println("Please enter the cost of purchase you made (ex: if $3, then enter 3)");
        int price = input.nextInt();
        input.nextLine();

        Purchase purchase = null;
        try {
            purchase = new Purchase(date, type, name, price);
        } catch (PriceIsNegative e) {
            try {
                purchase = new Purchase(date, type, name, 0);
            } catch (PriceIsNegative priceIsNegative) {
                priceIsNegative.printStackTrace();
            }
        }

        p.addPurchase(purchase);

        //System.out.println("Purchase has been successfully added!");

        ///System.out.println("Would you like to add another item?");
        System.out.println("y for yes");
        System.out.println("n for no, return back to main menu");


        userInputAnotherItem = inputTwo.nextLine();

        if (userInputAnotherItem.toLowerCase().equals("y")) {
            addPurchase(p);
        }
    }

    // EFFECTS: prints all the purchases with the specificed index next to them
    public void showAllPurchasesWithIndex(Budget p) {
        int i = 0;
        for (Purchase purchase : p.getListOfPurchases()) {
            System.out.println(i + " " + purchase.toString());
            i++;
        }
    }

    // EFFECTS: prints out all the purchases that have been made
    public void showAllPurchases(Budget p) {
        int total = 0;
        for (Purchase purchase : p.getListOfPurchases()) {
            System.out.println(purchase.toString());
            total += purchase.getPrice();
        }
        System.out.println("Total spent: $" + total);
    }



    // MODIFIES: Budget p, it removes purchase from the list
    // EFFECTS: deletes the specificed purchase the user wants deleted from the list
    private void deletePurchase(Budget p) {
        System.out.println("Please enter the number you would like to delete");
        showAllPurchasesWithIndex(p);

        int userInput = input.nextInt();
        input.nextLine();

        p.getListOfPurchases().remove(userInput);

        System.out.println("Purchase has been successfully removed!");


    }


    // EFFECTS: saves the budgets to file
    private void saveBudgets() {
        try {
            jsonWriter.open();
            jsonWriter.write(budgetManager);
            jsonWriter.close();
            System.out.println("Saved budgets" + " to " + JSON_STORE);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file: " + JSON_STORE);
        }
    }

    // MODIFIES: this
    // EFFECTS: loads budgets from file
    private void loadBudgets() {
        try {
            budgetManager = jsonReader.read();
            System.out.println("Loaded budgets" + " from " + JSON_STORE);
        } catch (IOException e) {
            System.out.println("Unable to read from file: " + JSON_STORE);
        }
    }


}
