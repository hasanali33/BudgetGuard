package model;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import persistence.JsonWriter;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BudgetManagerTest {

    private BudgetManager budgetManagerTest;

    @BeforeEach
    public void setUp() {
        budgetManagerTest = new BudgetManager();
    }


    @Test
    public void testConstructor() {
        assertEquals(0, budgetManagerTest.getListOfBudgets().size());
    }


    @Test
    public void testViewListOfBudgetsName() {
        Budget Tokyo = new Budget("Tokyo");
        Budget London = new Budget("London");
        Budget LondonTwo = new Budget("London");
        Budget Paris = new Budget("Paris");


        budgetManagerTest.getListOfBudgets().add(Tokyo);
        budgetManagerTest.getListOfBudgets().add(London);
        budgetManagerTest.getListOfBudgets().add(Paris);
        budgetManagerTest.getListOfBudgets().add(LondonTwo);


        List<String> listOfNames = budgetManagerTest.getListOfName();

        assertEquals("Tokyo", listOfNames.get(0));
        assertEquals("London", listOfNames.get(1));
        assertEquals("Paris", listOfNames.get(2));

    }


    @Test
    public void testGetListOfBudgets() {
        List<Budget> placeHolder = budgetManagerTest.getListOfBudgets();

        assertEquals(0, placeHolder.size());
    }

    @Test
    public void testSetListOfBudgets() {
        Budget Tokyo = new Budget("Tokyo");
        List<Budget> budgets = new ArrayList<>();
        budgets.add(Tokyo);
        assertEquals(1, budgets.size());
        assertEquals(0, budgetManagerTest.getListOfBudgets().size());
        budgetManagerTest.setListOfBudgets(budgets);
        assertEquals("Tokyo", budgetManagerTest.getListOfBudgets().get(0).getName());

    }


    @Test
    public void testViewBudgetsByName() {
        Budget Tokyo = new Budget("Tokyo");
        Budget London = new Budget("London");
        Budget Paris = new Budget("Paris");


        budgetManagerTest.getListOfBudgets().add(Tokyo);
        budgetManagerTest.getListOfBudgets().add(London);
        budgetManagerTest.getListOfBudgets().add(Paris);

        Budget listOfBudgets = budgetManagerTest.viewBudgetsByName("London");

        assertEquals("London", listOfBudgets.getName());

    }

//    @Test
//    public void testBudgetsToJSON() {
//        Budget budget = new Budget("london");
//        Budget budget2 = new Budget("tokyo");
//
//        budgetManagerTest.getListOfBudgets().add(budget);
//        budgetManagerTest.getListOfBudgets().add(budget2);
//
//        JSONObject json = new JSONObject();
//        json.put("name", budgetManagerTest.getListOfBudgets().get(0).getName());
//        json.put("purchases", budgetManagerTest.getListOfBudgets().get(0).getListOfPurchases());
//        // is it overrriding? how to avoid?
//        json.put("name", budgetManagerTest.getListOfBudgets().get(1).getName());
//        json.put("purchases", budgetManagerTest.getListOfBudgets().get(1).getListOfPurchases());
//
//
//
//
//
//        //assertEquals(1, budgetManagerTest.getListOfBudgets().size());
//        //JSONArray testArray = budgetManagerTest.budgetsToJson();
//        assertEquals(json.toString(), budgetManagerTest.budgetsToJson().toString());
//    }

//    @Test
//    public void testToJSON() {
//        Budget budget = new Budget("london");
//        budgetManagerTest.getListOfBudgets().add(budget);
//
//        JSONObject json = new JSONObject();
//        json.put("name", budgetManagerTest.getListOfBudgets().get(0).getName());
//        json.put("purchases", budgetManagerTest.getListOfBudgets().get(0).getListOfPurchases());
//
//        assertEquals(json.toString(), budgetManagerTest.budgetsToJson().toString());
//
//    }
}
