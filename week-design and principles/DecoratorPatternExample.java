// DecoratorPatternExample.java

// Step 2: Define Component Interface
interface Notifier {
    void send(String message);
}

// Step 3: Implement Concrete Component
class EmailNotifier implements Notifier {
    public void send(String message) {
        System.out.println("Sending Email: " + message);
    }
}

// Step 4: Abstract Decorator Class
abstract class NotifierDecorator implements Notifier {
    protected Notifier wrappedNotifier;

    public NotifierDecorator(Notifier notifier) {
        this.wrappedNotifier = notifier;
    }

    public void send(String message) {
        wrappedNotifier.send(message); // Forward the call
    }
}

// Step 4: Concrete Decorators
class SMSNotifierDecorator extends NotifierDecorator {
    public SMSNotifierDecorator(Notifier notifier) {
        super(notifier);
    }

    public void send(String message) {
        super.send(message);
        System.out.println("Sending SMS: " + message);
    }
}

class SlackNotifierDecorator extends NotifierDecorator {
    public SlackNotifierDecorator(Notifier notifier) {
        super(notifier);
    }

    public void send(String message) {
        super.send(message);
        System.out.println("Sending Slack Message: " + message);
    }
}

// Step 5: Test Class
public class DecoratorPatternExample {
    public static void main(String[] args) {
        // Basic Email Notification
        Notifier basicNotifier = new EmailNotifier();
        
        // Add SMS functionality
        Notifier smsNotifier = new SMSNotifierDecorator(basicNotifier);
        
        // Add Slack functionality
        Notifier fullNotifier = new SlackNotifierDecorator(smsNotifier);

        // Send notification
        fullNotifier.send("Your order has been shipped!");
    }
}
