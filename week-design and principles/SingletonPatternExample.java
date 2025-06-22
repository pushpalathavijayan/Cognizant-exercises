// SingletonPatternExample.java

public class SingletonPatternExample {

    // Singleton Class: Logger
    static class Logger {

        // Step 1: Private static instance
        private static Logger instance;

        // Step 2: Private constructor
        private Logger() {
            System.out.println("Logger Initialized");
        }

        // Step 3: Public method to get the instance
        public static Logger getInstance() {
            if (instance == null) {
                instance = new Logger(); 
            }
            return instance;
        }

        // Optional method to simulate logging
        public void log(String message) {
            System.out.println("LOG: " + message);
        }
    }

    // Main method to test the Singleton
    public static void main(String[] args) {
        Logger logger1 = Logger.getInstance();
        logger1.log("First log message");

        Logger logger2 = Logger.getInstance();
        logger2.log("Second log message");

        // Check if both are same instance
        if (logger1 == logger2) {
            System.out.println("Both logger1 and logger2 are the same instance.");
        } else {
            System.out.println("Different instances! Singleton failed.");
        }
    }
}
