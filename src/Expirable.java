import java.time.LocalDate;

public interface Expirable {
    String getName();
    //LocalDate getExpirationDate();
    boolean isExpired();
}
