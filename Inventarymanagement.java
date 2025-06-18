import java.util.*;

class Product {
    int productId;
    String productName;
    int quantity;
    double price;

    public Product(int productId, String productName, int quantity, double price) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    @Override
    public String toString() {
        return "ID: " + productId + ", Name: " + productName +
               ", Quantity: " + quantity + ", Price: ₹" + price;
    }
}

public class InventorySystem {
    private static HashMap<Integer, Product> inventory = new HashMap<>();
    private static Scanner sc = new Scanner(System.in);

    // Add product
    public static void addProduct() {
        System.out.print("Enter Product ID: ");
        int id = sc.nextInt();
        sc.nextLine(); // consume newline
        System.out.print("Enter Product Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Quantity: ");
        int qty = sc.nextInt();
        System.out.print("Enter Price: ");
        double price = sc.nextDouble();

        if (inventory.containsKey(id)) {
            System.out.println("❌ Product ID already exists.");
        } else {
            Product p = new Product(id, name, qty, price);
            inventory.put(id, p);
            System.out.println("✅ Product added.");
        }
    }

    // Update product
    public static void updateProduct() {
        System.out.print("Enter Product ID to update: ");
        int id = sc.nextInt();
        if (inventory.containsKey(id)) {
            System.out.print("Enter new quantity: ");
            int newQty = sc.nextInt();
            System.out.print("Enter new price: ");
            double newPrice = sc.nextDouble();
            Product p = inventory.get(id);
            p.quantity = newQty;
            p.price = newPrice;
            System.out.println("🔁 Product updated.");
        } else {
            System.out.println("❌ Product not found.");
        }
    }

    // Delete product
    public static void deleteProduct() {
        System.out.print("Enter Product ID to delete: ");
        int id = sc.nextInt();
        if (inventory.containsKey(id)) {
            inventory.remove(id);
            System.out.println("🗑️ Product deleted.");
        } else {
            System.out.println("❌ Product not found.");
        }
    }

    // Display inventory
    public static void displayInventory() {
        System.out.println("\n📦 Current Inventory:");
        if (inventory.isEmpty()) {
            System.out.println("No products in inventory.");
        } else {
            for (Product p : inventory.values()) {
                System.out.println(p);
            }
        }
    }

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n===== Inventory Menu =====");
            System.out.println("1. Add Product");
            System.out.println("2. Update Product");
            System.out.println("3. Delete Product");
            System.out.println("4. Display Inventory");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    addProduct();
                    break;
                case 2:
                    updateProduct();
                    break;
                case 3:
                    deleteProduct();
                    break;
                case 4:
                    displayInventory();
                    break;
                case 5:
                    System.out.println("Exiting program... 👋");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 5);
    }
}
