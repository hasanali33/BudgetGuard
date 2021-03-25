package ui;

import model.Budget;
import model.BudgetManager;
import model.Purchase;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.io.File;


public class AddPurchaseGUI {
    private BudgetManager bm;
    private JList list;
    private JPanel panel;
    private JPanel panel2;
    private JFrame frame;
    private JFrame frame3;
    private JFrame parent;
    private JTextField nameofpurchase;
    private JTextField date;
    private JTextField type;
    private JTextField price;
    private JLabel nameOfBudget;
    private String value;
    private List<JTextField> fields;
    private int result;
    private Object[] message;
    private int priceInt;

    // EFFECTS: constructs a AddPurchaseGUI with a budgetmanager, JList, 2 JPanels, 2 Jframes and 1 string
    public AddPurchaseGUI(BudgetManager bm, JList list, JPanel panel, JPanel panel2,
                          JFrame frame, JFrame frame3, String value) {
        this.bm = bm;
        this.list = list;
        this.panel = panel;
        this.panel2 = panel2;
        this.frame = frame;
        this.frame3 = frame3;
        this.value = value;
        setUpTextFields();
        parent = new JFrame();
        fields = new ArrayList<>();
        nameOfBudget = new JLabel(value);
        addFieldsToArrayList();
        message = new Object[]{
                "Name of Budget", nameOfBudget,
                "Date of purchase", date,
                "Type of purchase", type,
                "Name of purchase", nameofpurchase,
                "Price of purchase", price
        };
        result = JOptionPane.showConfirmDialog(parent, message);
        String priceString = price.getText();
        priceInt = Integer.parseInt(priceString);
        addPurchaseToBudgetWhenYesIsClicked();
    }


    // EFFECTS: constructs the nameOfPurchase, data, type and price JTextField
    public void setUpTextFields() {
        nameofpurchase = new JTextField();
        date = new JTextField();
        type = new JTextField();
        price = new JTextField();

    }

    // EFFECTS: adds all the necessary text fields into the Fields ArrayList
    public void addFieldsToArrayList() {
        fields.add(nameofpurchase);
        fields.add(date);
        fields.add(type);
        fields.add(price);
    }


    // MODIFIES: fields
    // EFFECTS: clears all the Jtext fields in the ArrayList
    public void clearFields() {
        for (JTextField field : fields) {
            field.setText(null);
        }

    }

    // EFFECTS: when yes is clicked, a purchase is made and added to the budget, as well as a sound goes off
    public void addPurchaseToBudgetWhenYesIsClicked() {
        if (result == JOptionPane.YES_OPTION) {
            Purchase purchase = new Purchase(date.getText(),
                    type.getText(), nameofpurchase.getText(), priceInt);
            Budget budget = bm.viewBudgetsByName(value);
            budget.addPurchase(purchase);
            System.out.println(budget.getListOfPurchases());
            URL soundbyte = null;
            try {
                soundbyte = new File("data/sound.wav").toURI().toURL();
            } catch (MalformedURLException e) {
                System.out.println("does not work");
            }
            java.applet.AudioClip clip = java.applet.Applet.newAudioClip(soundbyte);
            clip.play();

            clearFields();
        }
    }
}
