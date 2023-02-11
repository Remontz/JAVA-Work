public class CafeJava {
    public static void main(String[] args) {
        // APP VARIABLES
        // Lines of text that will appear in the app.
        String generalGreeting = "Welcome to Cafe Java, ";
        String pendingMessage = ", your order will be ready shortly";
        String readyMessage = ", your order is ready. ";
        String displayTotalMessage = " Your total is $";

        // Menu variables (add yours below)
        double mochaPrice = 3.50;
        double coffee = 4.00;
        double latte = 4.50;
        double cappucino = 5.00;

        // Customer name variables (add yours below)
        String customer1 = "Cindhuri";
        String customer2 = "Sam";
        String customer3 = "Jimmy";
        String customer4 = "Noah";

        // Order completions (add yours below)
        boolean isReadyOrder1 = false;
        boolean isReadyOrder2 = false;
        boolean isReadyOrder3 = false;
        boolean isReadyOrder4 = true;

        double samsTotal;
        double jimmysTotal;

        // APP INTERACTION SIMULATION (Add your code for the challenges below)
        // Example:
        System.out.println(generalGreeting + customer1 + " What can we brew for you today?"); // Displays "Welcome to
                                                                                              // Cafe Java, Cindhuri"
        System.out.println(customer1 + " Ordered a coffee...");
        System.out.println(customer1 + pendingMessage);
        System.out.println(customer1 + readyMessage);
        System.out.println(displayTotalMessage + coffee);

        System.out.println(customer4 + " Ordered a cappucino...");
        System.out.println(isReadyOrder4 ? customer4 + readyMessage + displayTotalMessage + cappucino : pendingMessage);

        System.out.println(customer2 + " Ordered two Latte's...");
        samsTotal = latte + latte;
        System.out.println(customer2 + displayTotalMessage + samsTotal);
        System.out.println(isReadyOrder2 ? customer2 + readyMessage : pendingMessage);

        System.out.println(customer3 + "Was charged for a coffee, he ordered a Latte!");
        jimmysTotal = latte - coffee;
        System.out.println(customer3 + displayTotalMessage + jimmysTotal);
        // ** Your customer interaction print statements will go here ** //
    }
}

// Create 3 more drink price variables, for drip coffee, latte and cappucino
// following the same camel case naming convention
// Create 3 more customer variables for sam, Jimmy and Noah, followoing the same
// variable naming convention in the example.
// Create the order status flag (true/flase) for each customer, following the
// variable naming conventino in the example.
// For the next tasks, we will be simulating customer interactions, printing
// messages to the screen, based on scenarios.
// Cindhuri ordered a coffee. Print to the console the correct status message,
// based on her order status.
// Noah order a cappucino. Use an if statement to check the status of his order
// and print the correct status message. if it is ready, also print the message
// to display the total. Note: Outcomes may be different depending on what you
// assigned as the status.
// Sam just ordered 2 lattes, print the message to display their total. Next,
// use an if statement to print the appropriate order status message. Change the
// isReady flag value from true to false or vice versa in order to test your
// control logic (if-statement)

// Jimmy just realized he was charged for a coffee but had ordered a latte.
// Print the total message with the new calculated total (what he owes) to make
// up the dfference.

// Try changing the price values for each dring and isReady flages(booleans), to
// test if all of your logic works, even when prices and statuses are changed.