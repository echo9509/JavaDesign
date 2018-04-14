package cn.sh.jdk.observer;

import java.util.Observable;

public class WeatherData extends Observable {

    private int temp;

    public void setTemp(int temp) {
        this.temp = temp;
        //设置温度已经改变
        setChanged();
        //通知观察者
        notifyObservers();
    }

    public int getTemp() {
        return temp;
    }
}
