package model;

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

}
