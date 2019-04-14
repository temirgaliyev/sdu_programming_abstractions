import javafx.application.Platform;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

public abstract class Item {
    private String name;
    private Pane pane = null;

    public String getName() {
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setPane(Pane pane){
        this.pane = pane;
    }

    public  void display(){
        System.out.println(getName() + " was created");
        if (pane != null){
            Platform.runLater(() -> pane.getChildren().add(new Text(getName())));
        }
    }
}
