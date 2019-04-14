import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.chart.NumberAxis;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Random;

public class Main extends Application {

    public static void main(String[] args) {
        Application.launch(args);
    }

    private static double randInt(double min, double max) {
        Random r = new Random();
        return min + (max - min) * r.nextDouble();
    }

    @Override
    public void start(Stage primaryStage) {
        Card currencyCard = new Card("USD");
        VBox vBox = new VBox(currencyCard);
        vBox.setPadding(new Insets(40,0,0,0));

        final NumberAxis xAxis = new NumberAxis();
        final NumberAxis yAxis = new NumberAxis();

        Stat<Number, Number> stat = new Stat<>(xAxis, yAxis);
        stat.setTitle("USD to KZT");
        stat.prefWidthProperty().bind(primaryStage.widthProperty().subtract(currencyCard.widthProperty()));

        Currency currencyUSD = new Currency(currencyCard, stat);

        new DisplayCurrency(currencyUSD);
        new DisplayDifference(currencyUSD);

        HBox mainBox = new HBox(vBox, stat);

        Scene scene = new Scene(mainBox);
        scene.getStylesheets().add("style.css");

        primaryStage.setScene(scene);
        primaryStage.setTitle("");
        primaryStage.setMaximized(true);
        primaryStage.show();

        new Thread(() -> {
            while (true) {
                try {
                    currencyUSD.setCurrency(currencyUSD.getCurrency() + randInt(-1, 1));
                    Thread.sleep(100);
                } catch (InterruptedException ex) {
                    Thread.currentThread().interrupt();
                }
            }
        }).start();
    }
}
