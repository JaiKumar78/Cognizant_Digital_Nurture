import java.util.Arrays;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) {
        // Create an array of products
        Product[] products = {
            new Product("001", "Laptop", "Electronics"),
            new Product("002", "Smartphone", "Electronics"),
            new Product("003", "Tablet", "Electronics"),
            new Product("004", "Headphones", "Accessories"),
            new Product("005", "Smartwatch", "Accessories")
        };

        // Display all products
        System.out.println("All Products:");
        for (Product product : products) {
            System.out.println(product);
        }
        System.out.println();

        // Perform a linear search
        String searchTerm = "Smartphone";
        Product foundProduct = linearSearch(products, searchTerm);
        System.out.println("Linear Search Result for '" + searchTerm + "':");
        displayProduct(foundProduct);

        // Perform a binary search
        searchTerm = "Smartwatch";
        foundProduct = binarySearch(products, searchTerm);
        System.out.println("Binary Search Result for '" + searchTerm + "':");
        displayProduct(foundProduct);
    }

    // Utility method to display product details
    public static void displayProduct(Product product) {
        if (product != null) {
            System.out.println(product);
        } else {
            System.out.println("Product not found.");
        }
    }

    // Linear search method
    public static Product linearSearch(Product[] products, String searchTerm) {
        for (Product product : products) {
            if (product.getProductName().equalsIgnoreCase(searchTerm) ||
                product.getCategory().equalsIgnoreCase(searchTerm)) {
                return product;
            }
        }
        return null;
    }

    // Binary search method
    public static Product binarySearch(Product[] products, String searchTerm) {
        Arrays.sort(products, Comparator.comparing(Product::getProductName));
        int left = 0;
        int right = products.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int comparison = products[mid].getProductName().compareToIgnoreCase(searchTerm);

            if (comparison == 0) {
                return products[mid];
            } else if (comparison < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }
}
