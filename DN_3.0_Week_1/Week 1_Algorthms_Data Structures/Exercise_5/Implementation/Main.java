public class Main {
    public static void main(String[] args) {
        TaskList taskList = new TaskList();

        // Adding tasks
        taskList.addTask(new Task("001", "Design Database", "In Progress"));
        taskList.addTask(new Task("002", "Develop API", "Pending"));
        taskList.addTask(new Task("003", "Test Application", "Completed"));

        // Traversing and displaying tasks
        System.out.println("All Tasks:");
        taskList.traverseTasks();

        // Searching for a task
        System.out.println("\nSearching for task with ID 002:");
        Task task = taskList.searchTask("002");
        if (task != null) {
            System.out.println("Task found: " + task);
        } else {
            System.out.println("Task not found.");
        }

        // Deleting a task
        System.out.println("\nDeleting task with ID 002:");
        boolean isDeleted = taskList.deleteTask("002");
        if (isDeleted) {
            System.out.println("Task deleted successfully.");
        } else {
            System.out.println("Task not found.");
        }

        // Traversing and displaying tasks after deletion
        System.out.println("\nAll Tasks after deletion:");
        taskList.traverseTasks();
    }
}