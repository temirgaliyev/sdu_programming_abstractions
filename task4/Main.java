import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        String osName = System.getProperty("os.name").toLowerCase();

        OsFactory factory = null;
        switch (osName) {
            case "windows 10":
                factory = new WindowsFactory();
                break;
            case "linux":
                factory = new LinuxFactory();
                break;
            case "mac os x":
                factory = new MacFactory();
                break;
        }

        VBox vBox = new VBox();
        OsFactory finalFactory = factory;

        Button createButton = new Button("Create button");
        createButton.setOnAction(event -> {
            Item item = finalFactory.create("button", vBox);
            item.display();
        });

        Button createCmd = new Button("Create CMD");
        createCmd .setOnAction(event -> {
            Item item = finalFactory.create("cmd", vBox);
            item.display();
        });

        vBox.getChildren().addAll(createButton, createCmd);
        Scene scene = new Scene(vBox);
        primaryStage.setScene(scene);
        primaryStage.setTitle("");
        primaryStage.setWidth(400);
        primaryStage.setHeight(400);
        primaryStage.show();

    }
}
