package Customer;

public class PaymentMethod {
    private double accountBalance;
    private String type;

    public PaymentMethod(String type, double openingBalance){
        this.accountBalance = openingBalance;
        this.type = type;
    }

    public String getType() {
        return this.type;
    }

    public double getBalance() {
        return this.accountBalance;
    }

    public void debit(double amount) {
        if (this.accountBalance < amount) {
            return;
        }
        this.accountBalance -= amount;
    }

    public void credit(double amount) {
        this.accountBalance += amount;
    }
}
