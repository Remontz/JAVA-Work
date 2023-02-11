import java.util.Random;

public class BankAccount {
    private double checkingBalance;
    private double savingsBalance;
    private String accountNo;
    public static int accountsCreated = 0;
    public static double accountsTotal;

    // --- Constructor ---
    public BankAccount() {
        checkingBalance = 0.00;
        savingsBalance = 0.00;
        accountsTotal = checkingBalance + savingsBalance;
        accountsCreated++;
        accountNo = generateAccountNumber();
    }

    public BankAccount(double checkBal, double savBal) {
        checkingBalance = checkBal;
        savingsBalance = savBal;
        accountsTotal = checkingBalance + savingsBalance;
        accountsCreated++;
        accountNo = generateAccountNumber();
    }

    // --- Getters & Setters ---
    // --- get Users Checking Account Balance ---
    public double getChecking() {
        return checkingBalance;
    }

    // --- get Users Saving Account Balance ---
    public double getSavings() {
        return savingsBalance;
    }

    // --- create a method that allows user to deposit to either the checking or
    // savings ---
    public String deposit(String accountType, double amount) {
        if (accountType.equals("savings")) {
            savingsBalance = savingsBalance + amount;
            accountsTotal = savingsBalance + checkingBalance;
            return "Deposited " + amount + " into your Savings Account. Which brings the Account Total to: "
                    + savingsBalance;
        } else if (accountType.equals("checking")) {
            checkingBalance = checkingBalance + amount;
            accountsTotal = savingsBalance + checkingBalance;
            return "Deposited " + amount + " into your Checking Account. Which brings the Account Total to: "
                    + checkingBalance;
        }
        return "Please specify savings or checking.";
    }

    public void checkingWithdraw(double amount) {
        if (checkingBalance > amount) {
            checkingBalance -= amount;
            System.out.println("Withdrew " + amount + " from your Checking Account. Which brings the Account Total to: "
                    + checkingBalance);
        } else {
            System.out.println("Insufficient Funds.");
        }
    }

    public void displayTotals() {
        accountsTotal = savingsBalance + checkingBalance;
        System.out.println("Your accounts Total Balance is: " + accountsTotal);
        System.out.println("Savings Total: " + savingsBalance);
        System.out.println("Checking Total: " + checkingBalance);
    }

    private char getRandomCharacter() {
        Random random = new Random();
        char character = ' ';
        char[] characters = { 'a', 'b', 'c', 'X', 'Y', 'Z', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0' };
        int index = random.nextInt(16);
        character = characters[index];

        return character;
    }

    private String generateAccountNumber() {
        accountNo = "";
        for (int i = 0; i < 10; i++) {
            accountNo = accountNo + getRandomCharacter();
        }
        return accountNo;
    }
}