import java.util.ArrayList;
import java.text.DecimalFormat;

public class Order {
    DecimalFormat format = new DecimalFormat("#.##");
    private String name;
    // private double total;
    private boolean ready;
    private ArrayList<Item> items;

    // --- Constructor ---
    public Order() {
        this.name = "Guest";
        items = new ArrayList<Item>();
    }

    // --- Overloaded Constructor ---
    public Order(String name) {
        this.name = name;
        items = new ArrayList<Item>();
    }

    // --- Getters & Setters ---
    // --- get Name ---
    public String getName() {
        return name;
    }

    // --- set Name ---
    public void setName(String customerName) {
        name = customerName;
    }

    public void setName(String firstName, String lastName) {
        name = firstName + " " + lastName;
    }

    // --- get ready ---
    public boolean getReady() {
        return ready;
    }

    // --- set Ready ---
    public void setReady(boolean readyStatus) {
        ready = readyStatus;
    }

    // --- get items ---
    public ArrayList<Item> getItems() {
        return items;
    }

    // --- set items ---
    public void setItems(Item item) {
        items.add(item);
    }

    // --- Methods ---
    // --- addItem ---
    public void addItem(Item item) {
        items.add(item);
    }

    // --- getStatusMessage
    // Create a method called getStatusMessage that returns a String message. If the
    // order is ready, return "Your order is ready.", if not, return "Thank you for
    // waiting. Your order will be ready soon."
    public String getStatusMessage() {
        String message = name + ", your order is ready.";
        while (!ready) {
            message = name + ", thank you for waiting. Your order will be ready soon.";
            return message;
        }
        return message;
    }

    // --- getTotal ---
    public double getOrderTotal() {
        double total = 0.0;
        for (int i = 0; i < items.size(); i++) {
            Item item = items.get(i);
            total = total + item.getPrice();
        }
        return total;
    }

    // ---display ---
    // Similar to the displayMenu function from the Cafe Business Logic assignment,
    // create a method called display that prints out the order information like so:
    public void display() {
        System.out.println("Customer Name: " + name);
        for (int i = 0; i < items.size(); i++) {
            Item item = items.get(i);
            System.out.println(item.getName() + " - " + format.format(item.getPrice()));
        }
        System.out.println("Total: " + format.format(getOrderTotal()));
    }
}
