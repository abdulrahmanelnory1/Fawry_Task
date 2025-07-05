import java.util.HashMap;

public class Cart {


    /** - Represents the product name as a key and the amount as a value.
     *  - Duplicated products is not allowed.
     */
    HashMap<Product,Integer> products =  new HashMap<>();

    public void add(Product product, Integer quantity) {

        // if the product is out of the stock.
        if(product.getQuantity() < quantity)
            throw new IllegalArgumentException("There is not enough quantities for " + product.getName());

        products.put(product, quantity );
    }

    public HashMap<Product,Integer> getProducts(){
        return products;
    }

}
