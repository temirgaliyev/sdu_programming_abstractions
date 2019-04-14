import javafx.application.Platform;
import javafx.scene.chart.Axis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;

public class Stat<X, Y> extends LineChart<X, Y> {
    private XYChart.Series<X, Y> series;
    private int i = 1;

    public Stat(Axis<X> axis, Axis<Y> axis2) {
        super(axis, axis2);

        series = new XYChart.Series<>();
        series.setName("USD to KZT");

        getData().add(series);
    }

    public void add(double value) {
        Platform.runLater(() -> series.getData().add(new Data(i++, value)));
    }

}