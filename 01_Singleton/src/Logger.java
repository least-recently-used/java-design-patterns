import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {
    private static Logger instance;
    private LogLevel currentLogLevel = LogLevel.INFO; // Default log level
    private BufferedWriter fileWriter;

    private Logger() {
        try {
            String logFilePath = Logger.class.getClassLoader().getResource("log/app.log").getPath();
            System.out.println("*******"+logFilePath);
            // Initialize file writer for logging to a file
            fileWriter = new BufferedWriter(new FileWriter(logFilePath, true)); // Append mode
        } catch (IOException e) {
            System.err.println("Failed to initialize file logging: " + e.getMessage());
        }
    }

    // Synchronized method to get the singleton instance
    public static synchronized Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    // Set the current log level
    public void setLogLevel(LogLevel level) {
        this.currentLogLevel = level;
    }

    // Log a message
    public void log(LogLevel level, String message) {
        if (level.ordinal() >= currentLogLevel.ordinal()) { // Check if the log level qualifies
            String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            String logMessage = "[" + timestamp + "] [" + level + "] " + message;
            System.out.println(logMessage); // Print to console
            writeToFile(logMessage); // Write to file
        }
    }

    // Write log messages to a file
    private void writeToFile(String message) {
        if (fileWriter != null) {
            try {
                fileWriter.write(message);
                fileWriter.newLine();
                fileWriter.flush();
            } catch (IOException e) {
                System.err.println("Failed to write to log file: " + e.getMessage());
            }
        }
    }

    // Close the file writer (optional for cleanup)
    public void close() {
        if (fileWriter != null) {
            try {
                fileWriter.close();
            } catch (IOException e) {
                System.err.println("Failed to close file writer: " + e.getMessage());
            }
        }
    }
}
