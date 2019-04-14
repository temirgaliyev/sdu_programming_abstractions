import java.util.ArrayList;


public class SoundComposition extends Music{
    private ArrayList<Sound> sounds = new ArrayList<>();

    void add(Sound sound){
        sounds.add(sound);
    }

    @Override
    public void setRate(double rate) {
        for (Sound sound : sounds) {
            sound.setRate(rate);
        }
    }

    @Override
    public void play() {
        for (Sound sound : sounds) {
            sound.play();
            try {
                Thread.sleep(600);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void setVolume(double volume) {
        for (Sound sound : sounds) {
            sound.setVolume(volume);
        }
    }

    @Override
    public void setCycleCount(int count) {
        for (Sound sound : sounds) {
            sound.setCycleCount(count);
        }
    }

    void clear() {
        sounds.clear();
    }

}
