package ui;

import model.Budget;
import model.BudgetManager;
import model.Purchase;
import persistence.JsonReader;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

public class LoadBudgetsGUI implements ActionListener {
    private BudgetManager bm;
    private BudgetManager budgetManager;
    private JsonReader jsonReader;
    private static final String JSON_STORE = "./data/budgets.json";

    // EFFECTS: constructs a loadbudgetsgui with a budgetmanager
    public LoadBudgetsGUI(BudgetManager bm) {
        this.bm = bm;
        jsonReader = new JsonReader(JSON_STORE);
    }


    // EFFECTS: reads the jsonReader and updates the list of budgets for the current budgetmanager
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            budgetManager = jsonReader.read();
            bm.setListOfBudgets(budgetManager.getListOfBudgets());
            System.out.println("Loaded budgets" + " from " + JSON_STORE);
        } catch (IOException t) {
            System.out.println("Unable to read from file: " + JSON_STORE);
        }
    }
}