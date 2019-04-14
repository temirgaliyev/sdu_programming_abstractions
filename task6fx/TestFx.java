import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TestFx extends Application {

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        TextArea textArea = new TextArea();
        textArea.setStyle("-fx-text-fill: #fff;");
        SimpleControl control = new SimpleControl(textArea);

        Button copy = new Button("Copy");
        copy.setOnAction(event -> control.copyWasPressed());

        Button cut = new Button("Cut");
        cut.setOnAction(event -> control.cutWasPressed());

        Button paste = new Button("Paste");
        paste.setOnAction(event -> control.pasteWasPressed());

        Button undo = new Button("Undo");
        undo.setOnAction(event -> control.undoWasPressed());


        HBox buttons = new HBox(copy, cut, paste, undo);
        buttons.setSpacing(5);
        VBox mainBox = new VBox(textArea, buttons);

        Scene scene = new Scene(mainBox);
        scene.getStylesheets().add("style.css");
        primaryStage.setScene(scene);
        primaryStage.setTitle("");
        primaryStage.show();
    }

}
