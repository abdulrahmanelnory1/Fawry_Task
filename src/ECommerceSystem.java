import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ECommerceSystem {

    public static void main(String[] args) {

        Product product1 = new Product("mobile", 100, 0);
        Product product2 = new ShippableProduct("cheese", 150, 3, 200);
        Product product3 = new ShippableAndExpirableProduct("TV", 400, 2, LocalDate.now().plusYears(-1), 1300);
        Product product4 = new ExpirableProduct("Radio", 400, 2, LocalDate.now().plusYears(1));

        Cart cart1 = new Cart();
        Cart cart2 =  new Cart();

        cart1.add(product1, 1);
        cart1.add(product2, 2);
        cart2.add(product1, 1);

        Customer customer1 = new Customer("Ahmed", 1000);
        Customer customer2 = new Customer("Tarek", 1000);

        ShippingService.shippingService(cart1);
        Checkout.checkout(customer1,cart1);
    }
}
