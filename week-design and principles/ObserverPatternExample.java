// ObserverPatternExample.java

import java.util.*;

// Step 2: Define Subject Interface
interface Stock {
    void registerObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers();
}

// Step 4: Define Observer Interface
interface Observer {
    void update(String stockName, double stockPrice);
}

// Step 3: Concrete Subject
class StockMarket implements Stock {
    private List<Observer> observers = new ArrayList<>();
    private String stockName;
    private double stockPrice;

    public void setStockPrice(String stockName, double stockPrice) {
        this.stockName = stockName;
        this.stockPrice = stockPrice;
        notifyObservers(); // Notify all observers
    }

    public void registerObserver(Observer o) {
        observers.add(o);
    }

    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    public void notifyObservers() {
        for (Observer o : observers) {
            o.update(stockName, stockPrice);
        }
    }
}

// Step 5: Concrete Observers
class MobileApp implements Observer {
    public void update(String stockName, double stockPrice) {
        System.out.println("[Mobile App] " + stockName + " is now ₹" + stockPrice);
    }
}

class WebApp implements Observer {
    public void update(String stockName, double stockPrice) {
        System.out.println("[Web App] " + stockName + " is now ₹" + stockPrice);
    }
}

// Step 6: Test the Observer Pattern
public class ObserverPatternExample {
    public static void main(String[] args) {
        StockMarket stockMarket = new StockMarket();

        // Create observers
        Observer mobileApp = new MobileApp();
        Observer webApp = new WebApp();

        // Register observers
        stockMarket.registerObserver(mobileApp);
        stockMarket.registerObserver(webApp);

        // Stock price updates
        stockMarket.setStockPrice("TCS", 3500.00);
        System.out.println();

        stockMarket.setStockPrice("Infosys", 1590.75);
        System.out.println();

        // Remove mobile app and update
        stockMarket.removeObserver(mobileApp);
        stockMarket.setStockPrice("HCL", 1285.60);
    }
}
