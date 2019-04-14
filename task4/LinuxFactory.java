import javafx.scene.layout.Pane;

public class LinuxFactory extends OsFactory{

    @Override
    public Item create(String str) {
        Item item = null;
        if(str.toLowerCase().equals("button")){
            item = new Button_("Linux");
        } else if(str.toLowerCase().equals("cmd") || str.toLowerCase().equals("commandline")){
            item = new CommandLine("Linux");
        }

        return item;
    }

    @Override
    public Item create(String str, Pane pane) {
        Item item = null;
        if(str.toLowerCase().equals("button")){
            item = new Button_("Linux", pane);
        } else if(str.toLowerCase().equals("cmd") || str.toLowerCase().equals("commandline")){
            item = new CommandLine("Linux", pane);
        }

        return item;
    }

}

