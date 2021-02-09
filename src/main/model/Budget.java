package model;

import ui.BudgetApp;

import java.util.ArrayList;
import java.util.List;

public class Budget {
    private String name;
    private PurchaseManager purchaseManager;


    public Budget(String name) {
        this.name = name;
        purchaseManager = new PurchaseManager();
    }

    // EFFECTS: creates new Budget object
    public void initiateNewBudget(String name) {
        new Budget(name);
    }

    // EFFECTS: adds the purchase manager to the listOfPurchaseManagers list
   // public void addToBudgetList(PurchaseManager p) {
    //    purchaseManager.add(p);
    //}

    // EFFECTS: removes purchasemanager from budget
   // public void removeBudgetList(PurchaseManager p) {
    //    listOfPurchaseManagers.remove(p);
    //}

    public String getName() {
        return this.name;
    }

    public PurchaseManager getPurchaseManager() {
        return purchaseManager;
    }


}
