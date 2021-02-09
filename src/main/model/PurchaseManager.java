package model;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class PurchaseManager {

    private ArrayList<Purchase> listofPurchases;


    public PurchaseManager() {
        listofPurchases = new ArrayList<>();
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

//    // EFFECTS: creates a list with purchases from high to low
//    public ArrayList<Purchase> showPurchasesByPrice() {
//        ArrayList<Purchase> sortedList = new ArrayList<>();
//        //listofPurchases.sort();
//
//        // how to compare from high to low? enchanced for loop?
//      //  Purchase holder;
//      //  for (int i = 0; i < listofPurchases.size(); i++) {
//      //      for (int j = i + 1; j < listofPurchases.size() - 1)
//      //      if (listofPurchases.get(i).getPrice()
//      //  }
//        return sortedList;
//
//    }

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






}
