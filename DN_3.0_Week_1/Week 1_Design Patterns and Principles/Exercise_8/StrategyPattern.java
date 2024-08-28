public class StrategyPattern {

    // Strategy Interface
    public interface PaymentStrategy {
        void pay(int amount);
    }

    // Concrete Strategy: Credit Card Payment
    public static class CreditCardPayment implements PaymentStrategy {
        private String cardNumber;

        public CreditCardPayment(String cardNumber) {
            this.cardNumber = cardNumber;
        }

        @Override
        public void pay(int amount) {
            System.out.println("Paid $" + amount + " using Credit Card ending in " + cardNumber);
        }
    }

    // Concrete Strategy: PayPal Payment
    public static class PayPalPayment implements PaymentStrategy {
        private String email;

        public PayPalPayment(String email) {
            this.email = email;
        }

        @Override
        public void pay(int amount) {
            System.out.println("Paid $" + amount + " using PayPal account " + email);
        }
    }

    // Context Class
    public static class PaymentContext {
        private PaymentStrategy paymentStrategy;

        public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
            this.paymentStrategy = paymentStrategy;
        }

        public void executePayment(int amount) {
            paymentStrategy.pay(amount);
        }
    }

    // Main method to test the Strategy Pattern
    public static void main(String[] args) {
        // Create context and set payment strategies
        PaymentContext paymentContext = new PaymentContext();

        // Use Credit Card Payment
        PaymentStrategy creditCard = new CreditCardPayment("1234-5678-9876-5432");
        paymentContext.setPaymentStrategy(creditCard);
        System.out.println("Processing payment using Credit Card:");
        paymentContext.executePayment(250);

        // Use PayPal Payment
        PaymentStrategy payPal = new PayPalPayment("user@example.com");
        paymentContext.setPaymentStrategy(payPal);
        System.out.println("\nProcessing payment using PayPal:");
        paymentContext.executePayment(150);
    }
}
