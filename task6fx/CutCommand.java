import javafx.scene.control.TextArea;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;

public class CutCommand implements Command {
    private TextArea textArea;

    public CutCommand(TextArea textArea) {
        this.textArea = textArea;
    }


    @Override
    public void execute() {
        String text = textArea.getText();
        textArea.setText("");
        final Clipboard clipboard = Clipboard.getSystemClipboard();
        final ClipboardContent content = new ClipboardContent();
        content.putString(text);
        clipboard.setContent(content);
    }
}
