public class TransactionRecord {
    private String type;
    private String username;
    private double amount;

    public TransactionRecord(String type, String username, double amount) {
        this.type = type;
        this.username = username;
        this.amount = amount;
    }

    public String getType() {
        return type;
    }

    public String getUsername() {
        return username;
    }

    public double getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return type + " " + String.format("%.2f", amount) + " for " + username;
    }
}