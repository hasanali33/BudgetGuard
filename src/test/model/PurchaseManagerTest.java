package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class PurchaseManagerTest {


    private PurchaseManager testManager;

    @BeforeEach
    public void setUp() {
        testManager = new PurchaseManager();
    }

    @Test
    public void testConstructor() {
        assertEquals(0, testManager.getListOfPurchases().size());
    }

    @Test
    public void testAddPurchase() {
        Purchase testPurchase = new Purchase("July 11", "Food", "Taco Bell", 3);

        testManager.addPurchase(testPurchase);
        assertEquals(1, testManager.getListOfPurchases().size());

        System.out.println(testPurchase);
        assertEquals("July 11: (Food) Taco Bell $3", testManager.getListOfPurchases().get(0).toString());
    }


    @Test
    public void testAddMulitiplePurchases() {
        Purchase testPurchase = new Purchase("July 11", "Food", "Taco Bell", 3);

        testManager.addPurchase(testPurchase);
        assertEquals(1, testManager.getListOfPurchases().size());
        assertEquals("July 11: (Food) Taco Bell $3", testManager.getListOfPurchases().get(testManager.getListOfPurchases().size() - 1).toString());

        Purchase testPurchaseTwo = new Purchase("July 15", "Travel", "Airplane Ticket", 350);

        testManager.addPurchase(testPurchaseTwo);
        assertEquals(2, testManager.getListOfPurchases().size());
        assertEquals("July 15: (Travel) Airplane Ticket $350", testManager.getListOfPurchases().get(testManager.getListOfPurchases().size() - 1).toString());

    }


    @Test
    public void testViewPurchasesByDate() {
        Purchase testPurchase = new Purchase("July 11", "Food", "Taco Bell", 3);
        Purchase testPurchaseTwo = new Purchase("July 11", "Rent", "Apartment Rent", 500);
        Purchase testPurchaseThree = new Purchase("July 15", "Travel", "Airplane Ticket", 350);

        testManager.addPurchase(testPurchase); // 0
        testManager.addPurchase(testPurchaseTwo); // 1
        testManager.addPurchase(testPurchaseThree); // 2

        ArrayList<Purchase> sortedList = testManager.viewPurchasesByDate("July 11");

        assertEquals(2, sortedList.size());

        assertEquals("July 11: (Food) Taco Bell $3", sortedList.get(0).toString());
        assertEquals("July 11: (Rent) Apartment Rent $500", sortedList.get(1).toString());


    }

    @Test
    public void testDeletePurchase() {
        Purchase testPurchase = new Purchase("July 11", "Food", "Taco Bell", 3);
        testManager.addPurchase(testPurchase);

        assertEquals(1, testManager.getListOfPurchases().size());

        testManager.removePurchase(testPurchase);

        assertEquals(0, testManager.getListOfPurchases().size());


    }


    @Test
    public void testDeleteMultiplePurchases() {
        Purchase testPurchase = new Purchase("July 11", "Food", "Taco Bell", 3);
        Purchase testPurchaseTwo = new Purchase("July 11", "Rent", "Apartment Rent", 500);
        Purchase testPurchaseThree = new Purchase("July 15", "Travel", "Airplane Ticket", 350);
        Purchase testPurchaseFour = new Purchase("July 20", "Travel", "Food Ticket", 20);

        testManager.addPurchase(testPurchase); // 0
        testManager.addPurchase(testPurchaseTwo); // 1
        testManager.addPurchase(testPurchaseThree); // 2
        testManager.addPurchase(testPurchaseFour); // 3

        assertEquals(4, testManager.getListOfPurchases().size());

        testManager.removePurchase(testPurchaseTwo);

        assertEquals(3, testManager.getListOfPurchases().size());

        assertEquals("July 20: (Travel) Food Ticket $20", testManager.getListOfPurchases().get(2).toString());
        assertEquals("July 15: (Travel) Airplane Ticket $350", testManager.getListOfPurchases().get(1).toString());
        assertEquals("July 11: (Food) Taco Bell $3", testManager.getListOfPurchases().get(0).toString());

        testManager.removePurchase(testPurchase);


        assertEquals(2, testManager.getListOfPurchases().size());

        assertEquals("July 15: (Travel) Airplane Ticket $350", testManager.getListOfPurchases().get(0).toString());
        assertEquals("July 20: (Travel) Food Ticket $20", testManager.getListOfPurchases().get(1).toString());
    }

    @Test
    public void testViewPurchaseByPrice() {

        Purchase testPurchase = new Purchase("July 11", "Food", "Taco Bell", 3);
        Purchase testPurchaseTwo = new Purchase("July 11", "Rent", "Apartment Rent", 500);
        Purchase testPurchaseThree = new Purchase("July 15", "Travel", "Airplane Ticket", 350);
        Purchase testPurchaseFour = new Purchase("July 20", "Travel", "Food Ticket", 20);


        testManager.addPurchase(testPurchase);
        testManager.addPurchase(testPurchaseTwo);
        testManager.addPurchase(testPurchaseThree);
        testManager.addPurchase(testPurchaseFour);

        assertEquals(4, testManager.getListOfPurchases().size());

        ArrayList<Purchase> unsortedList = testManager.getListOfPurchases();


        assertEquals("July 11: (Food) Taco Bell $3", testManager.showPurchasesByPrice().get(3).toString());
        assertEquals("July 20: (Travel) Food Ticket $20", testManager.showPurchasesByPrice().get(2).toString());
        assertEquals("July 15: (Travel) Airplane Ticket $350", testManager.showPurchasesByPrice().get(1).toString());
        assertEquals("July 11: (Rent) Apartment Rent $500", testManager.showPurchasesByPrice().get(0).toString());

    }

    @Test
    public void testGetListOfDates() {
        Purchase testPurchase = new Purchase("July 11", "Food", "Taco Bell", 3);
        Purchase testPurchaseTwo = new Purchase("July 11", "Rent", "Apartment Rent", 500);
        Purchase testPurchaseThree = new Purchase("July 15", "Travel", "Airplane Ticket", 350);
        Purchase testPurchaseFour = new Purchase("July 20", "Travel", "Food Ticket", 20);


        testManager.addPurchase(testPurchase);
        testManager.addPurchase(testPurchaseTwo);
        testManager.addPurchase(testPurchaseThree);
        testManager.addPurchase(testPurchaseFour);

        ArrayList<String> dates = testManager.getListOfDates();

        assertEquals("July 11", dates.get(0));
        assertEquals("July 15", dates.get(1));
        assertEquals("July 20", dates.get(2));


    }






}