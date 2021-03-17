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
//        ListSelectionListener listSelectionListener = new ListSelectionListener() {
//            @Override
//            public void valueChanged(ListSelectionEvent e) {
//                System.out.println("First index: " + e.getFirstIndex());
//                System.out.println(", Last index: " + e.getLastIndex());
//                boolean adjust = e.getValueIsAdjusting();
//                System.out.println(", Adjusting? " + adjust);
//                if (!adjust) {
//                    JList listed = (JList) e.getSource();
//                    int selections[] = listed.getSelectedIndices();
//                    Object selectionValues[] = listed.getSelectedValues();
//                    for (int i = 0, n = selections.length; i < n; i++) {
//                        if (i == 0) {
//                            System.out.println(" Selections: ");
//                        }
//                        System.out.println(selections[i] + "/" + selectionValues[i] + " ");
//                    }
//                }
//            }
//        };
//        list.addListSelectionListener(listSelectionListener);
//
//        frame.setSize(350, 200);
//        frame.setVisible(true);
//
//    }
//        }
//        list.addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseClicked(MouseEvent e) {
//                s = (String) list.getSelectedValue();
//                System.out.println("Value Selectedddd: " + s);
//            }
//        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("inside");
//        Budget budget = bm.viewBudgetsByName(s);
//        List<Purchase> listOfPurchases = budget.getListOfPurchases();
//        columns = new String[] {
//                "Date", "Type", "Name", "Price"
//        };
//        tableModel = new DefaultTableModel(columns, 0);
//        TableModel data = convertData(listOfPurchases);
//        table = new JTable(data);
//        table.setDefaultEditor(Object.class, null); // disables user edits onto text box
//        frame4.add(new JScrollPane(table));
//        //frame4.add(table);
//        frame4.setVisible(true);


//        frame4.addWindowListener(new WindowAdapter() {
//            @Override
//            public void windowClosing(WindowEvent e) {
//                tableModel.setRowCount(0);
//            }
//        });
        //list.removeMouseListener(mouse);

        // purchases update but to a different window, sometimes not right budget
        // when clicked it, it changes
        // add purchase shows up again

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
