import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);

        // Sample books
        library.addBook(new Book("001", "The Great Gatsby", "F. Scott Fitzgerald"));
        library.addBook(new Book("002", "1984", "George Orwell"));
        library.addBook(new Book("003", "To Kill a Mockingbird", "Harper Lee"));
        library.addBook(new Book("004", "Moby Dick", "Herman Melville"));
        library.addBook(new Book("005", "Pride and Prejudice", "Jane Austen"));

        while (true) {
            System.out.println("\nLibrary Management System:");
            System.out.println("1. Add Book");
            System.out.println("2. Search Book by Title (Linear Search)");
            System.out.println("3. Search Book by Title (Binary Search)");
            System.out.println("4. Display All Books");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Book ID: ");
                    String bookId = scanner.nextLine();
                    System.out.print("Enter Book Title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter Book Author: ");
                    String author = scanner.nextLine();
                    library.addBook(new Book(bookId, title, author));
                    System.out.println("Book added successfully!");
                    break;

                case 2:
                    System.out.print("Enter Book Title to Search (Linear Search): ");
                    String searchTitleLinear = scanner.nextLine();
                    Book foundBookLinear = library.linearSearchByTitle(searchTitleLinear);
                    if (foundBookLinear != null) {
                        System.out.println("Book found: " + foundBookLinear);
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;

                case 3:
                    System.out.print("Enter Book Title to Search (Binary Search): ");
                    String searchTitleBinary = scanner.nextLine();
                    Book foundBookBinary = library.binarySearchByTitle(searchTitleBinary);
                    if (foundBookBinary != null) {
                        System.out.println("Book found: " + foundBookBinary);
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;

                case 4:
                    System.out.println("All Books in the Library:");
                    library.displayAllBooks();
                    break;

                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
