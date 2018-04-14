package cn.sh.observer;


import java.util.Vector;

/**
 * @author sh
 * 主题的具体实现类
 */
public class WeatherData implements Subject {

    private Vector<Observer> observerList = new Vector<>();

    private int temp;

    /**
     * 观察者注册到主题
     * @param observer 观察者
     */
    @Override
    public void addObserver(Observer observer) {
        if (!observerList.contains(observer)) {
            observerList.add(observer);
        }
    }

    /**
     * 观察者取消注册
     * @param observer
     */
    @Override
    public void removeObserver(Observer observer) {
        observerList.remove(observer);
    }

    @Override
    public void notifyObserver() {
        observerList.forEach(observer -> observer.update(temp));
    }

    public void setTemp(int temp) {
        this.temp = temp;
        notifyObserver();
    }
}
