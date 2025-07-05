import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;

public class Customer {

    String name;
    double balance;
    Cart cart = new Cart();

    public Customer(String name, double balance,Cart cart) {
        this.name = name;
        this.balance = balance;
        this.cart = cart;
    }

    public double getBalance() {
        return balance;
    }
}
