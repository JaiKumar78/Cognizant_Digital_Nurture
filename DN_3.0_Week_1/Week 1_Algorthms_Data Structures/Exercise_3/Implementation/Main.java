public class Main {

    public static void main(String[] args) {
        // Create an array of orders
        Order[] orders = {
            new Order("001", "Alice", 250.50),
            new Order("002", "Bob", 150.75),
            new Order("003", "Charlie", 300.00),
            new Order("004", "David", 99.99),
            new Order("005", "Eve", 450.00)
        };

        // Display all orders before sorting
        System.out.println("Orders before sorting:");
        displayOrders(orders);

        // Sort orders using Bubble Sort
        SortOrders.bubbleSort(orders);
        System.out.println("Orders after Bubble Sort:");
        displayOrders(orders);

        // Shuffle the array for demonstration purposes
        shuffleArray(orders);

        // Sort orders using Quick Sort
        SortOrders.quickSort(orders, 0, orders.length - 1);
        System.out.println("Orders after Quick Sort:");
        displayOrders(orders);
    }

    // Utility method to display order details
    public static void displayOrders(Order[] orders) {
        for (Order order : orders) {
            System.out.println(order);
        }
        System.out.println();
    }

    // Utility method to shuffle the array
    public static void shuffleArray(Order[] orders) {
        for (int i = orders.length - 1; i > 0; i--) {
            int index = (int) (Math.random() * (i + 1));
            Order temp = orders[index];
            orders[index] = orders[i];
            orders[i] = temp;
        }
    }
}
