package model;

import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

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
        assertEquals(0, testBudget.getListOfPurchases().size());
    }

    @Test
    public void testAddPurchase() {
        Purchase testPurchase = new Purchase("July 11", "Food", "Taco Bell", 3);

        testBudget.addPurchase(testPurchase);
        assertEquals(1, testBudget.getListOfPurchases().size());

        System.out.println(testPurchase);
        assertEquals("July 11: (Food) Taco Bell $3", testBudget.getListOfPurchases().get(0).toString());
    }


    @Test
    public void testAddMulitiplePurchases() {
        Purchase testPurchase = new Purchase("July 11", "Food", "Taco Bell", 3);

        testBudget.addPurchase(testPurchase);
        assertEquals(1, testBudget.getListOfPurchases().size());
        assertEquals("July 11: (Food) Taco Bell $3", testBudget.getListOfPurchases().get(testBudget.getListOfPurchases().size() - 1).toString());

        Purchase testPurchaseTwo = new Purchase("July 15", "Travel", "Airplane Ticket", 350);

        testBudget.addPurchase(testPurchaseTwo);
        assertEquals(2, testBudget.getListOfPurchases().size());
        assertEquals("July 15: (Travel) Airplane Ticket $350", testBudget.getListOfPurchases().get(testBudget.getListOfPurchases().size() - 1).toString());

    }


    @Test
    public void testViewPurchasesByDate() {
        Purchase testPurchase = new Purchase("July 11", "Food", "Taco Bell", 3);
        Purchase testPurchaseTwo = new Purchase("July 11", "Rent", "Apartment Rent", 500);
        Purchase testPurchaseThree = new Purchase("July 15", "Travel", "Airplane Ticket", 350);

        testBudget.addPurchase(testPurchase); // 0
        testBudget.addPurchase(testPurchaseTwo); // 1
        testBudget.addPurchase(testPurchaseThree); // 2

        ArrayList<Purchase> sortedList = testBudget.viewPurchasesByDate("July 11");

        assertEquals(2, sortedList.size());

        assertEquals("July 11: (Food) Taco Bell $3", sortedList.get(0).toString());
        assertEquals("July 11: (Rent) Apartment Rent $500", sortedList.get(1).toString());


    }

    @Test
    public void testViewPurchasesByType() {
        Purchase testPurchase = new Purchase("July 11", "Food", "Taco Bell", 3);
        Purchase testPurchaseTwo = new Purchase("July 12", "Rent", "Apartment Rent", 500);
        Purchase testPurchaseThree = new Purchase("July 15", "Travel", "Airplane Ticket", 350);
        Purchase testPurchaseFour = new Purchase("July 16", "Food", "Culvers", 30);

        testBudget.addPurchase(testPurchase); // 0
        testBudget.addPurchase(testPurchaseTwo); // 1
        testBudget.addPurchase(testPurchaseThree); // 2
        testBudget.addPurchase(testPurchaseFour); // 3

        ArrayList<Purchase> sortedList = testBudget.viewPurchasesByType("Food");

        assertEquals(2, sortedList.size());

        assertEquals("July 11: (Food) Taco Bell $3", sortedList.get(0).toString());
        assertEquals("July 16: (Food) Culvers $30", sortedList.get(1).toString());
    }

    @Test
    public void testDeletePurchase() {
        Purchase testPurchase = new Purchase("July 11", "Food", "Taco Bell", 3);
        testBudget.addPurchase(testPurchase);

        assertEquals(1, testBudget.getListOfPurchases().size());

        testBudget.removePurchase(testPurchase);

        assertEquals(0, testBudget.getListOfPurchases().size());


    }


    @Test
    public void testDeleteMultiplePurchases() {
        Purchase testPurchase = new Purchase("July 11", "Food", "Taco Bell", 3);
        Purchase testPurchaseTwo = new Purchase("July 11", "Rent", "Apartment Rent", 500);
        Purchase testPurchaseThree = new Purchase("July 15", "Travel", "Airplane Ticket", 350);
        Purchase testPurchaseFour = new Purchase("July 20", "Travel", "Food Ticket", 20);

        testBudget.addPurchase(testPurchase); // 0
        testBudget.addPurchase(testPurchaseTwo); // 1
        testBudget.addPurchase(testPurchaseThree); // 2
        testBudget.addPurchase(testPurchaseFour); // 3

        assertEquals(4, testBudget.getListOfPurchases().size());

        testBudget.removePurchase(testPurchaseTwo);

        assertEquals(3, testBudget.getListOfPurchases().size());

        assertEquals("July 20: (Travel) Food Ticket $20", testBudget.getListOfPurchases().get(2).toString());
        assertEquals("July 15: (Travel) Airplane Ticket $350", testBudget.getListOfPurchases().get(1).toString());
        assertEquals("July 11: (Food) Taco Bell $3", testBudget.getListOfPurchases().get(0).toString());

        testBudget.removePurchase(testPurchase);


        assertEquals(2, testBudget.getListOfPurchases().size());

        assertEquals("July 15: (Travel) Airplane Ticket $350", testBudget.getListOfPurchases().get(0).toString());
        assertEquals("July 20: (Travel) Food Ticket $20", testBudget.getListOfPurchases().get(1).toString());
    }

    @Test
    public void testGetListOfDates() {
        Purchase testPurchase = new Purchase("July 11", "Food", "Taco Bell", 3);
        Purchase testPurchaseTwo = new Purchase("July 11", "Rent", "Apartment Rent", 500);
        Purchase testPurchaseThree = new Purchase("July 15", "Travel", "Airplane Ticket", 350);
        Purchase testPurchaseFour = new Purchase("July 20", "Travel", "Food Ticket", 20);


        testBudget.addPurchase(testPurchase);
        testBudget.addPurchase(testPurchaseTwo);
        testBudget.addPurchase(testPurchaseThree);
        testBudget.addPurchase(testPurchaseFour);

        ArrayList<String> dates = testBudget.getListOfDates();

        assertEquals("July 11", dates.get(0));
        assertEquals("July 15", dates.get(1));
        assertEquals("July 20", dates.get(2));


    }


    @Test
    public void testGetListOfTypes() {
        Purchase testPurchase = new Purchase("July 11", "Food", "Taco Bell", 3);
        Purchase testPurchaseTwo = new Purchase("July 11", "Rent", "Apartment Rent", 500);
        Purchase testPurchaseThree = new Purchase("July 15", "Travel", "Airplane Ticket", 350);
        Purchase testPurchaseFour = new Purchase("July 20", "Travel", "Food Ticket", 20);


        testBudget.addPurchase(testPurchase);
        testBudget.addPurchase(testPurchaseTwo);
        testBudget.addPurchase(testPurchaseThree);
        testBudget.addPurchase(testPurchaseFour);

        ArrayList<String> types = testBudget.getListOfTypes();

        assertEquals("Food", types.get(0));
        assertEquals("Rent", types.get(1));
        assertEquals("Travel", types.get(2));


    }

//    @Test
//    public void testPurchasesToJson() {
//        Budget budget1 = new Budget("london");
//        //Budget budget2 = new Budget("tokyo");
//
//        Purchase purchase1 = new Purchase("july 11", "food", "taco bell", 90);
//        Purchase purchase2 = new Purchase("sept 5", "travel", "airline ticket", 500);
//
//        budget1.addPurchase(purchase1);
//        budget1.addPurchase(purchase2);
//
//        JSONObject json = new JSONObject();
//
//        //json.put("name", budget1.getName());
//        json.put("purchases", budget1.getListOfPurchases());
//
//        assertEquals(json.toString(), budget1.purchasesToJson().toString());
//
//    }


    @Test
    public void testToJSON() {
        Budget budget1 = new Budget("london");

        JSONObject json = new JSONObject();

        json.put("name", budget1.getName());
        json.put("purchases", budget1.getListOfPurchases());

        assertEquals(json.toString(), budget1.toJson().toString());


    }




}
