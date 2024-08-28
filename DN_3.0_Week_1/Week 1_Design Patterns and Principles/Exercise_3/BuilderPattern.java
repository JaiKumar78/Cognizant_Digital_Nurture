public class BuilderPattern {

    // Product class with the Builder Pattern implementation
    public static class Computer {
        // Attributes
        private final String CPU;
        private final String RAM;
        private final String storage;
        private final boolean hasGraphicsCard;
        private final boolean hasWiFi;

        // Private constructor to be used by the Builder
        private Computer(Builder builder) {
            this.CPU = builder.CPU;
            this.RAM = builder.RAM;
            this.storage = builder.storage;
            this.hasGraphicsCard = builder.hasGraphicsCard;
            this.hasWiFi = builder.hasWiFi;
        }

        // Getters for the attributes
        public String getCPU() {
            return CPU;
        }

        public String getRAM() {
            return RAM;
        }

        public String getStorage() {
            return storage;
        }

        public boolean hasGraphicsCard() {
            return hasGraphicsCard;
        }

        public boolean hasWiFi() {
            return hasWiFi;
        }

        // Static nested Builder class
        public static class Builder {
            private String CPU;
            private String RAM;
            private String storage;
            private boolean hasGraphicsCard;
            private boolean hasWiFi;

            // Methods to set each attribute
            public Builder setCPU(String CPU) {
                this.CPU = CPU;
                return this;
            }

            public Builder setRAM(String RAM) {
                this.RAM = RAM;
                return this;
            }

            public Builder setStorage(String storage) {
                this.storage = storage;
                return this;
            }

            public Builder setGraphicsCard(boolean hasGraphicsCard) {
                this.hasGraphicsCard = hasGraphicsCard;
                return this;
            }

            public Builder setWiFi(boolean hasWiFi) {
                this.hasWiFi = hasWiFi;
                return this;
            }

            // Build method that returns an instance of Computer
            public Computer build() {
                return new Computer(this);
            }
        }
    }

    // Main method to demonstrate the Builder Pattern
    public static void main(String[] args) {
        // Create a Computer instance using the Builder pattern
        Computer gamingComputer = new Computer.Builder()
                .setCPU("Intel i9")
                .setRAM("32GB")
                .setStorage("1TB SSD")
                .setGraphicsCard(true)
                .setWiFi(true)
                .build();

        Computer officeComputer = new Computer.Builder()
                .setCPU("Intel i5")
                .setRAM("16GB")
                .setStorage("512GB SSD")
                .setGraphicsCard(false)
                .setWiFi(true)
                .build();

        // Output the details of the created computers
        System.out.println("Gaming Computer:");
        System.out.println("CPU: " + gamingComputer.getCPU());
        System.out.println("RAM: " + gamingComputer.getRAM());
        System.out.println("Storage: " + gamingComputer.getStorage());
        System.out.println("Graphics Card: " + gamingComputer.hasGraphicsCard());
        System.out.println("WiFi: " + gamingComputer.hasWiFi());

        System.out.println("\nOffice Computer:");
        System.out.println("CPU: " + officeComputer.getCPU());
        System.out.println("RAM: " + officeComputer.getRAM());
        System.out.println("Storage: " + officeComputer.getStorage());
        System.out.println("Graphics Card: " + officeComputer.hasGraphicsCard());
        System.out.println("WiFi: " + officeComputer.hasWiFi());
    }
}
