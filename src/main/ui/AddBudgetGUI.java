package ui;

import model.Budget;
import model.BudgetManager;
import model.PriceIsNegative;
import model.Purchase;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class AddBudgetGUI implements ActionListener {
    private JFrame parent;
    private BudgetManager bm;
    private JTextField name;
    private JTextField date;
    private JTextField type;
    private JTextField nameofpurchase;
    private JTextField price;
    private Object[] message;



    // EFFECTS: constructs an AddBudgetGuI with a budgetmanager
    public AddBudgetGUI(BudgetManager bm) {
        parent = new JFrame();
        this.bm = bm;
    }

    // EFFECTS: intializes all the JTextFields
    public void initializeJTextFields() {
        name = new JTextField();
        date = new JTextField();
        type = new JTextField();
        nameofpurchase = new JTextField();
        price = new JTextField();
        message = new Object[]{
                "Name of Budget", name,
                "Date of purchase", date,
                "Type of purchase", type,
                "Name of purchase", nameofpurchase,
                "Price of purchase", price
        };


    }


    // EFFECTS: popup window is shown with textfields for a purchase, once user
    //          presses "Yes" to add, then it is added to specified budget
    @Override
    public void actionPerformed(ActionEvent e) {
        initializeJTextFields();

//        Object[] message = {
//                "Name of Budget",  name,
//                "Date of purchase", date,
//                "Type of purchase", type,
//                "Name of purchase", nameofpurchase,
//                "Price of purchase", price
//        };

        int result = JOptionPane.showConfirmDialog(parent, message);
        String nameParsed = name.getText();
        String priceString = price.getText();
        int priceInt = Integer.parseInt(priceString);

        if (result == JOptionPane.YES_OPTION) {
            Budget budget = new Budget(nameParsed);

            Purchase purchase = null;
            try {
                purchase = new Purchase(date.getText(), type.getText(), nameofpurchase.getText(), priceInt);
            } catch (PriceIsNegative priceIsNegative) {
                try {
                    purchase = new Purchase(date.getText(), type.getText(), nameofpurchase.getText(), 0);
                } catch (PriceIsNegative isNotIntException) {
                    isNotIntException.printStackTrace();
                }
            }

            budget.getListOfPurchases().add(purchase);
            bm.getListOfBudgets().add(budget);
        }
    }
}
