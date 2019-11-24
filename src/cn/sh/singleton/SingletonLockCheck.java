package cn.sh.singleton;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author sh
 */
public class SingletonLockCheck {

    private static volatile SingletonLockCheck singleton;

    private SingletonLockCheck() {

    }

    public static SingletonLockCheck getInstance() {
        if (singleton == null) {
            synchronized (SingletonLockCheck.class) {
                if (singleton == null) {
                    singleton = new SingletonLockCheck();
                }
            }
        }
        return singleton;
    }

    public static void main(String[] args) {
        ExecutorService executors = Executors.newFixedThreadPool(10);
        Runnable task = () -> System.out.println(SingletonLockCheck.getInstance().hashCode());
        for (int i = 0; i < 10; i++) {
            executors.submit(task);
        }
    }
}
