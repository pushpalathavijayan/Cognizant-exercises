// AdapterPatternExample.java

// Step 2: Define the Target Interface
interface PaymentProcessor {
    void processPayment(double amount);
}

// Step 3: Adaptee Classes (Third-party gateways)

class PayPalGateway {
    public void sendPayment(double amountInDollars) {
        System.out.println("Processing payment of $" + amountInDollars + " through PayPal.");
    }
}

class StripeGateway {
    public void makePayment(double money) {
        System.out.println("Processing payment of $" + money + " through Stripe.");
    }
}

class RazorpayGateway {
    public void pay(double rupees) {
        System.out.println("Processing payment of ₹" + rupees + " through Razorpay.");
    }
}

// Step 4: Adapter Classes for each gateway

class PayPalAdapter implements PaymentProcessor {
    private PayPalGateway payPalGateway;

    public PayPalAdapter() {
        this.payPalGateway = new PayPalGateway();
    }

    public void processPayment(double amount) {
        payPalGateway.sendPayment(amount);
    }
}

class StripeAdapter implements PaymentProcessor {
    private StripeGateway stripeGateway;

    public StripeAdapter() {
        this.stripeGateway = new StripeGateway();
    }

    public void processPayment(double amount) {
        stripeGateway.makePayment(amount);
    }
}

class RazorpayAdapter implements PaymentProcessor {
    private RazorpayGateway razorpayGateway;

    public RazorpayAdapter() {
        this.razorpayGateway = new RazorpayGateway();
    }

    public void processPayment(double amount) {
        razorpayGateway.pay(amount);
    }
}

// Step 5: Test the Adapter Pattern
public class AdapterPatternExample {
    public static void main(String[] args) {
        // Use PayPal
        PaymentProcessor paypal = new PayPalAdapter();
        paypal.processPayment(500.0);

        // Use Stripe
        PaymentProcessor stripe = new StripeAdapter();
        stripe.processPayment(750.0);

        // Use Razorpay
        PaymentProcessor razorpay = new RazorpayAdapter();
        razorpay.processPayment(999.0);
    }
}
