import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Xylophone extends Application {
    @Override
    public void start(Stage primaryStage) {
        float x = 30, y = 30;
        float x_offset = 10, y_offset = 10;
        float h = 150, w = 50;
        float h_offset = 20;
        float rail_h = 15, rail_pos = -5;


        SoundComposition soundComposition = new SoundComposition();

        Sound note_do = new Sound("res/do.wav");
        Sound note_re = new Sound("res/re.wav");
        Sound note_mi = new Sound("res/mi.wav");
        Sound note_fa = new Sound("res/fa.wav");
        Sound note_sol = new Sound("res/sol.wav");
        Sound note_la = new Sound("res/la.wav");
        Sound note_si = new Sound("res/si.wav");

        Group root = new Group();

        Button play = new Button("Play");
        play.setOnAction(value ->  {
            soundComposition.play();
        });

        Button reset = new Button("Reset");
        reset.setOnAction(value ->  {
            soundComposition.clear();
        });

        Rectangle xyl_note_do = new Rectangle(x+w+x_offset, y, w, h+6*h_offset);
        xyl_note_do.setFill(getGradient(Color.DARKVIOLET));
        xyl_note_do.setOnMouseClicked(event -> {
            note_do.play();
            soundComposition.add(note_do);
        });

        Rectangle xyl_note_re = new Rectangle(x+2*(w+x_offset), y+y_offset, w, h+5*h_offset);
        xyl_note_re.setFill(getGradient(Color.BLUEVIOLET));
        xyl_note_re.setOnMouseClicked(event -> {
            note_re.play();
            soundComposition.add(note_re);
        });

        Rectangle xyl_note_mi = new Rectangle(x+3*(w+x_offset), y+2*y_offset, w, h+4*h_offset);
        xyl_note_mi.setFill(getGradient(Color.DARKBLUE));
        xyl_note_mi.setOnMouseClicked(event -> {
            note_mi.play();
            soundComposition.add(note_mi);
        });

        Rectangle xyl_note_fa = new Rectangle(x+4*(w+x_offset), y+3*y_offset, w, h+3*h_offset);
        xyl_note_fa.setFill(getGradient(Color.DARKGREEN));
        xyl_note_fa.setOnMouseClicked(event -> {
            note_fa.play();
            soundComposition.add(note_fa);
        });

        Rectangle xyl_note_sol = new Rectangle(x+5*(w+x_offset), y+4*y_offset, w, h+2*h_offset);
        xyl_note_sol.setFill(getGradient(Color.GREEN));
        xyl_note_sol.setOnMouseClicked(event -> {
            note_sol.play();
            soundComposition.add(note_sol);
        });

        Rectangle xyl_note_la = new Rectangle(x+6*(w+x_offset), y+5*y_offset, w, h+h_offset);
        xyl_note_la.setFill(getGradient(Color.GREENYELLOW));
        xyl_note_la.setOnMouseClicked(event -> {
            note_la.play();
            soundComposition.add(note_la);
        });

        Rectangle xyl_note_si = new Rectangle(x+7*(w+x_offset), y+6*y_offset, w, h);
        xyl_note_si.setFill(getGradient(Color.YELLOW));
        xyl_note_si.setOnMouseClicked(event -> {
            note_si.play();
            soundComposition.add(note_si);
        });

        Rectangle rail1 = new Rectangle(x+w, y+9*y_offset+rail_pos, 7.3*(w+x_offset), rail_h);
        rail1.setFill(getGradient(Color.BROWN));

        Rectangle rail2 = new Rectangle(x+w, y+h+6*h_offset-rail_h-9*y_offset-rail_pos, 7.3*(w+x_offset), rail_h);
        rail2.setFill(getGradient(Color.BROWN));

        VBox buttons = new VBox(play,reset);
        root.getChildren().addAll(buttons, rail1,rail2, xyl_note_do, xyl_note_re, xyl_note_mi, xyl_note_fa, xyl_note_sol, xyl_note_la, xyl_note_si);
        Scene scene = new Scene(root, 600, 400);
        primaryStage.setTitle("");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    private LinearGradient getGradient(Color color) {
        Stop[] stops = new Stop[] {new Stop(0, color), new Stop(1, Color.BLACK)};
        return new LinearGradient(0, 0, 1, 1, true, CycleMethod.NO_CYCLE, stops);

    }

    public static void main(String[] args) {
        launch(args);
    }

}