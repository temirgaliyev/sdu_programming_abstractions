import javafx.scene.layout.Pane;

public abstract class OsFactory {
    public abstract Item create(String str);
    public abstract Item create(String str, Pane pane);
}
