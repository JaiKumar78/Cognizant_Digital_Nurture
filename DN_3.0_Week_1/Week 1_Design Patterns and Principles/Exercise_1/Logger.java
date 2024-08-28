public class Logger {
    private static Logger instance;

    private Logger() {
    }
    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    // Sample logging method
    public void log(String message) {
        System.out.println("Log: " + message);
    }

    public static void main(String[] args) {
        // Get the instance of Logger
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        // Log some messages
        logger1.log("This is the first log message.");
        logger2.log("This is the second log message.");

        // Verify that logger1 and logger2 are the same instance
        if (logger1 == logger2) {
            System.out.println("Logger is a singleton!");
        } else {
            System.out.println("Logger is NOT a singleton!");
        }
    }
}
