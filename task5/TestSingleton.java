
public class TestSingleton {
    public static void main(String args[]){

        for (int i = 0; i < 1000; i++) {
            new Thread(() -> {

                LoggerSingleton logger1 = LoggerSingleton.getLoggerSingleton();
                LoggerSingleton logger2 = LoggerSingleton.getLoggerSingleton();
                LoggerSingleton logger3 = LoggerSingleton.getLoggerSingleton();

                logger1.logError("11111", "HIGH");
                logger1.logConnection("100.10.0.82", "18:12");
                logger1.logChange("Folder bin", "00:42");
                logger2.logError("11251", "LOW");
                logger2.logConnection("122.10.0.7", "11:36");
                logger3.logConnection("28.100.0.19", "06:37");
                logger3.logChange("File exam.txt", "07:44");

            }).start();
        }

    }
}