import javafx.geometry.Pos;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Card extends VBox {

    private Text price;

    Card(String text) {
        setPrefWidth(300);
        setPrefHeight(200);
        setMaxHeight(150);
        setAlignment(Pos.CENTER);
        setStyle("-fx-background-color: rgba(240, 240, 240, 0.2);");
        Text label = new Text(text);
        label.setStyle("-fx-font: 24 arial;");
        label.setFill(new Color(0.66, 0.66, 0.66, 1));
        label.setTextAlignment(TextAlignment.LEFT);

        price = new Text();
        price.setStyle("-fx-font-weight: bold; -fx-font-size: 52;");
        price.setFill(new Color(0.97, 0.97, 1, 1));
        price.setTextAlignment(TextAlignment.CENTER);

        this.getChildren().addAll(label, price);
    }

    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    public void setPrice(String price) {
        this.price.setText(price);
    }

    public void setPrice(double price) {
        setPrice(String.valueOf(round(price, 2)));
    }

}
