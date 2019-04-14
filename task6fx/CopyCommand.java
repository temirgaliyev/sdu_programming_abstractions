import javafx.scene.control.TextArea;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;

public class CopyCommand implements Command {
    private TextArea textArea;

    public CopyCommand(TextArea textArea) {
        this.textArea = textArea;
    }

    @Override
    public void execute() {
        String text = textArea.getText();
        final Clipboard clipboard = Clipboard.getSystemClipboard();
        final ClipboardContent content = new ClipboardContent();
        content.putString(text);
        clipboard.setContent(content);
    }
}
