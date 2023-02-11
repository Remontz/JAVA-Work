import java.text.DecimalFormat;

public class testingCafe {
    public static void main(String[] args) {
        DecimalFormat df = new DecimalFormat("#.##");
        Order order1 = new Order();
        Order order2 = new Order();

        Order order3 = new Order("Joe");
        Order order4 = new Order("Renae");
        Order order5 = new Order("Darkwing Duck");

        Item item1 = new Item("drip coffee", 1.50);
        Item item2 = new Item("capuccino", 3.50);
        Item item3 = new Item("asari honey mead", 8.65);
        Item item4 = new Item("chai tea", 4.20);

        order1.addItem(item4);
        order1.addItem(item2);
        order2.addItem(item4);
        order2.addItem(item1);
        order3.addItem(item3);
        order3.addItem(item3);
        order4.addItem(item2);
        order4.addItem(item4);
        order5.addItem(item1);
        order5.addItem(item1);

        order1.display();
        order2.display();
        order3.display();
        order4.display();
        order5.display();

        order2.setReady(true);
        System.out.println(order2.getStatusMessage());
        System.out.println(order1.getStatusMessage());
        System.out.println(order2.getName() + "Your total is: " + df.format(order2.getOrderTotal()));
        order3.setReady(true);
        System.out.println(order3.getStatusMessage());
        System.out.println(order5.getStatusMessage());
        System.out.println(order3.getName() + "Your total is: " + df.format(order3.getOrderTotal()));
        order1.setReady(true);
        System.out.println(order1.getStatusMessage());
        System.out.println(order1.getName() + "Your total is: " + df.format(order1.getOrderTotal()));
        order4.setReady(true);
        System.out.println(order4.getStatusMessage());
        System.out.println(order4.getName() + "Your total is: " + df.format(order4.getOrderTotal()));
        order5.setReady(true);
        System.out.println(order5.getStatusMessage());
        System.out.println(order3.getStatusMessage());
        System.out.println(order5.getName() + "Your total is: " + df.format(order5.getOrderTotal()));

        order3.display();
        order1.display();
        order4.display();
        order2.display();
        order5.display();

        CoffeeKiosk kafe = new CoffeeKiosk();

        kafe.addMenuItem("green tea", 0.75);
        kafe.addMenuItem("black tea", 0.40);
        kafe.addMenuItem("chamomile tea", 0.23);
        kafe.addMenuItem("raspberry-orange tea", 1.89);

        System.out.println("Kafe Menu");
        kafe.displayMenu();
        kafe.newOrder();

        System.out.println("---- Opening Admin Zone ----");
        kafe.addMenuItemByInput();

    }
}
