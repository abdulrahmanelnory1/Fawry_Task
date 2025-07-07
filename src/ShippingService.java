import java.util.HashMap;
import java.util.Map;

public class ShippingService {

    public static void shippingService(Cart cart) {

        // store Shippable products.
        HashMap<Shippable, Integer> items = new HashMap<>();

        HashMap<Product, Integer> products = cart.getProducts();

        // Find Shippable products.
        for (Map.Entry<Product, Integer> entry : products.entrySet()) {

            Product product = entry.getKey();
            Integer amount = entry.getValue();

            if (product instanceof Shippable) {
                items.put((Shippable) product, amount);
            }
        }

        double totalWeight = 0;

        // if there is no shippable products, so there is no shippable service, return and do nothing.
        if(items.isEmpty())
            return;

        /* Printing each product name, and its amount and its total weight. */

        System.out.println("** Shipment notice ** ");

        for (Map.Entry<Shippable, Integer> entry : items.entrySet()) {

            Shippable item = entry.getKey();
            Integer amount = entry.getValue();

            String name = item.getName();
            double productTotalWeight = Math.round(item.getWeight() * amount * 10.0) / 10.0;

            totalWeight += productTotalWeight; // track total weight.

            String strProductTotalWeight;

            if (productTotalWeight < 1000)
                strProductTotalWeight = String.valueOf((int)productTotalWeight) + "g";
            else
                strProductTotalWeight = String.valueOf(productTotalWeight / 1000) + "kg";

            // handle format
            while (name.length() < 13)
                name += " ";

            System.out.println(amount + "x " + name + "        " + strProductTotalWeight);
        }

        /* printing total weight. */

        totalWeight = Math.round(totalWeight * 10.0) / 10.0;

        String strTotalWeight;

        if (totalWeight < 1000)
            strTotalWeight = String.valueOf((int)totalWeight) + "g";
        else
            strTotalWeight = String.valueOf(totalWeight / 1000) + "kg";

        System.out.println("Total package weight    " + strTotalWeight + "\n");
    }
}
