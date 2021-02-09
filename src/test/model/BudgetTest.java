package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BudgetTest {

    private Budget testBudget;


    @BeforeEach
    public void setUp() {
        testBudget = new Budget("London");
    }

    @Test
    public void testConstructor() {
        assertEquals("London", testBudget.getName());
        assertEquals(0, testBudget.getPurchaseManager().getListOfPurchases().size());
    }

//    @Test
//    public void testAddToBudgetList() {
//        PurchaseManager testManager = new PurchaseManager();
//        //PurchaseManager testManagerTwo = new PurchaseManager();
//
//        Purchase testPurchase = new Purchase("July 11", "Food", "Taco Bell", 3);
//        Purchase testPurchaseTwo = new Purchase("July 12", "Rent", "Apartment Rent", 500);
//        Purchase testPurchaseThree = new Purchase("July 15", "Travel", "Airplane Ticket", 350);
//        Purchase testPurchaseFour = new Purchase("July 16", "Food", "Culvers", 30);
//
//        testManager.addPurchase(testPurchase); // 0
//        testManager.addPurchase(testPurchaseTwo); // 1
//        testManager.addPurchase(testPurchaseThree); // 2
//        testManager.addPurchase(testPurchaseFour); // 3
//
//        assertEquals(0, testBudget.getPurchaseManager().getListOfPurchases().size());
//
//        testBudget.addToBudgetList(testManager);
//
//        assertEquals(1, testBudget.getPurchaseManager().size());
//
//    }


//    @Test
//    public void testAddMultipleToBudgetList() {
//        PurchaseManager testManager = new PurchaseManager();
//        PurchaseManager testManagerTwo = new PurchaseManager();
//
//        Purchase testPurchase = new Purchase("July 11", "Food", "Taco Bell", 3);
//        Purchase testPurchaseTwo = new Purchase("July 12", "Rent", "Apartment Rent", 500);
//        Purchase testPurchaseThree = new Purchase("July 15", "Travel", "Airplane Ticket", 350);
//        Purchase testPurchaseFour = new Purchase("July 16", "Food", "Culvers", 30);
//
//        Purchase testPurchaseFive = new Purchase("July 19", "Food", "Taco Bell", 3);
//        Purchase testPurchaseSix = new Purchase("June 15", "Rent", "Apartment Rent", 500);
//        Purchase testPurchaseSeven = new Purchase("August 9", "Travel", "Airplane Ticket", 350);
//        Purchase testPurchaseEight = new Purchase("October 8", "Food", "Culvers", 30);
//
//        testManager.addPurchase(testPurchase); // 0
//        testManager.addPurchase(testPurchaseTwo); // 1
//        testManager.addPurchase(testPurchaseThree); // 2
//        testManager.addPurchase(testPurchaseFour); // 3
//
//
//        assertEquals(4, testManager.getListOfPurchases().size());
//
//        assertEquals(0, testBudget.getPurchaseManager().size());
//
//        testBudget.addToBudgetList(testManager);
//
//        assertEquals(1, testBudget.getPurchaseManager().size());
//
//
//        testManagerTwo.addPurchase(testPurchaseFive); // 0
//        testManagerTwo.addPurchase(testPurchaseSix); // 1
//        testManagerTwo.addPurchase(testPurchaseSeven); // 2
//        testManagerTwo.addPurchase(testPurchaseEight); // 3
//
//        assertEquals(4, testManagerTwo.getListOfPurchases().size());
//
//        testBudget.addToBudgetList(testManagerTwo);
//
//        assertEquals(2, testBudget.getPurchaseManager().size());
//
//    }



}
