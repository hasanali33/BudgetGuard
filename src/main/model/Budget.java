package model;

import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;
import ui.BudgetApp;

import java.util.ArrayList;
import java.util.List;

public class Budget implements Writable {
    private String name;
   // private PurchaseManager purchaseManager;
    private ArrayList<Purchase> listofPurchases;



    // EFFECTS: creates a budget with a specified name and creates an ArrayList for listofpurchases
    public Budget(String name) {
        this.name = name;
        listofPurchases = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }


    // EFFECTS: adds a purchase to the listofpurchases list
    public void addPurchase(Purchase purchase) {
        listofPurchases.add(purchase);

    }

    // EFFECTS: removes a purchase from the listofpurchases list
    public void removePurchase(Purchase purchase) {
        for (int i = 0; i < listofPurchases.size(); i++) {
            // right way to set equal?
            if (listofPurchases.get(i) == purchase) {
                listofPurchases.remove(i);
            }
        }
    }

    // EFFECTS: implements a new ArrayList with the purchases that were made at that date
    public ArrayList<Purchase> viewPurchasesByDate(String date) {
        ArrayList<Purchase> filtered = new ArrayList<>();

        for (int i = 0; i < listofPurchases.size(); i++) {
            if (listofPurchases.get(i).getDate().equals(date)) {
                filtered.add(listofPurchases.get(i));
            }
        }
        return filtered;

    }

    // EFFECTS: implements a new ArrayList with the purchases that equal the type the user input
    public ArrayList<Purchase> viewPurchasesByType(String type) {
        ArrayList<Purchase> filtered = new ArrayList<>();

        for (int i = 0; i < listofPurchases.size(); i++) {
            if (listofPurchases.get(i).getType().equals(type)) {
                filtered.add(listofPurchases.get(i));
            }
        }
        return filtered;

    }


    // EFFECTS: returns the listofpurchases arraylist
    public ArrayList<Purchase> getListOfPurchases() {
        return listofPurchases;

    }

    // EFFECTS: returns listofdates arraylist that contains dates of purchases
    public ArrayList<String> getListOfDates() {
        ArrayList<String> listOfDates = new ArrayList<>();
        for (int i = 0; i < listofPurchases.size(); i++) {
            if (!listOfDates.contains(listofPurchases.get(i).getDate())) {
                listOfDates.add(listofPurchases.get(i).getDate());
            }
        }
        return listOfDates;
    }

    // need to test
    // EFFECTS: returns listoftypes arraylist that contains the types of purchases
    public ArrayList<String> getListOfTypes() {
        ArrayList<String> listOfTypes = new ArrayList<>();
        for (int i = 0; i < listofPurchases.size(); i++) {
            if (!listOfTypes.contains(listofPurchases.get(i).getType())) {
                listOfTypes.add(listofPurchases.get(i).getType());
            }
        }
        return listOfTypes;
    }


    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", name);
        json.put("purchases", purchasesToJson());
        return json;
    }

    // EFFECTS: returns purchases in this listofpurchases as a JSON array
    private JSONArray purchasesToJson() {
        JSONArray jsonArray = new JSONArray();

        for (Purchase p : listofPurchases) {
            jsonArray.put(p.toJson());
        }

        return  jsonArray;
    }
}
