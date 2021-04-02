package persistence;

import model.Budget;
import model.BudgetManager;
import model.PriceIsNegative;
import model.Purchase;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class JsonWriterTest extends JsonTest {

    @Test
    void testWriterInvalidFile() {
        try {
            BudgetManager testBM = new BudgetManager();
            JsonWriter writer = new JsonWriter("./data/my\0illegal:fileName.json");
            writer.open();
            fail("IOException was expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testWriterBudgetManagerEmpty() {
        try {
            BudgetManager bm = new BudgetManager();
            JsonWriter writer = new JsonWriter("./data/testWriterBudgetManagerEmpty.json");
            writer.open();
            writer.write(bm);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterBudgetManagerEmpty.json");
            bm = reader.read();
            assertEquals(0, bm.getListOfBudgets().size());
        } catch (FileNotFoundException e) {
            fail("it fails since it did not find the file");
        } catch (IOException e) {
            fail("it fails since it reached IOException");
        }
    }


    @Test
    void testWriterBudgetManagerFull() {
        try {
            BudgetManager bm = new BudgetManager();
            Budget budget1 = new Budget("Budget1");
            Budget budget2 = new Budget("budget2");

            try {
                budget1.addPurchase(new Purchase("july 11", "food", "purchase1", 40));
                budget1.addPurchase(new Purchase("july 5", "travel", "purchase2", 12));
            } catch (PriceIsNegative e) {
                e.printStackTrace();
            }

            bm.getListOfBudgets().add(budget1);

            bm.getListOfBudgets().add(budget2);

            try {
                budget2.addPurchase(new Purchase("july 13", "food", "purchase1", 40));
            } catch (PriceIsNegative e) {

            }

            JsonWriter writer = new JsonWriter("./data/testWriterBudgetManagerFull.json");
            writer.open();
            writer.write(bm);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterBudgetManagerFull.json");
            bm = reader.read();
            assertEquals(2, bm.getListOfBudgets().size());
            assertEquals("Budget1", bm.getListOfBudgets().get(0).getName());
            checkPurchase("purchase1", "food", "july 11", 40,
                    bm.getListOfBudgets().get(0).getListOfPurchases().get(0));
            checkPurchase("purchase2", "travel", "july 5", 12,
                    bm.getListOfBudgets().get(0).getListOfPurchases().get(1));
            assertEquals("budget2", bm.getListOfBudgets().get(1).getName());
            checkPurchase("purchase1", "food", "july 13", 40,
                    bm.getListOfBudgets().get(1).getListOfPurchases().get(0));





        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
