import javafx.application.Platform;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

class LoggerSingletonFx {
    private static volatile LoggerSingletonFx singleton;
    private VBox vBox;

    private LoggerSingletonFx(VBox vBox) {
        this.vBox = vBox;
    }

    static LoggerSingletonFx getLoggerSingletonFx(VBox vBox){
        if (singleton == null){
            synchronized (LoggerSingleton.class){
                if (singleton == null) {
                    singleton = new LoggerSingletonFx(vBox);
                }
            }
        }
        return singleton;
    }

    void logError(String error, String priority) {
        append("Error: " + error + ". Priority: " + priority + "!", Color.RED);
    }

    void logConnection(String account, String time) {
        append("Connection: " + account + " has connected at: " + time + ".", Color.GREEN);
    }

    void logChange(String obj, String time) {
        append("Change: "+ obj + " has been changed at " + time + "!", Color.BLUE);
    }

    private void append(String t, Color c){
        Platform.runLater(() -> {
            Label label = new Label(t);
            label.setTextFill(c);
            vBox.getChildren().add(label);
        });
    }
}
