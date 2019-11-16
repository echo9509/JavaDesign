package cn.sh.decorator.condiment;

import cn.sh.decorator.base.BaseBeverage;
import cn.sh.decorator.base.BaseCondimentDecorator;

import java.math.BigDecimal;

/**
 * @author sh
 */
public class Mocha extends BaseCondimentDecorator {

    public Mocha(BaseBeverage beverage) {
        this.description = "Mocha";
        this.beverage = beverage;
    }

    @Override
    public BigDecimal condimentCost() {
        return new BigDecimal("3");
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + " and " + description;
    }
}
