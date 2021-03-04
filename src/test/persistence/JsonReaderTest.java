package persistence;

import model.Budget;
import model.BudgetManager;
import model.Purchase;
import org.json.JSONObject;
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

    @Test
    void testReaderBudgetManagerFilledWithBudgets() {
        JsonReader reader = new JsonReader("./data/testReaderBudgetManagerFilledWithBudgets.json");
        try {
            BudgetManager bm = reader.read();
            assertEquals("Budget1", bm.getListOfBudgets().get(0).getName());
            List<Purchase> purchases = bm.getListOfBudgets().get(0).getListOfPurchases();
            assertEquals(2, purchases.size());
            checkPurchase("purchase1", "food", "july 11", 40, purchases.get(0));
            checkPurchase("purchase2", "travel", "july 5", 12, purchases.get(1));

            BudgetManager bm2 = new BudgetManager();
            Budget budget1 = new Budget("Budget1");
            Budget budget2 = new Budget("budget2");
            Budget budget3 = new Budget("budget3");

            bm2.getListOfBudgets().add(budget1);
            bm2.getListOfBudgets().add(budget2);
            bm2.getListOfBudgets().add(budget3);

            Purchase p1 = new Purchase("july 11", "food", "purchase1", 40);
            Purchase p2 = new Purchase("july 5", "travel", "purchase2", 12);
            Purchase p3 = new Purchase("july 13", "food", "purchase9", 40);
            Purchase p4 = new Purchase("july 11", "food", "purchase8", 20);
            Purchase p5 = new Purchase("july 23", "school", "purchase4", 900);

            budget1.addPurchase(p1);
            budget1.addPurchase(p2);
            budget2.addPurchase(p3);
            budget3.addPurchase(p5);
            budget3.addPurchase(p4);
            //budget4.addPurchase(p2);

            JsonWriter writer = new JsonWriter("./data/testWriterBudgetManager.json");
            writer.open();
            writer.write(bm2);
            writer.close();

            JsonReader reader2 = new JsonReader("./data/testWriterBudgetManager.json");
            bm2 = reader2.read();

            assertEquals(bm2.budgetsToJson().toString(), bm.budgetsToJson().toString());

            assertEquals(bm2.getListOfBudgets().get(0).purchasesToJson().toString(), bm.getListOfBudgets().get(0).purchasesToJson().toString());
            //assertEquals(json.toString(), bm.budgetsToJson().toString());

            //assertEquals(,bm.getListOfBudgets().get(0).purchasesToJson());


        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }







}
