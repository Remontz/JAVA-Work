import java.util.ArrayList;
import java.util.Arrays;

public class TestCafe {
    public static void main(String[] args) {

        /*
         * You will need add 1 line to this file to create an instance
         * of the CafeUtil class.
         * Hint: it will need to correspond with the variable name used below..
         */
        CafeUtil appTest = new CafeUtil();
        /* ============ App Test Cases ============= */

        System.out.println("\n----- Streak Goal Test -----");
        System.out.printf("Purchases needed by week 10: %s \n\n", appTest.getStreakGoal(10));

        System.out.println("----- Order Total Test-----");
        double[] lineItems = { 3.5, 1.5, 4.0, 4.5 };
        System.out.printf("Order total: %s \n\n", appTest.getOrderTotal(lineItems));

        System.out.println("----- Display Menu Test-----");

        ArrayList<String> menu = new ArrayList<String>();
        menu.add("drip coffee");
        menu.add("cappuccino");
        menu.add("latte");
        menu.add("mocha");
        appTest.displayMenu(menu);

        System.out.println("\n----- Add Customer Test-----");
        ArrayList<String> customers = new ArrayList<String>();
        // --- Test 4 times ---
        for (int i = 0; i < 4; i++) {
            appTest.addCustomer(customers);
            System.out.println("\n");
        }

        System.out.println("\n----- NINJA BONUSES -----");
        System.out.println("\n-----Print Price Chart Test -----");
        appTest.printPriceChart("Columbian Coffee Grounds", 15.00, 3);
        appTest.printPriceChart("Ghanain Roasted Coffee Grounds", 2.00, 4);

        System.out.println("\n----- Display Menu -----");
        ArrayList<String> menu2 = new ArrayList<String>();
        menu2.add("chai tea");
        menu2.add("green tea");
        menu2.add("black tea");
        ArrayList<Double> prices2 = new ArrayList<Double>();
        prices2.add(2.50);
        prices2.add(3.75);
        prices2.add(1.00);
        appTest.displayMenu(menu2, prices2);

        appTest.addCustomers(customers);
    }
}