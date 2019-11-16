package cn.sh.decorator.beverage;

import cn.sh.decorator.base.BaseBeverage;

import java.math.BigDecimal;

/**
 * @author sh
 * 黑咖啡
 */
public class HouseBlend extends BaseBeverage {

    public HouseBlend(BigDecimal cost) {
        this.description = "HouseBlend";
        this.cost = cost;
    }

    @Override
    public BigDecimal cost() {
        return cost;
    }
}
