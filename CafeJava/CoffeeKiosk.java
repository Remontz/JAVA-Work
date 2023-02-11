import java.util.ArrayList;

public class CoffeeKiosk {
    private ArrayList<Item> menu;
    private ArrayList<Order> orders;

    public CoffeeKiosk() {
        menu = new ArrayList<Item>();
        orders = new ArrayList<Order>();
    }

    public void addMenuItem(String name, double price) {
        Item item = new Item(name, price);
        menu.add(item);
        item.setIndex(menu.indexOf(item));
    }

    public void displayMenu() {
        for (int i = 0; i < menu.size(); i++) {
            Item item = menu.get(i);
            System.out.println(item.getIndex() + " " + item.getName() + " -- $" + item.getPrice());
        }
    }

    public void newOrder() {
        // Shows the user a message prompt and then sets their input to a variable, name
        System.out.println("Please enter customer name for new order:");
        String name = System.console().readLine();

        // Your code:
        // Create a new order with the given input string
        Order order = new Order(name);
        // Show the user the menu, so they can choose items to add.
        displayMenu();

        // Prompts the user to enter an item number
        System.out.println("Please enter a menu item index or q to quit:");
        String itemNumber = System.console().readLine();

        // Write a while loop to collect all user's order items
        while (!itemNumber.equals("q")) {

            // Get the item object from the menu, and add the item to the order
            Item item = menu.get(Integer.parseInt(itemNumber));
            order.addItem(item);
            // Ask them to enter a new item index or q again, and take their input
            System.out.println("Please enter another menu item index or q to quit: ");
            itemNumber = System.console().readLine();
        }
        // After you have collected their order, print the order details as the example
        // below. You may use the order's display method.
        orders.add(order);
        order.display();
    }

    // Create a method that lets an admin add menu items manually, using what you
    // now know about getting user input.
    public void addMenuItemByInput() {
        String admin = "";
        while (!admin.equals("q")) {
            System.out.println("Hello Admin. Welcome to Add Menu Item");
            System.out.println("Please enter the name of the item you wish to add to the menu: ");
            String itemName = System.console().readLine();
            while (!itemName.equals("e")) {
                System.out.println("Thank you. And the price?");
                String itemPrice = System.console().readLine();

                addMenuItem(itemName, Double.parseDouble(itemPrice));

                System.out.println("Press e to exit; otherwise enter another menu item name: ");
                itemName = System.console().readLine();
            }
            System.out.println("Press q to logout of admin account.");
            admin = System.console().readLine();
        }
        displayMenu();
    }
}
