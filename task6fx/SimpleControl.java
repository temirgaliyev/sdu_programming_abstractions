import javafx.scene.control.TextArea;

public class SimpleControl {
    private Command copy, cut, paste, undo;

    SimpleControl(TextArea textArea){
        this.copy = new CopyCommand(textArea);
        this.cut = new CutCommand(textArea);
        this.paste = new PasteCommand(textArea);
        this.undo = new UndoCommand(textArea);
    }

    public void copyWasPressed(){
        copy.execute();
    }

    public void cutWasPressed(){
        cut.execute();
    }

    public void pasteWasPressed(){
        paste.execute();
    }

    public void undoWasPressed(){
        undo.execute();
    }

}
