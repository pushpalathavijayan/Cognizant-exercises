// StrategyPatternExample.java

// Step 2: Define Strategy Interface
interface PaymentStrategy {
    void pay(double amount);
}

// Step 3: Concrete Strategies
class CreditCardPayment implements PaymentStrategy {
    private String cardNumber;

    public CreditCardPayment(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public void pay(double amount) {
        System.out.println("Paid ₹" + amount + " using Credit Card ending with " + cardNumber.substring(cardNumber.length() - 4));
    }
}

class PayPalPayment implements PaymentStrategy {
    private String email;

    public PayPalPayment(String email) {
        this.email = email;
    }

    public void pay(double amount) {
        System.out.println("Paid ₹" + amount + " using PayPal account: " + email);
    }
}

// Step 4: Context Class
class PaymentContext {
    private PaymentStrategy paymentStrategy;

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void pay(double amount) {
        if (paymentStrategy == null) {
            System.out.println("No payment method selected.");
        } else {
            paymentStrategy.pay(amount);
        }
    }
}

// Step 5: Test the Strategy Pattern
public class StrategyPatternExample {
    public static void main(String[] args) {
        PaymentContext context = new PaymentContext();

        // User chooses to pay via Credit Card
        context.setPaymentStrategy(new CreditCardPayment("1234567812345678"));
        context.pay(1500.00);

        // User switches to PayPal
        context.setPaymentStrategy(new PayPalPayment("user@example.com"));
        context.pay(2500.75);

        // No strategy selected
        context.setPaymentStrategy(null);
        context.pay(500.00);
    }
}
