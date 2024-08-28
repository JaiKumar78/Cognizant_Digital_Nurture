public class DecoratorPattern{

    // Component interface
    public interface Notifier {
        void send(String message);
    }

    // Concrete Component
    public static class EmailNotifier implements Notifier {
        @Override
        public void send(String message) {
            System.out.println("Sending email: " + message);
        }
    }

    // Abstract Decorator
    public static abstract class NotifierDecorator implements Notifier {
        protected Notifier decoratedNotifier;

        public NotifierDecorator(Notifier decoratedNotifier) {
            this.decoratedNotifier = decoratedNotifier;
        }

        @Override
        public void send(String message) {
            decoratedNotifier.send(message);
        }
    }

    // Concrete Decorator for SMS
    public static class SMSNotifierDecorator extends NotifierDecorator {
        public SMSNotifierDecorator(Notifier decoratedNotifier) {
            super(decoratedNotifier);
        }

        @Override
        public void send(String message) {
            super.send(message);
            sendSMS(message);
        }

        private void sendSMS(String message) {
            System.out.println("Sending SMS: " + message);
        }
    }

    // Concrete Decorator for Slack
    public static class SlackNotifierDecorator extends NotifierDecorator {
        public SlackNotifierDecorator(Notifier decoratedNotifier) {
            super(decoratedNotifier);
        }

        @Override
        public void send(String message) {
            super.send(message);
            sendSlackMessage(message);
        }

        private void sendSlackMessage(String message) {
            System.out.println("Sending Slack message: " + message);
        }
    }

    // Main method to test the Decorator Pattern
    public static void main(String[] args) {
        // Create a basic email notifier
        Notifier emailNotifier = new EmailNotifier();

        // Decorate email notifier with SMS and Slack functionality
        Notifier smsAndEmailNotifier = new SMSNotifierDecorator(emailNotifier);
        Notifier slackAndSMSAndEmailNotifier = new SlackNotifierDecorator(smsAndEmailNotifier);

        // Send notifications
        System.out.println("Sending notifications with SMS and Slack:");
        slackAndSMSAndEmailNotifier.send("Hello World!");
    }
}
