import javafx.scene.layout.Pane;

public class CommandLine extends Item {
    public CommandLine(String os) {
        setName(os+" CommandLine");
    }
    public CommandLine(String os, Pane pane){
        setName(os+ " CommandLine");
        setPane(pane);
    }

}

