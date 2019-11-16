package cn.sh.decorator.beverage;

import cn.sh.decorator.base.BaseBeverage;

import java.math.BigDecimal;

/**
 * @author sh
 * 深度烘焙咖啡
 */
public class DarkRoast extends BaseBeverage {

    private int size;

    public DarkRoast(BigDecimal cost) {
        this.description = "DarkRoast";
        this.cost = cost;
    }

    @Override
    public BigDecimal cost() {
        return cost;
    }
}
