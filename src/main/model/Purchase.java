package model;

public class Purchase {

    private String name;
    private String type;
    private String date;
    private int price;


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
}
