import javafx.scene.layout.Pane;

public class Button_ extends Item {
    public Button_(String os){
        setName(os+ " Button");
    }

    public Button_(String os, Pane pane){
        setName(os+ " Button");
        setPane(pane);
    }
}
