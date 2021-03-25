package ui;

import model.Budget;
import model.BudgetManager;
import model.Purchase;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class TotalSpentGUI {
    private BudgetManager bm;
    private JList list;
    private JPanel panel;
    private JPanel panel2;
    private JFrame frame;
    private JFrame frame3;
    private String value;
    private int total;
    private int totalSpent;
    private JFrame showTotal;
    private JTextField text;
    private JPanel panel3;


    // EFFECTS: constructs a totalspentgui with a budgetmanager, JList, 2 Jpanels, 2 Jframes, and a string value
    public TotalSpentGUI(BudgetManager bm, JList list, JPanel panel, JPanel panel2, JFrame frame, JFrame frame3,
                         String value) {
        this.bm = bm;
        this.list = list;
        this.panel = panel;
        this.panel2 = panel2;
        this.frame = frame;
        this.frame3 = frame3;
        this.value = value;
        showTotal = new JFrame();
        panel3 = new JPanel();
        int totalSpent = showTotal();
        text = new JTextField("Total spent: " + totalSpent);
        text.setEditable(false);
        panel3.add(text, BorderLayout.CENTER);
        showTotal.add(panel3);
        showTotal.setVisible(true);
    }

    // EFFECTS: returns the total cost of purchases in the specified budget
    public int showTotal() {
        Budget budget = bm.viewBudgetsByName(value);
        List<Purchase> purchaseList = budget.getListOfPurchases();
        for (Purchase p : purchaseList) {
            total += p.getPrice();
        }
        return total;
    }
}
