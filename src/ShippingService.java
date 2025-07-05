import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ShippingService {


    private static long countOccurrences(List<Shippable> items, Shippable target) {
        return items.stream().filter(item -> item.equals(target)).count();
    }

    public static void shippingService(Cart cart) {

        // store Shippable products.
        List<Shippable> items = new ArrayList<>();

        HashMap<Product, Integer> products = cart.getProducts();

        // Find Shippable products.
        for (Map.Entry<Product, Integer> entry : products.entrySet()) {

            Product product = entry.getKey();

            if(product instanceof Shippable) {
                items.add((Shippable) product);
            }
        }

        System.out.println("** Shipment notice ** ");

        double totalWeight = 0;

        if (!items.isEmpty()) {

            for (Shippable item : items) {

                long amount = countOccurrences(items, item);
                String name = item.getName();
                double weight = item.getWeight() *  amount;
                weight = Math.round(item.getWeight() *  amount * 10.0) / 10.0;
                totalWeight += weight; // track total weight.

                // handle format
                String strWeight;
                if (weight < 1000)
                    strWeight = String.valueOf(weight) + "g";
                else
                    strWeight = String.valueOf(weight / 1000) + "kg";


                // handle format
                while(name.length() < 13)
                    name += " ";

                System.out.println(amount + "x " + name + "        " + strWeight);
            }

            totalWeight  = Math.round(totalWeight * 10.0) / 10.0;

            String strTotalWeight;

            if (totalWeight < 1000)
                strTotalWeight = String.valueOf(totalWeight) + "g";
            else
                strTotalWeight = String.valueOf(totalWeight / 1000) + "kg";

            System.out.println("Total package weight " + strTotalWeight + "\n");
        }
    }
}
