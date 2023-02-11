import java.util.ArrayList;
import java.text.DecimalFormat;

public class CafeUtil {

    public int getStreakGoal(int numWeeks) {
        int sum = 0;
        for (int i = 1; i <= numWeeks; i++) {
            sum = sum + i;
        }
        return sum;
    }

    public double getOrderTotal(double[] prices) {
        double total = 0.0;
        for (int i = 0; i < prices.length; i++) {
            total = total + prices[i];
        }
        return total;
    }

    public void displayMenu(ArrayList<String> menuItems) {
        for (int i = 0; i < menuItems.size(); i++) {
            String item = menuItems.get(i);
            System.out.println(i + " " + item);
        }
    }

    public boolean displayMenu(ArrayList<String> menuItems, ArrayList<Double> prices) {
        if (menuItems.size() != prices.size()) {
            return false;
        }
        int size = menuItems.size();
        for (int i = 0; i < size; i++) {
            String item = menuItems.get(i);
            double cost = prices.get(i);
            DecimalFormat df = new DecimalFormat("#.##");
            df.setMaximumFractionDigits(2);
            df.setMinimumFractionDigits(2);
            System.out.println(i + " " + item + " -- $" + df.format(cost));
        }

        return true;
    }

    public void addCustomer(ArrayList<String> customers) {
        System.out.println("Please enter your name: ");
        String userName = System.console().readLine();
        System.out.println("Hello, " + userName);
        System.out.println("There are " + customers.size() + " people in front of you.");
        customers.add(userName);
        for (int i = 0; i < customers.size(); i++) {
            System.out.println(customers.get(i));
        }
    }

    public void addCustomers(ArrayList<String> customers) {
        String input = "";
        boolean adding = true;
        while (adding == true) {
            System.out.println("Enter customer's name: ");
            input = System.console().readLine();
            if (input.equals("q")) {
                adding = false;
            } else {
                customers.add(input);
                System.out.println("Customer added to database.  Press 'q' to exit customer input mode.");
            }
        }=
    }

    public void printPriceChart(String product, double price, int maxQuantity) {
        System.out.println(product);
        int i = 1;
        double deduct = .50;
        while (i <= maxQuantity) {
            double result = price * i;

            if (i > 1) {
                result = result - deduct;
                deduct = deduct + .5;
            }
            DecimalFormat df = new DecimalFormat("#.##");
            df.setMaximumFractionDigits(2);
            df.setMinimumFractionDigits(2);
            System.out.println(i + " - $" + df.format(result));
            i++;
        }
    }
}