import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Main {

    static Scanner sc = new Scanner(System.in);


    static LinkedList<BankAccount> accounts = new LinkedList<>();


    static Stack<TransactionRecord> history = new Stack<>();


    static Queue<String> billQueue = new LinkedList<>();


    static Queue<BankAccount> accountRequests = new LinkedList<>();


    static BankAccount[] fixedAccounts = new BankAccount[3];

    public static void main(String[] args) {
        preloadArrayAccounts();
        preloadLinkedListAccounts();
        mainMenu();
    }


    static void mainMenu() {
        while (true) {
            System.out.println("\n     MINI BANKING SYSTEM ");
            System.out.println("1 - Enter Bank");
            System.out.println("2 - Enter ATM");
            System.out.println("3 - Admin Area");
            System.out.println("4 - Show Fixed Array Accounts");
            System.out.println("0 - Exit");
            System.out.print("Choose: ");

            int choice = readInt();

            switch (choice) {
                case 1:
                    bankMenu();
                    break;
                case 2:
                    atmMenu();
                    break;
                case 3:
                    adminMenu();
                    break;
                case 4:
                    showFixedAccounts();
                    break;
                case 0:
                    System.out.println("Program finished.");
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }


    static void bankMenu() {
        while (true) {
            System.out.println("\n  BANK MENU ");
            System.out.println("1 - Add new account directly");
            System.out.println("2 - Display all accounts");
            System.out.println("3 - Search account by username");
            System.out.println("4 - Deposit money");
            System.out.println("5 - Withdraw money");
            System.out.println("6 - Add bill payment request");
            System.out.println("7 - Submit account opening request");
            System.out.println("8 - Show last transaction");
            System.out.println("9 - Undo last transaction");
            System.out.println("10 - Display transaction history");
            System.out.println("0 - Back");
            System.out.print("Choose: ");

            int choice = readInt();

            switch (choice) {
                case 1:
                    addAccountDirectly();
                    break;
                case 2:
                    displayAllAccounts();
                    break;
                case 3:
                    searchAccountByUsername();
                    break;
                case 4:
                    depositMoney();
                    break;
                case 5:
                    withdrawMoney();
                    break;
                case 6:
                    addBillPaymentRequest();
                    break;
                case 7:
                    submitAccountOpeningRequest();
                    break;
                case 8:
                    showLastTransaction();
                    break;
                case 9:
                    undoLastTransaction();
                    break;
                case 10:
                    displayTransactionHistory();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
    static void atmBalanceEnquiry() {
        System.out.print("Enter username: ");
        String username = sc.nextLine().trim();

        BankAccount account = findAccountByUsername(username);

        if (account == null) {
            System.out.println("Account not found.");
            return;
        }

        System.out.println("Balance: " + account.getBalance());
    }

    static void atmWithdraw() {
        System.out.print("Enter username: ");
        String username = sc.nextLine().trim();

        BankAccount account = findAccountByUsername(username);

        if (account == null) {
            System.out.println("Account not found.");
            return;
        }

        System.out.print("Enter amount: ");
        double amount = readDouble();

        if (amount <= 0) {
            System.out.println("Amount must be positive.");
            return;
        }

        if (account.withdraw(amount)) {
            history.push(new TransactionRecord("Withdraw", username, amount));
            System.out.println("Withdraw successful.");
        } else {
            System.out.println("Not enough balance.");
        }
    }

    static void atmMenu() {
        while (true) {
            System.out.println("\n ATM MENU ");
            System.out.println("1 - Balance enquiry");
            System.out.println("2 - Withdraw");
            System.out.println("0 - Back");
            System.out.print("Choose: ");

            int choice = readInt();

            switch (choice) {
                case 1:
                    atmBalanceEnquiry();
                    break;
                case 2:
                    atmWithdraw();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }


    static void adminMenu() {
        while (true) {
            System.out.println("\n ADMIN MENU ");
            System.out.println("1 - View pending account requests");
            System.out.println("2 - Process next account request");
            System.out.println("3 - View bill payment queue");
            System.out.println("4 - Process next bill payment");
            System.out.println("0 - Back");
            System.out.print("Choose: ");

            int choice = readInt();

            switch (choice) {
                case 1:
                    viewPendingRequests();
                    break;
                case 2:
                    processNextAccountRequest();
                    break;
                case 3:
                    viewBillQueue();
                    break;
                case 4:
                    processNextBillPayment();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }


    static void addAccountDirectly() {
        System.out.print("Enter account number: ");
        String accountNumber = sc.nextLine().trim();

        if (findAccountByNumber(accountNumber) != null) {
            System.out.println("Account number already exists.");
            return;
        }

        System.out.print("Enter username: ");
        String username = sc.nextLine().trim();

        if (findAccountByUsername(username) != null) {
            System.out.println("Username already exists.");
            return;
        }

        System.out.print("Enter initial balance: ");
        double balance = readDouble();

        if (balance < 0) {
            System.out.println("Balance cannot be negative.");
            return;
        }

        BankAccount account = new BankAccount(accountNumber, username, balance);
        accounts.add(account);
        System.out.println("Account added successfully.");
    }

    static void displayAllAccounts() {
        if (accounts.isEmpty()) {
            System.out.println("No accounts found.");
            return;
        }

        System.out.println("Accounts List:");
        int index = 1;
        for (BankAccount account : accounts) {
            System.out.println(index + ". " + account);
            index++;
        }
    }

    static void searchAccountByUsername() {
        System.out.print("Enter username: ");
        String username = sc.nextLine().trim();

        BankAccount account = findAccountByUsername(username);
        if (account == null) {
            System.out.println("Account not found.");
        } else {
            System.out.println("Found: " + account);
        }
    }


    static void depositMoney() {
        System.out.print("Enter username: ");
        String username = sc.nextLine().trim();

        BankAccount account = findAccountByUsername(username);
        if (account == null) {
            System.out.println("Account not found.");
            return;
        }

        System.out.print("Enter deposit amount: ");
        double amount = readDouble();

        if (amount <= 0) {
            System.out.println("Amount must be positive.");
            return;
        }

        account.deposit(amount);
        history.push(new TransactionRecord("Deposit", username, amount));

        System.out.println("Deposit successful.");
        System.out.println("New balance: " + String.format("%.2f", account.getBalance()));
    }

    static void withdrawMoney() {
        System.out.print("Enter username: ");
        String username = sc.nextLine().trim();

        BankAccount account = findAccountByUsername(username);
        if (account == null) {
            System.out.println("Account not found.");
            return;
        }

        System.out.print("Enter withdraw amount: ");
        double amount = readDouble();

        if (amount <= 0) {
            System.out.println("Amount must be positive.");
            return;
        }

        if (account.withdraw(amount)) {
            history.push(new TransactionRecord("Withdraw", username, amount));
            System.out.println("Withdraw successful.");
            System.out.println("New balance: " + String.format("%.2f", account.getBalance()));
        } else {
            System.out.println("Not enough balance.");
        }
    }


    static void showLastTransaction() {
        if (history.isEmpty()) {
            System.out.println("No transactions in history.");
            return;
        }

        System.out.println("Last transaction: " + history.peek());
    }

    static void undoLastTransaction() {
        if (history.isEmpty()) {
            System.out.println("No transactions to undo.");
            return;
        }

        TransactionRecord last = history.pop();
        BankAccount account = findAccountByUsername(last.getUsername());

        if (account == null) {
            System.out.println("Related account no longer exists.");
            return;
        }

        if (last.getType().equalsIgnoreCase("Deposit")) {
            boolean ok = account.withdraw(last.getAmount());
            if (ok) {
                System.out.println("Undo successful: removed last deposit.");
                System.out.println("New balance: " + String.format("%.2f", account.getBalance()));
            } else {
                System.out.println("Undo failed.");
            }
        } else if (last.getType().equalsIgnoreCase("Withdraw")) {
            account.deposit(last.getAmount());
            System.out.println("Undo successful: restored last withdraw.");
            System.out.println("New balance: " + String.format("%.2f", account.getBalance()));
        } else if (last.getType().equalsIgnoreCase("Bill Payment")) {
            System.out.println("Bill payment record removed from history.");
        } else {
            System.out.println("Transaction removed from history.");
        }
    }

    static void displayTransactionHistory() {
        if (history.isEmpty()) {
            System.out.println("No transactions in history.");
            return;
        }

        System.out.println("Transaction History:");
        for (int i = history.size() - 1; i >= 0; i--) {
            System.out.println((history.size() - i) + ". " + history.get(i));
        }
    }


    static void addBillPaymentRequest() {
        System.out.print("Enter bill name: ");
        String billName = sc.nextLine().trim();

        if (billName.isEmpty()) {
            System.out.println("Bill name cannot be empty.");
            return;
        }

        billQueue.add(billName);
        history.push(new TransactionRecord("Bill Payment", "System", 0));

        System.out.println("Added to bill queue: " + billName);
    }

    static void processNextBillPayment() {
        if (billQueue.isEmpty()) {
            System.out.println("Bill queue is empty.");
            return;
        }

        String bill = billQueue.poll();
        System.out.println("Processing: " + bill);
    }

    static void viewBillQueue() {
        if (billQueue.isEmpty()) {
            System.out.println("Bill queue is empty.");
            return;
        }

        System.out.println("Bill Queue:");
        int index = 1;
        for (String bill : billQueue) {
            System.out.println(index + ". " + bill);
            index++;
        }
    }


    static void submitAccountOpeningRequest() {
        System.out.print("Enter requested account number: ");
        String accountNumber = sc.nextLine().trim();

        if (findAccountByNumber(accountNumber) != null || requestExistsByNumber(accountNumber)) {
            System.out.println("This account number already exists or is already pending.");
            return;
        }

        System.out.print("Enter requested username: ");
        String username = sc.nextLine().trim();

        if (findAccountByUsername(username) != null || requestExistsByUsername(username)) {
            System.out.println("This username already exists or is already pending.");
            return;
        }

        System.out.print("Enter initial balance: ");
        double balance = readDouble();

        if (balance < 0) {
            System.out.println("Balance cannot be negative.");
            return;
        }

        BankAccount request = new BankAccount(accountNumber, username, balance);
        accountRequests.add(request);
        System.out.println("Account opening request submitted.");
    }

    static void viewPendingRequests() {
        if (accountRequests.isEmpty()) {
            System.out.println("No pending account requests.");
            return;
        }

        System.out.println("Pending Account Requests:");
        int index = 1;
        for (BankAccount request : accountRequests) {
            System.out.println(index + ". " + request);
            index++;
        }
    }

    static void processNextAccountRequest() {
        if (accountRequests.isEmpty()) {
            System.out.println("No pending account requests.");
            return;
        }

        BankAccount approved = accountRequests.poll();
        accounts.add(approved);
        System.out.println("Request approved and account added: " + approved.getUsername());
    }

    // ========================= TASK 6: ARRAY =========================
    static void preloadArrayAccounts() {
        fixedAccounts[0] = new BankAccount("A001", "Ali", 150000);
        fixedAccounts[1] = new BankAccount("A002", "Sara", 220000);
        fixedAccounts[2] = new BankAccount("A003", "John", 100000);
    }

    static void showFixedAccounts() {
        System.out.println("Fixed Array Accounts:");
        for (int i = 0; i < fixedAccounts.length; i++) {
            System.out.println((i + 1) + ". " + fixedAccounts[i]);
        }
    }

    // Optional: preload some LinkedList accounts for easy demo
    static void preloadLinkedListAccounts() {
        accounts.add(new BankAccount("B101", "Daniyar", 50000));
        accounts.add(new BankAccount("B102", "Aruzhan", 120000));
    }

    // ========================= HELPER METHODS =========================
    static BankAccount findAccountByUsername(String username) {
        for (BankAccount account : accounts) {
            if (account.getUsername().equalsIgnoreCase(username)) {
                return account;
            }
        }
        return null;
    }

    static BankAccount findAccountByNumber(String accountNumber) {
        for (BankAccount account : accounts) {
            if (account.getAccountNumber().equalsIgnoreCase(accountNumber)) {
                return account;
            }
        }
        return null;
    }

    static boolean requestExistsByUsername(String username) {
        for (BankAccount request : accountRequests) {
            if (request.getUsername().equalsIgnoreCase(username)) {
                return true;
            }
        }
        return false;
    }

    static boolean requestExistsByNumber(String accountNumber) {
        for (BankAccount request : accountRequests) {
            if (request.getAccountNumber().equalsIgnoreCase(accountNumber)) {
                return true;
            }
        }
        return false;
    }

    static int readInt() {
        while (!sc.hasNextInt()) {
            System.out.print("Enter a valid integer: ");
            sc.nextLine();
        }
        int value = sc.nextInt();
        sc.nextLine();
        return value;
    }

    static double readDouble() {
        while (!sc.hasNextDouble()) {
            System.out.print("Enter a valid number: ");
            sc.nextLine();
        }
        double value = sc.nextDouble();
        sc.nextLine();
        return value;
    }
}