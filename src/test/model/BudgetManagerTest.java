package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
}
