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

    public LoadBudgetsGUI(BudgetManager bm) {
        this.bm = bm;
        jsonReader = new JsonReader(JSON_STORE);
    }


    // how i return the list of budgets to the main ui to put in a jlist and display?
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            budgetManager = jsonReader.read();
            bm.setListOfBudgets(budgetManager.getListOfBudgets());
        // copy the list from bm to
//            // should i put the loop here or in main ui
//            // how do i put the list in a scroll panel to select from?
            System.out.println("Loaded budgets" + " from " + JSON_STORE);
        } catch (IOException t) {
            System.out.println("Unable to read from file: " + JSON_STORE);
        }
    }


//
//    viewBudgets.addActionListener(new ActionListener() {
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            frame.setVisible(false);      // main menu frame is invisible now
//            panel.setVisible(false);
//
//            JPanel panel2 = new JPanel();
//            JFrame frame3 = new JFrame();
//            frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); /// what happens if window closes
//            frame3.setLayout(new BorderLayout());         // helpful for down the road?
//            frame3.add(panel2, BorderLayout.PAGE_END);  //  adds the panel into the window frame and give its
//            // a proper layout
//            frame3.setTitle("Budget Manager");           // sets the title for the frame
//
//            backButton = new JButton("Back");
//            panel2.add(backButton);
//            addPurchase = new JButton("Add Purchase");
//            panel2.add(addPurchase);
//            showDetails = new JButton("Show Details");
//            panel2.add(showDetails);
//
//            String[] listofBudgetNames = listOfBudgetNames(budgetManager.getListOfBudgets());
//            //System.out.println(Arrays.toString(listofBudgetNames));
//            frame3.add(new JList(listofBudgetNames));
//            frame3.pack();
//            frame3.setVisible(true);
//
//            // select one of budgets to show details on
//        }
//    });
//
//    }
}



//list.addMouseListener(new MouseAdapter() {
//@Override
//public void mouseClicked(MouseEvent e) {
//        if (e.getClickCount() == 1) {
//        JList pointer = (JList) e.getSource();
//        int index = pointer.locationToIndex(e.getPoint());
//        if (index >= 0) {
//        Object item = pointer.getModel().getElementAt(index);
//        items = (String) item;
//        nameOfBudget = new JLabel(items);
//        }


//    @Override
//    public void actionPerformed(ActionEvent e) {
//        list.addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseClicked(MouseEvent e) {
//                if (e.getClickCount() == 1) {
//                    JList pointer = (JList) e.getSource();
//                    int index = pointer.locationToIndex(e.getPoint());
//                    if (index >= 0) {
//                        Object item = pointer.getModel().getElementAt(index);
//                        items = (String) item;
//                        nameOfBudget = new JLabel(items);
//                    }
//                    System.out.println("button is clicked");
//                    Object[] message = {
//                            "Name of Budget", nameOfBudget,
//                            "Date of purchase", date,
//                            "Type of purchase", type,
//                            "Name of purchase", nameofpurchase,
//                            "Price of purchase", price
//                    };
//
//                    int result = JOptionPane.showConfirmDialog(parent, message);
//                    String priceString = price.getText();
//                    int priceInt = Integer.parseInt(priceString);
//
//                    if (result == JOptionPane.YES_OPTION) {
//                        Purchase purchase = new Purchase(date.getText(),
//                                type.getText(), nameofpurchase.getText(), priceInt);
//                        Budget budget = bm.viewBudgetsByName(items);
//                        budget.addPurchase(purchase);
//                        System.out.println(budget.getListOfPurchases());
//
//                        //budget.getListOfPurchases().add(purchase);
//                        // bm.getListOfBudgets().add(budget);
//                    }
//                }
//                //super.mouseClicked(e);
//            }
//        });
//    }
//}
