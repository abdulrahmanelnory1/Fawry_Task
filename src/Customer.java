import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;

public class Customer {

    private String name;
    private double balance;

    public Customer(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }
}
