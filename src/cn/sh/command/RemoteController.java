package cn.sh.command;

/**
 * @author sh
 */
public class RemoteController {

    private Command[] commands;

    public RemoteController(Command[] commands) {
        this.commands = commands;
    }

    public void pressSwitch(int i) {
        commands[i].execute();
    }

    public static void main(String[] args) {
        Command[] commands = new Command[2];
        RemoteController controller = new RemoteController(commands);
        Light light = new DaylightLamp();
        commands[0] = new LightOnCommand(light);
        commands[1] = new LightOffCommand(light);
        controller.pressSwitch(0);
        controller.pressSwitch(1);
    }
}
