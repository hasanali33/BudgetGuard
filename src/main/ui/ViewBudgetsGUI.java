package ui;

import model.Budget;
import model.BudgetManager;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.text.View;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import ui.*;

public class ViewBudgetsGUI implements ActionListener {
    private BudgetManager bm;
    private JButton addPurchase;
    private JButton showDetails;
    private JButton backButton;
    private JFrame frame;
    private JPanel panel;
    private JList list;
    private JPanel panel2;
    private JFrame frame3;
    private String value;
    private ListSelectionListener listener;
    private JButton showTotalSpent;

    public ViewBudgetsGUI(BudgetManager bm, JFrame frame, JPanel panel) {
        this.bm = bm;
        this.frame = frame;
        this.panel = panel;
        panel2 = new JPanel();
        setUpFrame();
        setUpButtons();
       // String[] listofBudgetNames = listOfBudgetNames(bm.getListOfBudgets());
        list = new JList();
        frame3.add(list);
        frame3.pack();
        listener = new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (e.getValueIsAdjusting()) {
                    System.out.println("Hello you selected me!  "
                            + list.getSelectedValue().toString());
                    value = list.getSelectedValue().toString();
                }
            }
        };

        list.addListSelectionListener(listener);
        addPurchase.addActionListener((t) -> {
            setVisability();
            new AddPurchaseGUI(bm, list, panel, panel2, frame, frame3, value);
            // list.removeListSelectionListener(listener);
        });
        showDetails.addActionListener((f) -> {
            setVisability();
            new ShowDetailsUI(bm, list, panel, panel2, frame, frame3, value);
            //  showDetails.addActionListener(new ShowDetailsUI(bm, list, panel, panel2, frame, frame3, value));
        });
        showTotalSpent.addActionListener((g) -> {
            setVisability();
            new TotalSpentGUI(bm, list, panel, panel2, frame, frame3, value);
        });
    }

    public void setUpFrame() {
        frame3 = new JFrame();
        frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); /// what happens if window closes
        frame3.setLayout(new BorderLayout());         // helpful for down the road?
        frame3.add(panel2, BorderLayout.PAGE_END);  //  adds the panel into the window frame and give its
        // a proper layout
        frame3.setTitle("Budget Manager");           // sets the title for the frame

    }

    public void setUpButtons() {
        backButton = new JButton("Back");
        panel2.add(backButton);
        addPurchase = new JButton("Add Purchase");
        panel2.add(addPurchase);
        showDetails = new JButton("Show Details");
        panel2.add(showDetails);
        showTotalSpent = new JButton("Show Total Spent");
        panel2.add(showTotalSpent);
    }

    private void setVisability() {
        frame.setVisible(false);
        panel.setVisible(false);
        frame3.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        String[] listofBudgetNames = listOfBudgetNames(bm.getListOfBudgets());
        //list.clearSelection();
        DefaultListModel model = new DefaultListModel();
        for (int i = 0; i < listofBudgetNames.length; i++) {
            model.addElement(listofBudgetNames[i]);
        }
        list.setModel(model);
        frame3.setVisible(true);
        frame.setVisible(false);
        panel.setVisible(false);
        // defining a new function, press button it calls frame.setisible
        backButton.addActionListener((t) -> {
            frame.setVisible(true);
            panel.setVisible(true);
            frame3.setVisible(false);
           // list.removeListSelectionListener(listener);
        });
//        addPurchase.addActionListener(new AddPurchaseGUI(bm, list, panel, panel2, frame, frame3, value));
//        showDetails.addActionListener(new ShowDetailsUI(bm, list, panel, panel2, frame, frame3, value));
        System.out.println(showDetails.getActionListeners());
    }


    public String[] listOfBudgetNames(java.util.List<Budget> list) {
        List<String> listOfBudgetNames = new ArrayList<>();
        for (Budget i : list) {
            listOfBudgetNames.add(i.getName());
        }
        String[] arrayOfNames = new String[listOfBudgetNames.size()];
        listOfBudgetNames.toArray(arrayOfNames);
        return arrayOfNames;
    }


}
