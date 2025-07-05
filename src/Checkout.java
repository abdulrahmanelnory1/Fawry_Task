import java.util.HashMap;
import java.util.Map;

public class Checkout {


    public static void checkout(Customer customer, Cart cart) {

    HashMap<Product, Integer > products = cart.getProducts();

    // Cart is empty.
        if(products.isEmpty()){
            throw new IllegalStateException("ERROR: The cart is empty");
        }

    // Customers`s balance is insufficient or one product is expired:-

        double  totalPrice = 0;

        // Get subtotal (sum of all items’ prices)
        for (Map.Entry<Product, Integer> entry : products.entrySet()) {


            Product product = entry.getKey();
            Integer quantity = entry.getValue();

            // If product is expired.
            if(product instanceof Expirable && ((Expirable) product).isExpired())
                throw new IllegalStateException("ERROR: The product is expired.");


            totalPrice += product.getPrice() * quantity;
        }

        // Balance is insufficient,
        if(customer.getBalance() < totalPrice){
            throw new IllegalStateException("ERROR: The balance is insufficient");
        }

        System.out.println("** Checkout receipt ** ");

        for (Map.Entry<Product, Integer> entry : products.entrySet()) {


            Product product = entry.getKey();
            Integer quantity = entry.getValue();

            double productPrice = product.getPrice() * quantity;

            String productName = product.getName();

            // handle format
            while(productName.length() < 13)
                productName += " ";

            System.out.println(quantity + "x "  + productName + "        " + productPrice);
        }
        double shippingPrice = 9 * totalPrice / 100; // 9 percent of the total price

        System.out.print("----------------------------" + "\n" + "Subtotal       " + "         " +  totalPrice + "\n" + "Shipping       " + "         " + shippingPrice + "\n" + "Amount         " + "         " + Math.round((totalPrice + shippingPrice )* 10.0) / 10.0);
    }
}
