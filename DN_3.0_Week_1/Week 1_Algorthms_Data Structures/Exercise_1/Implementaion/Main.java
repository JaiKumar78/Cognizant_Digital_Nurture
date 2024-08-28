public class Main {
    public static void main(String[] args) {
        // Create an inventory instance
        Inventory inventory = new Inventory();

        // Create some products
        Product product1 = new Product("001", "Laptop", 50, 999.99);
        Product product2 = new Product("002", "Smartphone", 200, 499.99);
        Product product3 = new Product("003", "Tablet", 100, 299.99);

        // Add products to the inventory
        inventory.addProduct(product1);
        inventory.addProduct(product2);
        inventory.addProduct(product3);

        // Display the products
        displayProduct(inventory.getProduct("001"));
        displayProduct(inventory.getProduct("002"));
        displayProduct(inventory.getProduct("003"));

        // Update a product
        product2.setPrice(450.00);
        inventory.updateProduct(product2);

        // Display the updated product
        System.out.println("Updated Product:");
        displayProduct(inventory.getProduct("002"));

        // Delete a product
        inventory.deleteProduct("003");

        // Try to display the deleted product
        System.out.println("After Deletion:");
        Product deletedProduct = inventory.getProduct("003");
        if (deletedProduct == null) {
            System.out.println("Product with ID 003 has been deleted.");
        }
    }

    // Utility method to display product details
    public static void displayProduct(Product product) {
        if (product != null) {
            System.out.println("Product ID: " + product.getProductId());
            System.out.println("Product Name: " + product.getProductName());
            System.out.println("Quantity: " + product.getQuantity());
            System.out.println("Price: $" + product.getPrice());
            System.out.println();
        } else {
            System.out.println("Product not found.");
        }
    }
}
