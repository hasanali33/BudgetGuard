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
        assertEquals("July 11: (Food) Taco Bell $3", testManager.getListOfPurchases().get(0));
    }


    @Test
    public void testAddMulitiplePurchases() {
        Purchase testPurchase = new Purchase("July 11", "Food", "Taco Bell", 3);

        testManager.addPurchase(testPurchase);
        assertEquals(1, testManager.getListOfPurchases().size());
        assertEquals("July 11: (Food) Taco Bell $3", testManager.getListOfPurchases().get(testManager.getListOfPurchases().size() - 1));

        Purchase testPurchaseTwo = new Purchase("July 15", "Travel", "Airplane Ticket", 350);

        testManager.addPurchase(testPurchaseTwo);
        assertEquals(2, testManager.getListOfPurchases().size());
        assertEquals("July 15: (Travel) Airplane Ticket $350", testManager.getListOfPurchases().get(testManager.getListOfPurchases().size() - 1));

    }


    @Test
    public void testViewPurchasesByDate() {
        Purchase testPurchase = new Purchase("July 11", "Food", "Taco Bell", 3);
        Purchase testPurchaseTwo = new Purchase("July 11", "Rent", "Apartment Rent", 500);
        Purchase testPurchaseThree = new Purchase("July 15", "Travel", "Airplane Ticket", 350);

        testManager.addPurchase(testPurchase);
        testManager.addPurchase(testPurchaseTwo);
        testManager.addPurchase(testPurchaseThree);

        ArrayList<Purchase> sortedList = testManager.viewPurchasesByDate("July 11");

        assertEquals(2, sortedList.size());

        assertEquals("July 11: (Rent) Apartment Rent $350", sortedList.get(0));
        assertEquals("July 11: (Food) Taco Bell $3", sortedList.get(1));


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

        testManager.addPurchase(testPurchase);
        testManager.addPurchase(testPurchaseTwo);
        testManager.addPurchase(testPurchaseThree);
        testManager.addPurchase(testPurchaseFour);

        assertEquals(4, testManager.getListOfPurchases().size());

        testManager.removePurchase(testPurchaseTwo);

        assertEquals(3, testManager.getListOfPurchases().size());

        assertEquals("July 20: (Travel) Food Ticket $350", testManager.getListOfPurchases().get(2));
        assertEquals("July 15: (Travel) Airplane Ticket $350", testManager.getListOfPurchases().get(1));
        assertEquals("July 11: (Food) Taco Bell $3", testManager.getListOfPurchases().get(0));

        testManager.removePurchase(testPurchase);


        assertEquals(2, testManager.getListOfPurchases().size());

        assertEquals("July 20: (Travel) Food Ticket $350", testManager.getListOfPurchases().get(0));
        assertEquals("July 15: (Travel) Airplane Ticket $350", testManager.getListOfPurchases().get(1));
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

        // want to return new list so should it be void? but i know cant return with void

        //testManager.showPurchasesByPrice();





















    }






}