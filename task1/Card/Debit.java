package Card;

import java.util.HashMap;

public class Debit extends Card {
    private String debitCardNo;
    private String cvv;
    private String exp_date;

    public Debit(String debitCardNo, String cvv, String exp_date) {
        this.debitCardNo = debitCardNo;
        this.cvv = cvv;
        this.exp_date = exp_date;
    }

    @Override
    public HashMap<String, String> verif() {
        HashMap<String, String> userQiwiCard = new HashMap<>();
        userQiwiCard.put("debitCardNo", debitCardNo);
        userQiwiCard.put("cvv", cvv);
        userQiwiCard.put("exp_date", exp_date);
        return userQiwiCard;
    }

    @Override
    public boolean checkCard() {
        // TODO: 21.09.2018 Send data to server and check it
        return super.checkCard();
    }

}
