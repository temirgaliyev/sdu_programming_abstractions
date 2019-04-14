import javafx.scene.control.TextArea;

import java.util.ArrayList;

public class UndoCommand implements Command {
    private TextArea textArea;
    private ArrayList<String> story = new ArrayList<>();
    private String last;

    public UndoCommand(TextArea textArea) {
        this.textArea = textArea;
        textArea.textProperty().addListener((observable, oldValue, newValue) -> {
            if(!newValue.equals(last))
                story.add(oldValue);
        });
    }

    @Override
    public void execute() {
        last = "";
        if (story.size() > 0)
            last = story.remove(story.size()-1);
        textArea.setText(last);
    }

}
