package ui;

import model.Budget;
import model.BudgetManager;
import model.Purchase;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
    private String s;
    private DefaultTableModel tableModel;
    private JPanel panelnewer;
    private JButton backButton;

    public ShowDetailsUI(BudgetManager bm, JList list, JPanel panel, JPanel panel2,
                         JFrame frame, JFrame frame3, JButton button) {
        this.bm = bm;
        this.list = list;
        this.panel = panel;
        this.panel2 = panel2;
        this.frame = frame;
        this.frame3 = frame3;
        frame4 = new JFrame();
        this.backButton = button;
        String[] columns = new String[] {
                "Date", "Type", "Name", "Price"
        };
        list.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                s = (String) list.getSelectedValue();
                System.out.println("Value Selected: " + s);
            }
        });
        Budget budget = bm.viewBudgetsByName(s);
        List<Purchase> listOfPurchases = budget.getListOfPurchases();
        tableModel = new DefaultTableModel(columns, 0);
        TableModel data = convertData(listOfPurchases);
        table = new JTable(data);
        frame4.add(table);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("buttttttton");
        frame4.setVisible(true);
        backButton.addActionListener((t) -> {
            frame.setVisible(true);
            panel.setVisible(true);
            frame3.setVisible(false);
        });
    }

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
