package persistence;

import model.Budget;
import model.BudgetManager;
import model.PriceIsNegative;
import model.Purchase;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class JsonReader {

    // Represents a reader that reads BudgetManager from JSONFile
    // Citation: code taken and modified from JsonReader.javapackage in JsonSerializationDemo



    private String source;


    public JsonReader(String source) {
        this.source = source;
    }


    // EFFECTS: reads budgetmanager from file and returns it;
    // throws IOException if an error occurs reading data from file
    public BudgetManager read() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseBudgetManager(jsonObject);
    }


    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }

        return contentBuilder.toString();
    }



    // EFFECTS: parses budgetmanager from JSON object and returns it
    private BudgetManager parseBudgetManager(JSONObject jsonObject) {
       // String name = jsonObject.getString("name");
        BudgetManager bm = new BudgetManager();
        addBudgets(bm, jsonObject);
        return bm;
    }

    // MODIFIES: wr
    // EFFECTS: parses budgets from JSON object and adds them to BudgetManager
    private void addBudgets(BudgetManager bm, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("budgets"); // getting first list of items(first square bracket)
        // in jsonARRAY is listofbudget
        for (Object json : jsonArray) {
            JSONObject nextBudget = (JSONObject) json;
            addBudget(bm, nextBudget);
        }
    }

    // MODIFIES: bm
    // EFFECTS: parses budget from JSON object and adds it to BudgetManager
    private void addBudget(BudgetManager bm, JSONObject jsonObject) {
        String name = jsonObject.getString("name");
        JSONArray jsonArray = jsonObject.getJSONArray("purchases");

        Budget budget = new Budget(name);

        for (Object json : jsonArray) {
            JSONObject purchase = (JSONObject) json;

            String nameOfPurchase = purchase.getString("name");
            String type = purchase.getString("type");
            String date = purchase.getString("date");
            int price = purchase.getInt("price");

            Purchase newPurchase = null;
            try {
                newPurchase = new Purchase(date, type, nameOfPurchase, price);
            } catch (PriceIsNegative e) {
                try {
                    newPurchase = new Purchase(date, type, nameOfPurchase, 0);
                } catch (PriceIsNegative priceIsNegative) {
                    // not expected
                }
            }
            budget.addPurchase(newPurchase);
        }
        // inside of for loop going thru purchases
        // gettype,string similar to line 67,

        // go through each of the object in jsonarray and then add that purhcase to budget you just created
        bm.getListOfBudgets().add(budget);
    }
}

