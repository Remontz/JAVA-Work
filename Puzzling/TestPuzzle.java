import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class TestPuzzle {
    public static void main(String[] args) {
        // call functions here.

        PuzzleJava appTest = new PuzzleJava();

        System.out.println("----- Get Ten Rolls -----");
        System.out.println("Dice are being Drummed and Drums are being rolled.....");
        appTest.getTenRolls();

        System.out.println("----- Get a Random Letter -----");
        System.out.println("The letter is: " + appTest.getRandomLetter());

        System.out.println("----- Generate Password -----");
        System.out.println("Password: " + appTest.generatePassword());

        System.out.println("----- Get New Password Set -----");
        System.out.println("Password Set: " + appTest.generatePassword());

        System.out.println("----- Shuffle Array -----");
        ArrayList<Character> toBeShuffled = new ArrayList<Character>();
        toBeShuffled.add('a');
        toBeShuffled.add('b');
        toBeShuffled.add('c');
        toBeShuffled.add('d');
        toBeShuffled.add('e');

        System.out.println(toBeShuffled + " will be shuffled....");
        System.out.println("*Shuffling Sounds*");
        ArrayList<Character> shuffled = new ArrayList<Character>();
        shuffled = appTest.shuffleArray(toBeShuffled);
        System.out.println("After Shuffling it is now: " + shuffled.toString());
    }
}