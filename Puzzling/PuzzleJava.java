import java.util.ArrayList;
import java.text.DecimalFormat;
import java.util.Random;

public class PuzzleJava {
    // methods here...

    // --- getTenRolls ----
    // Write a method that will generate and return an array with 10 random numbers
    // between 1 and 20 inclusive.

    public ArrayList<Integer> getTenRolls() {
        ArrayList<Integer> rolls = new ArrayList<Integer>();
        Random random = new Random();
        int number;
        int i = 0;

        while (i < 10) {
            number = random.nextInt(11);
            rolls.add(number);
            i++;
        }

        for (i = 0; i < rolls.size(); i++) {
            if (i == 0) {
                System.out.print("[" + rolls.get(i) + ",");
            } else if (i == 9) {
                System.out.println(rolls.get(i) + "]");
            } else {
                System.out.print(rolls.get(i) + ", ");
            }
        }
        return rolls;
    }

    // getRandomLetter
    // Write a method that will: Create an array within the method that contains all
    // 26 letters of the alphabet (this array must have 26 values).
    // Generate a random index between 0-25, and use it to pull a random letter out
    // of the array. Return the random letter.

    public char getRandomLetter() {
        Random random = new Random();
        char letter = ' ';
        char[] alphabet = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r',
                's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };

        int index = random.nextInt(26);

        letter = alphabet[index];

        return letter;
    }

    // generatePassword
    // Write a method that uses the previous method to create a random string of
    // eight characters, and return that string.

    public String generatePassword() {
        String password = "";

        for (int i = 0; i < 8; i++) {
            password = password + this.getRandomLetter();
        }
        return password;
    }

    // getNewPasswordSet
    // Write a method that takes an int length as an argument and creates an array
    // of random eight character words. The array should be the length passed in as
    // an int.

    public ArrayList<Character> getNewPasswordSet(int length) {
        ArrayList<Character> passwordSet = new ArrayList<Character>();
        for (int i = 0; i < length; i++) {
            passwordSet.add(this.getRandomLetter());
        }
        return passwordSet;
    }

    // SENSEI BONUS
    // shuffleArray
    // Write a method that takes an array and mixes up all the values in a
    // pseudo-random way.Hint: use random indexes within the array, and swap values
    // repeatedly.

    public ArrayList<Character> shuffleArray(ArrayList<Character> oldArray) {
        Random random = new Random();
        ArrayList<Character> newArray = new ArrayList<Character>();
        int j;
        int length = oldArray.size();

        for (int i = 0; i < length; i++) {
            j = random.nextInt(oldArray.size());
            newArray.add(oldArray.get(j));
            oldArray.remove(j);
        }
        return newArray;
    }
}