import java.util.ArrayList;
import java.util.List;

// Subject Interface
interface Stock {
    void registerObserver(Observer observer);
    void deregisterObserver(Observer observer);
    void notifyObservers();
}

// Concrete Subject
class StockMarket implements Stock {
    private List<Observer> observers;
    private double stockPrice;

    public StockMarket() {
        observers = new ArrayList<>();
    }

    public void setStockPrice(double stockPrice) {
        this.stockPrice = stockPrice;
        notifyObservers();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void deregisterObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(stockPrice);
        }
    }
}

// Observer Interface
interface Observer {
    void update(double stockPrice);
}

// Concrete Observers
class MobileApp implements Observer {
    @Override
    public void update(double stockPrice) {
        System.out.println("Mobile App: Stock price updated to $" + stockPrice);
    }
}

class WebApp implements Observer {
    @Override
    public void update(double stockPrice) {
        System.out.println("Web App: Stock price updated to $" + stockPrice);
    }
}

// Main class to test the Observer Pattern
public class ObserverPattern {
    public static void main(String[] args) {
        // Create a stock market and observers
        StockMarket stockMarket = new StockMarket();
        Observer mobileApp = new MobileApp();
        Observer webApp = new WebApp();

        // Register observers
        stockMarket.registerObserver(mobileApp);
        stockMarket.registerObserver(webApp);

        // Change stock price and notify observers
        System.out.println("Updating stock price to $120.50");
        stockMarket.setStockPrice(120.50);

        // Deregister one observer and update stock price again
        stockMarket.deregisterObserver(mobileApp);
        System.out.println("\nUpdating stock price to $125.75");
        stockMarket.setStockPrice(125.75);
    }
}
