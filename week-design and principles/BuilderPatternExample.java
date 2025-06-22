// BuilderPatternExample.java

// Step 2: Define the Product Class
class Computer {
    private String CPU;
    private String RAM;
    // Optional attributes
    private String storage;
    private String graphicsCard;
    private String operatingSystem;

    // Step 4: Private constructor accepting the Builder
    private Computer(Builder builder) {
        this.CPU = builder.CPU;
        this.RAM = builder.RAM;
        this.storage = builder.storage;
        this.graphicsCard = builder.graphicsCard;
        this.operatingSystem = builder.operatingSystem;
    }

    // Step 3: Static Nested Builder Class
    public static class Builder {
        private String CPU;
        private String RAM;
        private String storage;
        private String graphicsCard;
        private String operatingSystem;

        public Builder(String CPU, String RAM) {
            this.CPU = CPU;
            this.RAM = RAM;
        }

        public Builder setStorage(String storage) {
            this.storage = storage;
            return this;
        }

        public Builder setGraphicsCard(String graphicsCard) {
            this.graphicsCard = graphicsCard;
            return this;
        }

        public Builder setOperatingSystem(String operatingSystem) {
            this.operatingSystem = operatingSystem;
            return this;
        }

        // Final step: build method to return the completed Computer
        public Computer build() {
            return new Computer(this);
        }
    }

    // Method to display configuration
    public void displayConfig() {
        System.out.println("Computer Configuration:");
        System.out.println("CPU: " + CPU);
        System.out.println("RAM: " + RAM);
        System.out.println("Storage: " + (storage != null ? storage : "Not included"));
        System.out.println("Graphics Card: " + (graphicsCard != null ? graphicsCard : "Not included"));
        System.out.println("OS: " + (operatingSystem != null ? operatingSystem : "Not included"));
        System.out.println("----------------------------");
    }
}

// Step 5: Test the Builder Pattern
public class BuilderPatternExample {
    public static void main(String[] args) {
        // Build a basic computer
        Computer basicComputer = new Computer.Builder("Intel i3", "8GB").build();
        basicComputer.displayConfig();

        // Build a high-end gaming computer
        Computer gamingComputer = new Computer.Builder("AMD Ryzen 9", "32GB")
                .setStorage("1TB SSD")
                .setGraphicsCard("NVIDIA RTX 4090")
                .setOperatingSystem("Windows 11 Pro")
                .build();
        gamingComputer.displayConfig();

        // Build a mid-range workstation
        Computer workstation = new Computer.Builder("Intel i7", "16GB")
                .setStorage("512GB SSD")
                .setOperatingSystem("Ubuntu Linux")
                .build();
        workstation.displayConfig();
    }
}
