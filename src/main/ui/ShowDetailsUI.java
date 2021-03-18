package ui;

import model.Budget;
import model.BudgetManager;
import model.Purchase;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

public class ShowDetailsUI implements ActionListener {
    private BudgetManager bm;
    private JList list;
    private JPanel panel;
    private JPanel panel2;
    private JFrame frame;
    private JFrame frame3;
    private JFrame frame4;
    private JTable table;
    private String value;
    private DefaultTableModel tableModel;
    private JButton backButton;
    private String[] columns;
    private MouseListener mouse;

    // EFFECTS: constructs a ShowDetailsUI with a budgetmanager, a JList, 2 JPanels, 2 JFrames, and a string
    public ShowDetailsUI(BudgetManager bm, JList list, JPanel panel, JPanel panel2,
                         JFrame frame, JFrame frame3, String value) {
        this.bm = bm;
        this.list = list;
        this.panel = panel;
        this.panel2 = panel2;
        this.frame = frame;
        this.frame3 = frame3;
        this.value = value;
        frame4 = new JFrame();
        Budget budget = bm.viewBudgetsByName(value);
        List<Purchase> listOfPurchases = budget.getListOfPurchases();
        columns = new String[] {
                "Date", "Type", "Name", "Price"
        };
        tableModel = new DefaultTableModel(columns, 0);
        TableModel data = convertData(listOfPurchases);
        table = new JTable(data);
        table.setDefaultEditor(Object.class, null); // disables user edits onto text box
        frame4.add(new JScrollPane(table));
        //frame4.add(table);
        frame4.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("inside");

    }

    // EFFECTS: converts the list of purchases into an object that is added into the tablemodel
    public TableModel convertData(List<Purchase> list) {
        for (int i = 0; i < list.size(); i++) {
            String date = list.get(i).getDate();
            String name = list.get(i).getName();
            String type = list.get(i).getType();
            int price = list.get(i).getPrice();

            Object[] data = {date, type, name, price};
            tableModel.addRow(data);
        }
        return tableModel;
    }
}
