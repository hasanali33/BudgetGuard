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
            if (listofPurchases.get(i).getDate() == date) {
                filtered.add(listofPurchases.get(i));
            }
        }
        return filtered;

    }

    // EFFECTS: prints out all the purchases that have been made
    public void showAllPurchases() {
        for (Purchase p : listofPurchases) {
            System.out.println(p.toString());
        }
    }

    public void showAllPurchasesWithIndex() {
        int i = 0;
        for (Purchase p : listofPurchases) {
            System.out.println(i + p.toString());
            i++;
        }
    }



    // EFFECTS: creates a list with purchases from high to low
    public ArrayList<Purchase> showPurchasesByPrice() {
        ArrayList<Purchase> sortedList = new ArrayList<>();

        // how to compare from high to low? enchanced for loop?
      //  Purchase holder;
      //  for (int i = 0; i < listofPurchases.size(); i++) {
      //      for (int j = i + 1; j < listofPurchases.size() - 1)
      //      if (listofPurchases.get(i).getPrice()
      //  }
        return sortedList;

    }

    public ArrayList<Purchase> getListOfPurchases() {
        return listofPurchases;

    }

    public ArrayList<String> getListOfDates() {
        ArrayList<String> listOfDates = new ArrayList<>();
        for (int i = 0; i < listofPurchases.size(); i++) {
            listOfDates.add(listofPurchases.get(i).getDate());
        }
        return listOfDates;
    }






}
