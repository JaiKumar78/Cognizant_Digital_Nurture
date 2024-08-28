public class CommandPattern {

    // Command Interface
    public interface Command {
        void execute();
    }

    // Receiver Class
    public static class Light {
        public void turnOn() {
            System.out.println("Light is ON");
        }

        public void turnOff() {
            System.out.println("Light is OFF");
        }
    }

    // Concrete Command: Turn On Light
    public static class LightOnCommand implements Command {
        private Light light;

        public LightOnCommand(Light light) {
            this.light = light;
        }

        @Override
        public void execute() {
            light.turnOn();
        }
    }

    // Concrete Command: Turn Off Light
    public static class LightOffCommand implements Command {
        private Light light;

        public LightOffCommand(Light light) {
            this.light = light;
        }

        @Override
        public void execute() {
            light.turnOff();
        }
    }

    // Invoker Class
    public static class RemoteControl {
        private Command command;

        public void setCommand(Command command) {
            this.command = command;
        }

        public void pressButton() {
            command.execute();
        }
    }

    // Main method to test the Command Pattern
    public static void main(String[] args) {
        // Create a Light and commands
        Light livingRoomLight = new Light();
        Command lightOn = new LightOnCommand(livingRoomLight);
        Command lightOff = new LightOffCommand(livingRoomLight);

        // Create a RemoteControl and test commands
        RemoteControl remote = new RemoteControl();

        // Turn on the light
        remote.setCommand(lightOn);
        System.out.println("Pressing button to turn on the light:");
        remote.pressButton();

        // Turn off the light
        remote.setCommand(lightOff);
        System.out.println("Pressing button to turn off the light:");
        remote.pressButton();
    }
}
