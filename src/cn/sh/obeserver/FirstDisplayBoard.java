package cn.sh.obeserver;

/**
 * @author sh
 */
public class FirstDisplayBoard extends DisplayBoard implements Observer {

    public FirstDisplayBoard() {
        this.name = "第一块面板";
    }

    @Override
    public void update(int temp) {
        this.temp = temp;
        display();
    }
}
