import Card.Card;
import com.sun.istack.internal.NotNull;
import javafx.scene.image.Image;

import java.io.Serializable;
import java.util.ArrayList;

public class User implements Serializable {
    private String login;
    private String pass;
    private Image profileImage;
    private ArrayList<Card> cards;

    User(@NotNull String login, @NotNull String pass) {
        this.login = login;
        this.pass = pass;
    }

    private boolean changePass(@NotNull String oldPass, @NotNull String newPass, @NotNull String verifPass) {
        if (pass.equals(oldPass) && newPass.equals(verifPass)) {
            pass = verifPass;
            return true;
        }
        return false;
    }

    private void changeProfileImage(Image profileImage) {
        this.profileImage = profileImage;
    }

    public String getLogin() {
        return login;
    }

    public String getPass() {
        return pass;
    }

    public Image getProfileImage() {
        return profileImage;
    }

    public ArrayList<Card> getCards() {
        return cards;
    }
}
