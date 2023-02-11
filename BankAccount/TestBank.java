public class TestBank {
    public static void main(String[] args) {
        BankAccount account1 = new BankAccount();
        BankAccount account2 = new BankAccount(100, 100);
        BankAccount account3 = new BankAccount(50, 400);

        System.out.println("Account 2's checking: " + account2.getChecking());
        System.out.println("Account 2's saving: " + account2.getSavings());

        account1.deposit("checking", 1000);
        account1.deposit("savings", 3000);

        account3.checkingWithdraw(800);
        account3.checkingWithdraw(20);

        account1.displayTotals();
        account2.displayTotals();
        account3.displayTotals();

    }
}