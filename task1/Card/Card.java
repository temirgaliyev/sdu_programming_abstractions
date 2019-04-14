package Card;

import java.util.HashMap;

public class Card {

    int cash;

    public void putMoney(int n) {
        cash += n;
    }

    public void getMoney(int n) {
        cash -= n;
    }

    public HashMap<String, String> verif() {
        return null;
    }

    public boolean checkCard() {
        return true;
    }
}
