import javafx.scene.layout.Pane;

public class WindowsFactory extends OsFactory{

    @Override
    public Item create(String str) {
        Item item = null;
        if(str.toLowerCase().equals("button")){
            item = new Button_("Windows");
        } else if(str.toLowerCase().equals("cmd") || str.toLowerCase().equals("commandline")){
            item = new CommandLine("Windows");
        }

        return item;
    }

    @Override
    public Item create(String str, Pane pane) {
        Item item = null;
        if(str.toLowerCase().equals("button")){
            item = new Button_("Windows", pane);
        } else if(str.toLowerCase().equals("cmd") || str.toLowerCase().equals("commandline")){
            item = new CommandLine("Windows", pane);
        }

        return item;
    }


}

