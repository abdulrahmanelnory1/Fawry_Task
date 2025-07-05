import java.math.BigDecimal;
import java.util.Date;

public class Product {

    String name;
    double price;
    Integer quantity;

    /** Initialize products which are not expire and don`t require shipping. */
    public Product(String name, double price, Integer quantity) {

        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    /** Get the price of this product. */
    public double getPrice() {
        return this.price;
    }

    /** Get the Quantity of this product. */
    public Integer getQuantity() {
        return this.quantity;
    }
    public String getName() {
        return this.name;
    }


}
