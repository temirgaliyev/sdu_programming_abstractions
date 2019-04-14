import java.io.FileWriter;
import java.io.PrintWriter;

class LoggerSingleton {
    private static LoggerSingleton singleton = new LoggerSingleton();
    private PrintWriter writer;

    private LoggerSingleton() {
        try {
            String logFile = "src//test.txt";
            FileWriter fw = new FileWriter(logFile);
            writer = new PrintWriter(fw, true);
        } catch (Exception ignored){}
    }

    static LoggerSingleton getLoggerSingleton(){
        return singleton;
    }

    void logError(String error, String priority) {
        writer.println("Error: " + error + ". Priority: " + priority + "!");
    }

    void logConnection(String account, String time) {
        writer.println("Connection: " + account + " has connected at: " + time + ".");
    }

    void logChange(String obj, String time) {
        writer.println("Change: "+ obj + " has been changed at " + time + "!");
    }
}
