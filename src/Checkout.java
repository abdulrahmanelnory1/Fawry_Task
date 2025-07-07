import java.util.HashMap;
import java.util.Map;

public class Checkout {


    public static void checkout(Customer customer, Cart cart) {

        HashMap<Product, Integer> products = cart.getProducts();
        double shippableItemsWeight = 0;


        // Cart is empty.
        if (products.isEmpty()) {
            throw new IllegalStateException("ERROR: The cart is empty");
        }

        // Customers`s balance is insufficient or one product is expired:-

        double totalPrice = 0;

        // Get subtotal (sum of all items’ prices)
        for (Map.Entry<Product, Integer> entry : products.entrySet()) {

            Product product = entry.getKey();
            Integer amount = entry.getValue();

            // If product is Expirable => so check if it was expired or shippable => get its weight.
            if (product instanceof Shippable) {
                shippableItemsWeight += ((Shippable) product).getWeight() * amount;
            }

            totalPrice += product.getPrice() * amount;
        }

        System.out.println("** Checkout receipt ** ");

        for (Map.Entry<Product, Integer> entry : products.entrySet()) {


            Product product = entry.getKey();
            Integer quantity = entry.getValue();

            double productPrice = product.getPrice() * quantity;

            String productName = product.getName();

            // handle format
            while (productName.length() < 13)
                productName += " ";

            System.out.println(quantity + "x " + productName + "        " + productPrice);
        }
        double shippingPrice = 9 * shippableItemsWeight / 100; // 9 percent of the total price of the shippable price.

        if (customer.getBalance() < totalPrice) {
            System.out.print("-----------------------------" + "\n" + "Subtotal       " + "         " + totalPrice + "\n" + "Shipping       " + "         " + shippingPrice + "\n" + "Amount         " + "         " + Math.round((totalPrice + shippingPrice) * 10.0) / 10.0 + "\n");
            throw new IllegalStateException("ERROR: The customer balance is insufficient.");
        }
        System.out.print("-----------------------------" + "\n" + "Subtotal       " + "         " + totalPrice + "\n" + "Shipping       " + "         " + shippingPrice + "\n" + "Amount         " + "         " + Math.round((totalPrice + shippingPrice) * 10.0) / 10.0 + "\n" + "Current balance" + "         " + Math.round((customer.getBalance() - totalPrice + shippingPrice) * 10.0) / 10.0);
    }

}

