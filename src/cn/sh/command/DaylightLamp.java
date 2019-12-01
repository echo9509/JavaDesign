package cn.sh.command;

/**
 * @author sh
 */
public class DaylightLamp implements Light {

    @Override
    public void off() {
        System.out.println("Daylight Lamp Off");
    }

    @Override
    public void on() {
        System.out.println("Daylight Lamp On");
    }
}
