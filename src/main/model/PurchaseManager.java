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
            System.out.println(p);
        }
    }

    public ArrayList<Purchase> showPurchasesByPrice(int i) {
        return null;

    }

    public ArrayList<Purchase> getListOfPurchases() {
        return listofPurchases;

    }






}
