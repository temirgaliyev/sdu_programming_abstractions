import javafx.scene.layout.Pane;

public class MacFactory extends OsFactory{
    @Override
    public Item create(String str) {
        Item item = null;
        if(str.toLowerCase().equals("button")){
            item = new Button_("Mac");
        } else if(str.toLowerCase().equals("cmd") || str.toLowerCase().equals("commandline")){
            item = new CommandLine("Mac");
        }

        return item;
    }

    @Override
    public Item create(String str, Pane pane) {
        Item item = null;
        if(str.toLowerCase().equals("button")){
            item = new Button_("Mac", pane);
        } else if(str.toLowerCase().equals("cmd") || str.toLowerCase().equals("commandline")){
            item = new CommandLine("Mac", pane);
        }

        return item;
    }

}

