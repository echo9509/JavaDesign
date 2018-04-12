package cn.sh.obeserver;

/**
 * @author sh
 */
public interface Subject {

    void addObserver(Observer observer);

    void removeObserver(Observer observer);

    void notifyObserver();
}
