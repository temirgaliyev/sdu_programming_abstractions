import javafx.scene.control.TextArea;
import javafx.scene.input.Clipboard;

public class PasteCommand implements Command {
    private TextArea textArea;

    public PasteCommand(TextArea textArea) {
        this.textArea = textArea;
    }

    @Override
    public void execute() {
        final Clipboard clipboard = Clipboard.getSystemClipboard();
        String text = clipboard.getString();
        textArea.setText(textArea.getText() + text);
    }

}
