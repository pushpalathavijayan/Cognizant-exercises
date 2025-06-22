import java.util.*;

class Product {
    int productId;
    String productName;
    String category;

    public Product(int productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }
}

public class EcommerceSearch {

    // Linear Search
    public static Product linearSearch(Product[] products, String name) {
        for (Product p : products) {
            if (p.productName.equalsIgnoreCase(name)) {
                return p;
            }
        }
        return null;
    }

    // Binary Search (on sorted array by name)
    public static Product binarySearch(Product[] products, String name) {
        int low = 0, high = products.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int cmp = products[mid].productName.compareToIgnoreCase(name);
            if (cmp == 0)
                return products[mid];
            else if (cmp < 0)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return null;
    }

    public static void main(String[] args) {
        Product[] products = {
            new Product(1, "Laptop", "Electronics"),
            new Product(2, "Shoes", "Fashion"),
            new Product(3, "Book", "Stationery"),
        };

        // Sort for binary search
        Arrays.sort(products, Comparator.comparing(p -> p.productName));

        String searchTerm = "Shoes";

        Product resultLinear = linearSearch(products, searchTerm);
        Product resultBinary = binarySearch(products, searchTerm);

        System.out.println("Linear: " + (resultLinear != null ? resultLinear.productName : "Not Found"));
        System.out.println("Binary: " + (resultBinary != null ? resultBinary.productName : "Not Found"));
    }
}
