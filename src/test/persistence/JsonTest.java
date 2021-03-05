package persistence;

import model.Purchase;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JsonTest {

    // EFFECTS: compares the name, type, data and price to the given purchases fields
    protected void checkPurchase(String name, String type, String date, int price, Purchase purchase) {
        assertEquals(date, purchase.getDate());
        assertEquals(type, purchase.getType());
        assertEquals(name, purchase.getName());
        assertEquals(price, purchase.getPrice());
    }

}
