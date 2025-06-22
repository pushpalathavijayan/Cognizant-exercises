// CommandPatternExample.java

// Step 2: Command Interface
interface Command {
    void execute();
}

// Step 5: Receiver Class
class Light {
    private String location;

    public Light(String location) {
        this.location = location;
    }

    public void turnOn() {
        System.out.println(location + " light is ON.");
    }

    public void turnOff() {
        System.out.println(location + " light is OFF.");
    }
}

// Step 3: Concrete Commands
class LightOnCommand implements Command {
    private Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    public void execute() {
        light.turnOn();
    }
}

class LightOffCommand implements Command {
    private Light light;

    public LightOffCommand(Light light) {
        this.light = light;
    }

    public void execute() {
        light.turnOff();
    }
}

// Step 4: Invoker Class
class RemoteControl {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void pressButton() {
        if (command != null) {
            command.execute();
        } else {
            System.out.println("No command set.");
        }
    }
}

// Step 6: Test the Command Pattern
public class CommandPatternExample {
    public static void main(String[] args) {
        // Receiver
        Light livingRoomLight = new Light("Living Room");
        Light kitchenLight = new Light("Kitchen");

        // Commands
        Command livingRoomLightOn = new LightOnCommand(livingRoomLight);
        Command livingRoomLightOff = new LightOffCommand(livingRoomLight);

        Command kitchenLightOn = new LightOnCommand(kitchenLight);
        Command kitchenLightOff = new LightOffCommand(kitchenLight);

        // Invoker
        RemoteControl remote = new RemoteControl();

        // Using commands
        remote.setCommand(livingRoomLightOn);
        remote.pressButton();

        remote.setCommand(kitchenLightOn);
        remote.pressButton();

        remote.setCommand(kitchenLightOff);
        remote.pressButton();

        remote.setCommand(livingRoomLightOff);
        remote.pressButton();
    }
}
