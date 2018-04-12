package cn.sh.obeserver;

/**
 * @author sh
 */
public class SecondDisplayBoard extends DisplayBoard implements Observer{

    public SecondDisplayBoard() {
        this.name = "第二块面板";
    }

    @Override
    public void update(int temp) {
        this.temp = temp;
        display();
    }
}
