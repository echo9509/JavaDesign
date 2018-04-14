package cn.sh.observer;

/**
 * @author sh
 */
class DisplayBoard {

    int temp;

    String name;

    void display() {
        System.out.printf("%1s显示当前温度：%2s", name, temp);
        System.out.println();
    }
}
