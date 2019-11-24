package cn.sh.singleton;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author sh
 */
public class SingletonSyncInitial {

    private static SingletonSyncInitial single;

    private SingletonSyncInitial() {
    }

    public static synchronized SingletonSyncInitial getInstance() {
        if (single == null) {
            single = new SingletonSyncInitial();
        }
        return single;
    }

    public static void main(String[] args) {
        ExecutorService executors = Executors.newFixedThreadPool(10);
        Runnable task = () -> System.out.println(SingletonSyncInitial.getInstance().hashCode());
        for (int i = 0; i < 10; i++) {
            executors.submit(task);
        }
    }
}
