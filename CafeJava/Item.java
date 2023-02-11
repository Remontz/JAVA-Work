public class Item {
    private String name;
    private double price;
    private int index;

    // --- Constructor ---
    public Item(String itemName, double itemPrice) {
        name = itemName;
        price = itemPrice;
    }

    // --- Name Getter & Setter ---
    // getter
    public String getName() {
        return name;
    }

    // setter
    public void setName(String itemName) {
        name = itemName;
    }

    // --- Price Getter & Setter ---
    // getter
    public double getPrice() {
        return price;
    }

    // setter
    public void setPrice(double amount) {
        price = amount;
    }

    // --- Index Gettery & Setter ---
    // getter
    public int getIndex() {
        return index;
    }

    // setter
    public void setIndex(int itemIndex) {
        index = itemIndex;
    }

}
