package cn.sh.singleton;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author sh
 */
public class SingletonFastInitial {

    private static SingletonFastInitial single = new SingletonFastInitial();

    private SingletonFastInitial() {}

    public static SingletonFastInitial getInstance() {
        return single;
    }

    public static void main(String[] args) {
        ExecutorService executors = Executors.newFixedThreadPool(10);
        Runnable task = () -> System.out.println(SingletonFastInitial.getInstance().hashCode());
        for (int i = 0; i < 10; i++) {
            executors.submit(task);
        }
    }
}
