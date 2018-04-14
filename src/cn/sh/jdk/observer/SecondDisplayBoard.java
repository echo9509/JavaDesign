package cn.sh.jdk.observer;

import java.util.Observable;
import java.util.Observer;

public class SecondDisplayBoard implements Observer {

    @Override
    public void update(Observable o, Object arg) {
        WeatherData weatherData = (WeatherData) o;
        System.out.println("第一块面板温度:" + weatherData.getTemp());
    }
}
