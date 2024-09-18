package bankaccount;



public class AcmeBankAccounts {

    private int balance = 0;
    private final String holder;
    private final int accountNumber;
    static int idAccounts = 1; //First number account  to use
    static int bankBalance = 0; // Total bank balance
    public AcmeBankAccounts (String holder, int initialBalance) {
        // Create a new bank account for a client holder with an initial balance >= 0
        // it will assign to the bank account an idAccount
        // To be coded by the student
        this.holder = holder;
        this.balance += initialBalance;
        AcmeBankAccounts.bankBalance += initialBalance;
        this.accountNumber = AcmeBankAccounts.idAccounts++;
    }

    static void printBankData() {
        // Print the total Balance of the bank and the current accounts.
        // To be coded by the student
        System.out.println("-BANK DATA-");
        System.out.println("\tBankBalance: " + AcmeBankAccounts.bankBalance);
        System.out.println("\tAccounts: " + (AcmeBankAccounts.idAccounts-1));
    }

    private void withdrawal (int amount) {
        // For the current account, withdrawal the indicated amount
        // Decrement also the Bank balance
        // To be coded by the student
        this.balance -= amount;
        AcmeBankAccounts.bankBalance -= amount;
    }

    public void deposit(int amount) {
        // To be coded by the student
        this.balance += amount;
        AcmeBankAccounts.bankBalance += amount;
    }

    public void transfer (AcmeBankAccounts destinationAccount, int amount) {
        //Transfert the amount to the destination Account
        // To be coded by the student
        withdrawal(amount);
        destinationAccount.deposit(amount);
    }

    public void printAccountData() {
        // print the account number, holder and  account balance
        // To be coded by the student
        System.out.println("-ACCOUNT DATA-");
        System.out.println("\taccountNumber: " + accountNumber);
        System.out.println("\tholder: " + holder);
        System.out.println("\tbalance: " + balance);
    }

    public static void main(String[] args) {
        AcmeBankAccounts cJuan = new AcmeBankAccounts ("Juan", 2000);
        AcmeBankAccounts cPepe = new AcmeBankAccounts ("Pepe", 3000);
        cJuan.printAccountData();
        cPepe.printAccountData();
        cJuan.transfer(cPepe, 1000);
        cJuan.printAccountData();
        cPepe.printAccountData();
        AcmeBankAccounts.printBankData();
    }
} 