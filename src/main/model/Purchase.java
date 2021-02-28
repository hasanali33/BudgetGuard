package model;

import org.json.JSONObject;
import persistence.Writable;

public class Purchase implements Writable {

    private String name;
    private String type;
    private String date;
    private int price;


    // EFFECTS: creates a purchase object with the date, type, name and price
    public Purchase(String date, String type, String name, int price) {
        this.name = name;
        this.type = type;
        this.date = date;
        this.price = price;

    }

    @Override
    public String toString() {
        return this.getDate() + ": (" + this.getType() + ") " + this.getName() + " $" + this.getPrice();
    }

    public String getName() {
        return this.name;
    }

    public String getType() {
        return this.type;
    }

    public String getDate() {
        return this.date;
    }

    public int getPrice() {
        return this.price;
    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", name);
        json.put("type", type);
        json.put("date", date);
        json.put("price", price);
        return json;
    }
}
