package model;

import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class PurchaseTest {
    private Purchase purchaseTest;

    @BeforeEach
    public void setUp() {
        try {
            purchaseTest = new Purchase("July 11", "Food", "FirstPurchase", 5);
        } catch (PriceIsNegative e) {
            // nothing expected
        }
    }

    @Test
    public void purchaseExceptionThrown() {
        Purchase purchaseTests = null;

        try {
            purchaseTests = new Purchase("July 11", "Food", "FirstPurchase", -9);
            fail("should not be run");
        } catch (PriceIsNegative e) {
            try {
                purchaseTests = new Purchase("July 11", "Food", "FirstPurchase", 0);
            } catch (PriceIsNegative priceIsNegative) {
                // expected
            }
        }
        assertEquals("July 11", purchaseTests.getDate());
        assertEquals("Food", purchaseTests.getType());
        assertEquals("FirstPurchase", purchaseTests.getName());
        assertEquals(0, purchaseTests.getPrice());

    }

    @Test
    public void purchaseNoExceptionThrown() {
        try {
            purchaseTest = new Purchase("July 11", "Food", "FirstPurchase", 5);
        } catch (PriceIsNegative e) {
            fail("should not be run");
        }
        assertEquals("July 11", purchaseTest.getDate());
        assertEquals("Food", purchaseTest.getType());
        assertEquals("FirstPurchase", purchaseTest.getName());
        assertEquals(5, purchaseTest.getPrice());

    }


    @Test
    public void testConstructor() {
        assertEquals("July 11", purchaseTest.getDate());
        assertEquals("FirstPurchase", purchaseTest.getName());
        assertEquals("Food", purchaseTest.getType());
        assertEquals(5, purchaseTest.getPrice());

    }

    @Test
    public void testToJSON() {
        Purchase purchase = null;
        try {
            purchase = new Purchase("july 11", "food", "taco bell", 50);
        } catch (PriceIsNegative e) {
           // not expected
        }

        JSONObject json = new JSONObject();

        json.put("date", purchase.getDate());
        json.put("type", purchase.getType());
        json.put("name", purchase.getName());
        json.put("price", purchase.getPrice());

        assertEquals(json.toString(), purchase.toJson().toString());

    }

}
