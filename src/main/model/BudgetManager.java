package model;

import java.util.ArrayList;
import java.util.List;

public class BudgetManager {
    private List<Budget> listOfBudgets;
    //private PurchaseManager purchaseManager;



    public BudgetManager() {
        listOfBudgets = new ArrayList<>();
    }

    // EFFECTS: implements a new ArrayList with the budgets that equal the name the user input
    public Budget viewBudgetsByName(String name) {
        Budget filtered = null;

        for (int i = 0; i < listOfBudgets.size(); i++) {
            if (listOfBudgets.get(i).getName().equals(name)) {
                filtered = listOfBudgets.get(i);
            }
        }
        return filtered;

    }


    // EFFECTS: returns listOfBudgets
    public List<Budget> getListOfBudgets() {
        return listOfBudgets;
    }

    // EFFECTS: returns listoftypes arraylist that contains the types of purchases
    public List<String> getListOfName() {
        ArrayList<String> listOfNames = new ArrayList<>();
        for (int i = 0; i < listOfBudgets.size(); i++) {
            if (!listOfBudgets.contains(listOfBudgets.get(i).getName())) {
                listOfNames.add(listOfBudgets.get(i).getName());
            }
        }
        return listOfNames;
    }
}
