public class Main {
    public static void main(String[] args) {
        EmployeeManagementSystem ems = new EmployeeManagementSystem(10);

        // Adding employees
        ems.addEmployee(new Employee("001", "Alice", "Manager", 75000));
        ems.addEmployee(new Employee("002", "Bob", "Developer", 60000));
        ems.addEmployee(new Employee("003", "Charlie", "Analyst", 50000));

        // Traversing and displaying employees
        System.out.println("All Employees:");
        ems.traverseEmployees();

        // Searching for an employee
        System.out.println("\nSearching for employee with ID 002:");
        Employee employee = ems.searchEmployee("002");
        if (employee != null) {
            System.out.println("Employee found: " + employee);
        } else {
            System.out.println("Employee not found.");
        }

        // Deleting an employee
        System.out.println("\nDeleting employee with ID 002:");
        boolean isDeleted = ems.deleteEmployee("002");
        if (isDeleted) {
            System.out.println("Employee deleted successfully.");
        } else {
            System.out.println("Employee not found.");
        }

        // Traversing and displaying employees after deletion
        System.out.println("\nAll Employees after deletion:");
        ems.traverseEmployees();
    }
}
