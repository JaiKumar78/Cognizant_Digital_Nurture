public class AdapterPattern {

    // Target interface
    public interface PaymentProcessor {
        void processPayment(double amount);
    }

    // Adaptee classes
    public static class PaypalGateway {
        public void makePayment(double amount) {
            System.out.println("Processing payment of $" + amount + " through PayPal.");
        }
    }

    public static class StripeGateway {
        public void charge(double amount) {
            System.out.println("Charging $" + amount + " through Stripe.");
        }
    }

    // Adapter classes
    public static class PaypalAdapter implements PaymentProcessor {
        private PaypalGateway paypalGateway;

        public PaypalAdapter(PaypalGateway paypalGateway) {
            this.paypalGateway = paypalGateway;
        }

        @Override
        public void processPayment(double amount) {
            paypalGateway.makePayment(amount);
        }
    }

    public static class StripeAdapter implements PaymentProcessor {
        private StripeGateway stripeGateway;

        public StripeAdapter(StripeGateway stripeGateway) {
            this.stripeGateway = stripeGateway;
        }

        @Override
        public void processPayment(double amount) {
            stripeGateway.charge(amount);
        }
    }

    // Main method to test the Adapter Pattern
    public static void main(String[] args) {
        // Create instances of the third-party gateways
        PaypalGateway paypalGateway = new PaypalGateway();
        StripeGateway stripeGateway = new StripeGateway();

        // Create adapters for the payment processors
        PaymentProcessor paypalAdapter = new PaypalAdapter(paypalGateway);
        PaymentProcessor stripeAdapter = new StripeAdapter(stripeGateway);

        // Use the adapters to process payments
        System.out.println("Processing payment through PayPal:");
        paypalAdapter.processPayment(100.0);

        System.out.println("\nProcessing payment through Stripe:");
        stripeAdapter.processPayment(200.0);
    }
}
