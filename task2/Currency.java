import java.util.ArrayList;

public class Currency implements Subject {

    private ArrayList<Observer> observers = new ArrayList<>();
    private double prevCurrency = 364.46;
    private double currency = prevCurrency;
    private double difference = 0;
    private Card currencyCard;
    private Stat stat;

    public Currency(Card currencyCard, Stat stat) {
        this.currencyCard = currencyCard;
        this.stat = stat;
    }

    public double getCurrency() {
        return this.currency;
    }

    public void setCurrency(double currency) {
        this.currency = currency;
        changed();
    }

    public double getDifference() {
        return this.difference;
    }

    public void registerObserver(Observer o) {
        observers.add(o);
        o.setCurrency(this.currencyCard, stat);
        notifyObservers();
    }

    public void removeObserver(Observer o) {
        int i = observers.indexOf(o);
        if (i >= 0) {
            observers.remove(i);
        }
    }

    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }

    public void changed() {
        difference = currency - prevCurrency;
        if (Math.abs(difference) >= 2) {
            this.prevCurrency = currency;
            notifyObservers();
            difference = 0;
        }
    }
}
