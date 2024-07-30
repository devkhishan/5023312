interface Command
{
    void execute();
}

class LightOnCommand implements Command
{
    private Light light;

    public LightOnCommand(Light light)
    {
        this.light = light;
    }
    public void execute()
    {
        light.turnOn();
        System.out.println("Lights turned ON");
    }
}

class LightOffCommand implements Command
{
    private Light light;

    public LightOffCommand(Light light)
    {
        this.light = light;
    }
    @Override
    public void execute()
    {
        light.turnOff();
        System.out.println("Lights turned OFF");
    }
}
class Light
{
    boolean light;
    public Light()
    {
        light = false;
    }

    public void turnOn()
    {
        light = true;
    }

    public void turnOff()
    {
        light = false;
    }
}
class RemoteControl
{
    private Command command;
    public RemoteControl(Command command)
    {
        this.command = command;
    }

    public void setCommand(Command command)
    {
        this.command = command;
    }

    public void executeCommand()
    {
        this.command.execute();
    }

}


public class CommandPatternExample {
    public static void main(String[] args) {
        Light light = new Light();
        Command lightOn = new LightOnCommand(light);
        Command lightOff = new LightOffCommand(light);

        RemoteControl remote = new RemoteControl(lightOn);
        remote.executeCommand();

        remote.setCommand(lightOff);
        remote.executeCommand();
    }
}
