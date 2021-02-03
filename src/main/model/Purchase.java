package model;

public class Purchase {

    private String name;
    private String type;
    private String date;
    private double price;


    public Purchase(String date, String type, String name, double price) {
        this.name = name;
        this.type = type;
        this.date = date;
        this.price = price;
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

    public double getPrice() {
        return this.price;
    }
}
