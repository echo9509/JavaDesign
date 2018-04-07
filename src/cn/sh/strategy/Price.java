package cn.sh.strategy;

public class Price {

    private MemeberStrategy strategy;

    /**
     * 计算打折后的价格
     * @param price 原价
     * @return 打折后价格
     */
    public double quote(double price) {
        return strategy.calPrice(price);
    }

    public MemeberStrategy getStrategy() {
        return strategy;
    }

    public void setStrategy(MemeberStrategy strategy) {
        this.strategy = strategy;
    }
}
