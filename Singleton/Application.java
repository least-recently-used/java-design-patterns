package Singleton;
public class Application {
    public static void main(String[] args) {
        Logger logger = Logger.getInstance();

        // Set the log level to DEBUG (will log INFO, DEBUG, WARN, ERROR, FATAL)
        logger.setLogLevel(LogLevel.DEBUG);

        // Log messages of various levels
        logger.log(LogLevel.INFO, "Application has started.");
        logger.log(LogLevel.DEBUG, "Debugging application initialization.");
        logger.log(LogLevel.WARN, "Low memory warning.");
        logger.log(LogLevel.ERROR, "An error occurred while connecting to the database.");
        logger.log(LogLevel.FATAL, "System crash: Unable to recover!");

        // Close logger resources
        logger.close();
    }
}
