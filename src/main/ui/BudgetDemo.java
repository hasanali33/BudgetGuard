package ui;

import model.Budget;
import model.BudgetManager;
import model.Purchase;
import persistence.JsonReader;
import persistence.JsonWriter;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.List;

public class BudgetDemo extends JFrame implements ListSelectionListener, ActionListener {
    private JFrame frame;
    private JPanel panel;
    private JList<Budget> list;
    private JButton addBudget;
    private JButton saveBudget;
    private JButton loadBudget;
    private JButton viewBudgets;
    private JButton addPurchase;
    private JButton showDetails;
    private JButton backButton;
    private BudgetManager budgetManager;
    private static final String JSON_STORE = "./data/budgets.json";

    // use a table to show purchases JTable
    // covert purchases into a bunch of strings
    // one panel , lists all budgets -- select one budgets and do mulitple actions --
                  // add  purchase and show all purchases (bottom right, press add purchase, show details)

    //             add budget

    // implement three screens

    public BudgetDemo() {
        budgetManager = new BudgetManager();
        prepareGUI();
        prepareButtons();
    }



    public void prepareGUI() {
        frame = new JFrame();    // sets up the frame window
        panel = new JPanel();    // sets up the panel to store a group of components to store buttons, etc
        panel.setBorder(BorderFactory.createLineBorder(Color.BLACK)); // color of the panels border
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); /// what happens if window closes
        frame.setLayout(new BorderLayout());         // helpful for down the road?
        frame.add(panel, BorderLayout.CENTER);  //  adds the panel into the window frame and give its
        // a proper layout
        frame.setTitle("Budget Manager");           // sets the title for the frame
        addBudget = new JButton("Add Budget");
        panel.add(addBudget);    // adds button to JPanel

        viewBudgets = new JButton("View Budgets");
        panel.add(viewBudgets);

        loadBudget = new JButton("Load Budgets");
        panel.add(loadBudget);

        saveBudget = new JButton("Save Budgets");
        panel.add(saveBudget);

        frame.pack();
        frame.setVisible(true);                    // now visible and should appear


    }

    public void prepareButtons() {
        // should i put this in own method?
        //addBudget.doClick();
        addBudget.addActionListener(new AddBudgetGUI(budgetManager));
        saveBudget.addActionListener(new SaveBudgetsGUI(budgetManager));
        loadBudget.addActionListener(new LoadBudgetsGUI(budgetManager));
        viewBudgets.addActionListener(new ViewBudgetsGUI(budgetManager, frame, panel));
    }


    // EFFECTS: returns list of budget names in a list of String
    public String[] listOfBudgetNames(List<Budget> list) {
        List<String> listOfBudgetNames = new ArrayList<>();
        for (Budget i : list) {
            listOfBudgetNames.add(i.getName());
        }
        String[] arrayOfNames = new String[listOfBudgetNames.size()];
        listOfBudgetNames.toArray(arrayOfNames);
        return arrayOfNames;
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
