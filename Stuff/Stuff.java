import java.util.ArrayList;

public class Stuff {
    public static void main(String[] args) {
        //
        //
        //

        boolean inStock = true;
        // if (inStock) {
        // System.out.println("Your item is in stock!");
        // } else {
        // System.out.println("Out of stock!");
        // }
        System.out.println(inStock ? "Your item is in stock!" : "Out of stock!"); // This does the same thing as the
                                                                                  // commented out block above.

        int correctNum = 3;
        int guess = 0;
        if (guess < correctNum) {
            System.out.println("Higher!");
        } else if (guess > correctNum) {
            System.out.println("Lower!");
        } else {
            System.out.println("Correct!");
        }
        // == is equal to
        // != not equal to
        // < less than
        // > greater than
        // <= less than or equal to
        // >= greater than or equal to
        // &&
        // ||

        // Phone Menu
        int choice = 3;
        switch (choice) {
            case 1:
                System.out.println("You have pressed 1.  Hear your balance");
                break;
            case 2:
                System.out.println("You have pressed 2. Make a payment");
                break;
            case 3:
                System.out.println("You have pressed 3. Report card lost or stolen");
                break;
            default:
                System.out.println("I'm sorry, thats not a valid option");
        }
        // Syntantic sugar: type less computer does the same thing
        //

        double numInStock = 10.5;
        int numToSell = (int) numInStock; // EXPLICIT

        // LOOPS
        int runLoop = 0;
        while (runLoop < 10) {
            System.out.println("Still running!");
            runLoop++;
        }
        ArrayList<Integer> myArr = new ArrayList<Integer>();
        for (int i = 0; i < 10; i++) {
            myArr.add(i);
        }
        // for (Integer j : myArr)
        for (int j = 0; j < myArr.size(); j++) {
            System.out.println(j);
        }

        // Array Lists
        ArrayList<String> strArr = new ArrayList<String>();
        String[] fruits = {"apple", "banana", "orange"};
        for (String fruit : fruits) {
            strArr.add(fruit);
        }
        for (String entry : strArr) {

            System.out.println(entry);
        }
        System.out.println(strArr.get(1));
    }
}