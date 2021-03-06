package model;

import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

import java.util.ArrayList;
import java.util.List;

public class BudgetManager implements Writable {
    private List<Budget> listOfBudgets;
    //private PurchaseManager purchaseManager;


    // EFFECTS: creates a budgetManger object with a listofbudgets arrayList
    public BudgetManager() {
        listOfBudgets = new ArrayList<>();
    }

    // EFFECTS: implements a new ArrayList with the budgets.json that equal the name the user input
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

    // MODIFIES: this
    // EFFECTS: sets the budgets passed in, to the listofbudgets in the object
    public void setListOfBudgets(List<Budget> budgets) {
        this.listOfBudgets = budgets;
    }

    // EFFECTS: returns listofBudgets names in a arraylist filled with strings that contains the names of budgets.json
    public List<String> getListOfName() {
        ArrayList<String> listOfNames = new ArrayList<>();
        for (int i = 0; i < listOfBudgets.size(); i++) {
            if (!listOfNames.contains(listOfBudgets.get(i).getName())) {
                listOfNames.add(listOfBudgets.get(i).getName());
            }
        }
        return listOfNames;
    }

    // EFFECTS: See interface Writable
    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("budgets", budgetsToJson());
        return json;
    }

    // EFFECTS: returns budgets in this budgetmanager as a JSON array
    private JSONArray budgetsToJson() {
        JSONArray jsonArray = new JSONArray();

        for (Budget b : listOfBudgets) {
            jsonArray.put(b.toJson());
        }
        return jsonArray;
    }
}
