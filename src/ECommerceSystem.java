import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ECommerceSystem {

    public static void main(String[] args) {

        Product product1 = new Product("mobile", 100, 2);
        Product product2 = new ShippableProduct("cheese", 150, 3, 200);
        Product product3 = new ShippableAndExpirableProduct("TV", 400, 2, LocalDate.now().plusYears(1), 1300);

        Cart cart1 =  new Cart();
        Cart cart2 =  new Cart();

        cart1.add(product1, 1);
        cart1.add(product2, 2);
        cart2.add(product3, 1);
        cart2.add(product2, 1);

        Customer customer1 = new Customer("Ahmed", 1000, cart1);
        Customer customer2 = new Customer("Tarek", 1000, cart2);

        ShippingService.shippingService(cart2);
        Checkout.checkout(customer2, cart2);




    }
}
