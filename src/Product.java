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

//Date expirationDate;// for products expire.
//double weight; // for products require shipping.
//
//    /** For products expire. */
//    public  Product(String name, double price, int quantity, Date expirationDate) {
//        this(name, price, quantity);
//        this.expirationDate = expirationDate;
//    }
//
//    /** For products expire and require shipping. */
//    public Product(String name, double price, int quantity, Date expirationDate, double weight) {
//        this(name, price, quantity, expirationDate);
//        this.weight = weight;
//    }
