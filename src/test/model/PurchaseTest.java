package model;

import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PurchaseTest {
    private Purchase purchaseTest;

    @BeforeEach
    public void setUp() {
        purchaseTest = new Purchase("July 11", "Food", "FirstPurchase", 5);

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
        Purchase purchase = new Purchase("july 11", "food", "taco bell", 50);

        JSONObject json = new JSONObject();

        json.put("date", purchase.getDate());
        json.put("type", purchase.getType());
        json.put("name", purchase.getName());
        json.put("price", purchase.getPrice());

        assertEquals(json.toString(), purchase.toJson().toString());

    }

}
