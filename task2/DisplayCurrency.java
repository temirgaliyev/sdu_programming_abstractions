public class DisplayCurrency implements Observer, Display {

    private Currency currency;
    private Card currencyCard;
    private Stat stat;

    public DisplayCurrency(Currency currency) {
        this.currency = currency;
        this.currency.registerObserver(this);
    }

    @Override
    public void update() {
        display();
    }

    @Override
    public void setCurrency(Card currencyCard, Stat stat) {
        this.currencyCard = currencyCard;
        this.stat = stat;
    }

    @Override
    public void display() {
        this.currencyCard.setPrice(currency.getCurrency());
        this.stat.add(currency.getCurrency());
        System.out.format("Currency Rates:%10.2f\n", currency.getCurrency());
    }
}
