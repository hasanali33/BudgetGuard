package ui;

import model.Budget;
import model.BudgetManager;
import model.Purchase;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class AddBudgetGUI implements ActionListener {
    private JFrame parent;
    private BudgetManager bm;


    public AddBudgetGUI(BudgetManager bm) {
        parent = new JFrame();
        this.bm = bm;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("button is clicked");
        JTextField name = new JTextField();
        JTextField date = new JTextField();
        JTextField type = new JTextField();
        JTextField nameofpurchase = new JTextField();
        JTextField price = new JTextField();

        Object[] message = {
                "Name of Budget",  name,
                "Date of purchase", date,
                "Type of purchase", type,
                "Name of purchase", nameofpurchase,
                "Price of purchase", price
        };

        int result = JOptionPane.showConfirmDialog(parent, message);
        String nameParsed = name.getText();
        String priceString = price.getText();
        int priceInt = Integer.parseInt(priceString);

        if (result == JOptionPane.YES_OPTION) {
            Budget budget = new Budget(nameParsed);

            Purchase purchase = new Purchase(date.getText(), type.getText(), nameofpurchase.getText(), priceInt);

            budget.getListOfPurchases().add(purchase);
            bm.getListOfBudgets().add(budget);
        }
    }
}
