package ui;

import model.Budget;
import model.BudgetManager;
import model.Purchase;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class AddPurchaseGUI implements ActionListener {
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
//        list.addMouseListener(new MouseAdapter() {
//            @Override
//        public void mouseClicked(MouseEvent e) {
//                s = (String) list.getSelectedValue();
//                System.out.println("Value Selected: " + s);
//            }
//        });
        fields.add(nameofpurchase);
        fields.add(date);
        fields.add(type);
        fields.add(price);

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


    public void setUpTextFields() {
        nameofpurchase = new JTextField();
        date = new JTextField();
        type = new JTextField();
        price = new JTextField();

    }


    @Override
    public void actionPerformed(ActionEvent e) {
//        Object[] message = {
//                "Name of Budget", nameOfBudget,
//                "Date of purchase", date,
//                "Type of purchase", type,
//                "Name of purchase", nameofpurchase,
//                "Price of purchase", price
//        };

        //int result = JOptionPane.showConfirmDialog(parent, message);
//        result = JOptionPane.showConfirmDialog(parent, message);
//        String priceString = price.getText();
//        int priceInt = Integer.parseInt(priceString);

        if (result == JOptionPane.YES_OPTION) {
            Purchase purchase = new Purchase(date.getText(),
                    type.getText(), nameofpurchase.getText(), priceInt);
            Budget budget = bm.viewBudgetsByName(value);
            budget.addPurchase(purchase);
            System.out.println(budget.getListOfPurchases());
            clearFields();
        }
    }



    public void clearFields() {
        for (JTextField field : fields) {
            field.setText(null);
        }

    }

    public void addPurchaseToBudgetWhenYesIsClicked() {
        if (result == JOptionPane.YES_OPTION) {
            Purchase purchase = new Purchase(date.getText(),
                    type.getText(), nameofpurchase.getText(), priceInt);
            Budget budget = bm.viewBudgetsByName(value);
            budget.addPurchase(purchase);
            System.out.println(budget.getListOfPurchases());
            clearFields();
        }
    }
}

// not clicking right away when I select an element on the list, it has to wait
// once budget is found, then add purchase.

            //budget.getListOfPurchases().add(purchase);
            // bm.getListOfBudgets().add(budget);

    //super.mouseClicked(e);
