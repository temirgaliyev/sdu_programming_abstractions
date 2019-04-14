package Card;

import java.util.HashMap;

public class Paypal extends Card {

    private String paypalId;
    private String pass;

    public Paypal(String paypalId, String pass){
        this.paypalId = paypalId;
        this.pass = pass;
    }

    @Override
    public HashMap<String, String> verif() {
        HashMap<String, String> userPaypalCard = new HashMap<>();
        userPaypalCard.put("paypalId", paypalId);
        userPaypalCard.put("pass", pass);
        return userPaypalCard;
    }

    @Override
    public boolean checkCard() {
        // TODO: 21.09.2018 Send data to server and check it
        return super.checkCard();
    }
}
