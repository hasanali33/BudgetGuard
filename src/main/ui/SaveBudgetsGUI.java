package ui;

import model.BudgetManager;
import persistence.JsonWriter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

public class SaveBudgetsGUI implements ActionListener {
    private BudgetManager bm;
    private JsonWriter jsonWriter;
    private static final String JSON_STORE = "./data/budgets.json";

    public SaveBudgetsGUI(BudgetManager bm) {
        this.bm = bm;
        jsonWriter = new JsonWriter(JSON_STORE);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            jsonWriter.open();
            jsonWriter.write(bm);
            jsonWriter.close();
            System.out.println("Saved budgets" + " to " + JSON_STORE);
        } catch (FileNotFoundException t) {
            System.out.println("Unable to write to file: " + JSON_STORE);
        }

    }
}
