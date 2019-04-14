public class DisplayDifference implements Observer, Display {
    private Currency currency;
    private Card currencyCard;
    private Stat stat;

    public DisplayDifference(Currency currency) {
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
        System.out.format("Difference:%10.2f\n", currency.getDifference());
    }
}
