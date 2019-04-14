import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TestFx extends Application {
    private VBox vBox = new VBox();

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        vBox.setAlignment(Pos.CENTER);
        ScrollPane scrollPane = new ScrollPane(vBox);
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        HBox mainBox = new HBox(scrollPane);
        Scene scene = new Scene(mainBox);
        scene.getStylesheets().add("style.css");
        primaryStage.setScene(scene);
        primaryStage.setTitle("");
        primaryStage.setMaximized(true);
        primaryStage.show();
        vBox.prefWidthProperty().bind(primaryStage.widthProperty());

        test();
    }

    private void test() {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {

                LoggerSingletonFx logger1 = LoggerSingletonFx.getLoggerSingletonFx(vBox);
                LoggerSingletonFx logger2 = LoggerSingletonFx.getLoggerSingletonFx(vBox);
                LoggerSingletonFx logger3 = LoggerSingletonFx.getLoggerSingletonFx(vBox);

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
