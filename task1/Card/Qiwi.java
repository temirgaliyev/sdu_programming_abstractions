package Card;

import java.util.HashMap;

public class Qiwi extends Card {

    private String qiwiPhoneNumber;
    private String pass;

    public Qiwi(String qiwiPhoneNumber, String pass){
        this.qiwiPhoneNumber = qiwiPhoneNumber;
        this.pass = pass;
    }

    @Override
    public HashMap<String, String> verif() {
        HashMap<String, String> userQiwiCard = new HashMap<>();
        userQiwiCard.put("qiwiPhoneNumber", qiwiPhoneNumber);
        userQiwiCard.put("pass", pass);
        return userQiwiCard;
    }

    @Override
    public boolean checkCard() {
        // TODO: 21.09.2018 Send data to server and check it
        return super.checkCard();
    }

}
