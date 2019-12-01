package cn.sh.adapter;

/**
 * @author sh
 */
public class AdapterTestApp {

    public static void main(String[] args) {
        Turkey turkey = new WildTurkey();
        Duck duck = new TurkeyAdapter(turkey);
        duck.quack();
        duck.fly();
    }
}
