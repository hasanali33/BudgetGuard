package persistence;

import model.BudgetManager;
import model.Purchase;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class JsonReaderTest extends JsonTest {

    @Test
    void testReaderNonExistentFile() {
        JsonReader reader = new JsonReader("./data/noSuchFile.json");
        try {
             BudgetManager bm = reader.read();
            fail("IOException expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testReaderBudgetManagerEmpty() {
        JsonReader reader = new JsonReader("./data/testReaderBudgetManagerEmpty.json");
        try {
            BudgetManager bm = reader.read();
            assertEquals(0, bm.getListOfBudgets().size());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    @Test
    void testReaderBudgetManagerFull() {
        JsonReader reader = new JsonReader("./data/testReaderBudgetManagerFull.json");
        try {
            BudgetManager bm = reader.read();
            assertEquals("Budget1", bm.getListOfBudgets().get(0).getName());
            List<Purchase> purchases = bm.getListOfBudgets().get(0).getListOfPurchases();
            assertEquals(2, purchases.size());
            checkPurchase("purchase1", "food", "july 11", 40, purchases.get(0));
            checkPurchase("purchase2", "travel", "july 5", 12, purchases.get(1));
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }


}
