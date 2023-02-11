import java.util.ArrayList;

public class TestOrders {
    public static void main(String[] args) {

        // Menu items
        Item item1 = new Item();
        item1.name = "mocha";
        item1.price = 4.00;
        Item item2 = new Item();
        item2.name = "latte";
        item2.price = 3.50;
        Item item3 = new Item();
        item3.name = "drip coffee";
        item3.price = 1.50;
        Item item4 = new Item();
        item4.name = "capuccino";
        item4.price = 3.00;

        // Order variables -- order1, order 2 etc.
        Order order1 = new Order();
        order1.name = "Cindhuri";
        Order order2 = new Order();
        order2.name = "Jimmy";
        Order order3 = new Order();
        order3.name = "Noah";
        Order order4 = new Order();
        order4.name = "Sam";

        // Application Simulations
        order2.addItem(item1);
        order2.getTotal();
        // Use this example code to test various orders' updates
        System.out.printf("Order 1 Name: %s\n", order1.name);
        System.out.printf("Order 2 Total: %s\n", order2.total);
        // System.out.printf("Name: %s\n", order1.ready);

        // order3 ordered a cappucino. Add the cappuccino to their order list and to
        // their tab.
        order3.addItem(item4);
        order3.getTotal();
        System.out.println(order3.name + " Placed Order Number 3. The total is: " + order3.total);

        // order4 added a latte. Update accordingly.
        System.out.println(order4.name + " Just ordered a latte...");
        order4.addItem(item2);

        // Cindhuri's order is now ready. Update her status.
        System.out.println(order1.name + "'s order is READY!");
        order1.ready = true;

        // Sam ordered more drinks - 2 lattes. Update their order as well.
        System.out.println(order4.name + " Just orderd 2 Latte's!");
        order4.addItem(item2);
        order4.addItem(item2);

        // Jimmy's order is now ready. Update his status.
        System.out.println(order2.name + "'s order is READY!");
        order1.ready = true;
    }

}
