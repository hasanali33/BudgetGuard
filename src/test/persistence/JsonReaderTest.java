package persistence;

import model.Budget;
import model.BudgetManager;
import model.PriceIsNegative;
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
            assertEquals(3, purchases.size());
            checkPurchase("purchase1", "food", "july 11", 40, purchases.get(0));
            checkPurchase("purchase2", "travel", "july 5", 12, purchases.get(1));
            checkPurchase("purchase3", "school", "august 1", 0, purchases.get(2));
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
            assertEquals(3, purchases.size());
            checkPurchase("purchase1", "food", "july 11", 40, purchases.get(0));
            checkPurchase("purchase2", "travel", "july 5", 12, purchases.get(1));
            checkPurchase("purchase3", "school", "august 1", 0, purchases.get(2));



            // compare both budgetmanagers to see if budgetstojson and purchasestojson works

            BudgetManager bm2 = new BudgetManager();
            Budget budget1 = new Budget("Budget1");
            Budget budget2 = new Budget("budget2");
            Budget budget3 = new Budget("budget3");

            bm2.getListOfBudgets().add(budget1);
            bm2.getListOfBudgets().add(budget2);
            bm2.getListOfBudgets().add(budget3);

            Purchase p1 = null;
            Purchase p2 = null;
            Purchase p3 = null;
            Purchase p4 = null;
            Purchase p5 = null;
            Purchase p6 = null;
            try {
                p1 = new Purchase("july 11", "food", "purchase1", 40);
                p2 = new Purchase("july 5", "travel", "purchase2", 12);
                p3 = new Purchase("july 13", "food", "purchase9", 40);
                p4 = new Purchase("july 11", "food", "purchase8", 20);
                p5 = new Purchase("july 23", "school", "purchase4", 900);
                p6 = new Purchase("august 1", "school", "purchase3", -900);
            } catch (PriceIsNegative e) {
                try {
                    p6 = new Purchase("august 1", "school", "purchase3", 0);
                } catch (PriceIsNegative priceIsNegative) {
                    // not expected
                }
            }

            budget1.addPurchase(p1);
            budget1.addPurchase(p2);
            budget1.addPurchase(p6);
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

            assertEquals(bm2.toJson().toString(), bm.toJson().toString());

            assertEquals(bm2.getListOfBudgets().get(0).toJson().toString(),
                    bm.getListOfBudgets().get(0).toJson().toString());


        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }







}
