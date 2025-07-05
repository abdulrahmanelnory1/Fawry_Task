import java.time.LocalDate;
import java.util.Date;

public class ShippableAndExpirableProduct extends Product implements Expirable, Shippable {


    LocalDate expirationDate;
    double weight;


    ShippableAndExpirableProduct(String name, double price, int quantity,  LocalDate expirationDate,  double weight) {
        super(name, price, quantity);
        this.expirationDate = expirationDate;
        this.weight = weight;
    }

    @Override
    public String getName(){
        return name;
    }
    @Override
    public double getWeight(){
        return weight;
    }

    public boolean isExpired(){
        return expirationDate.isBefore(LocalDate.now());
    }
}
