package utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LogUtils {
    private static final Logger logger = Logger.getLogger(LogUtils.class.getName());

    //Info Level Logs
    public static void info(String message) {
        logger.info(getFormattedMessage(message));
    }

    // Log Warning Level
    public static void warn(String message) {
        logger.warning(getFormattedMessage(message));
    }

    // Log Severe Level
    public static void severe(String message) {
        logger.severe(getFormattedMessage(message));
    }

    // Log Fine Level
    public static void fine(String message) {
        logger.fine(getFormattedMessage(message));
    }

    // Log Exception Level
    public static void error(String message, Throwable throwable) {
        logger.log(Level.SEVERE, getFormattedMessage(message), throwable);
    }

    // Helper to format log messages with timestamp
    private static String getFormattedMessage(String message) {
        String timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        return timestamp + " - " + message;
    }
}
