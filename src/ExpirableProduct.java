import java.time.LocalDate;
import java.util.Date;

public class ExpirableProduct extends Product implements Expirable {

    LocalDate expirationDate;

    public  ExpirableProduct(String name, double price, int quantity, LocalDate expirationDate) {
        super(name, price, quantity);
        this.expirationDate = expirationDate;
    }

    @Override
    public String getName(){
        return name;
    }

    @Override
    public boolean isExpired(){
        return expirationDate.isBefore(LocalDate.now());
    }
}
