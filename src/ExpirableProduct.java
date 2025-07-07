import java.time.LocalDate;
import java.util.Date;

public class ExpirableProduct extends Product implements Expirable {

    private LocalDate expirationDate;

    public  ExpirableProduct(String name, double price, int quantity, LocalDate expirationDate) {
        super(name, price, quantity);
        this.expirationDate = expirationDate;
    }
    // Check if the product is Expired or available to use.
    @Override
    public boolean isExpired(){
        return expirationDate.isBefore(LocalDate.now());
    }
}
