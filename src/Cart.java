import java.util.HashMap;

public class Cart {

    /** - Represents the product name as a key and the amount as a value.
     *  - Duplicated products is not allowed.
     */
    private HashMap<Product,Integer> products =  new HashMap<>();

    public void add(Product product, Integer amount) {

        // if the product is out of the stock.
        if(product.getQuantity() < amount)
            throw new IllegalArgumentException("There is not enough quantities for " + product.getName());

        if (product instanceof Expirable && ((Expirable) product).isExpired())
            throw new IllegalStateException("ERROR: The product is expired.");

        // Reducing the available quantity.
        product.updateQuantity(amount) ;
        products.put(product, amount);
    }

    public HashMap<Product,Integer> getProducts(){
        return products;
    }

}
