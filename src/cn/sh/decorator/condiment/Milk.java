package cn.sh.decorator.condiment;

import cn.sh.decorator.base.BaseBeverage;
import cn.sh.decorator.base.BaseCondimentDecorator;
import java.math.BigDecimal;

/**
 * @author sh
 * 牛奶
 */
public class Milk extends BaseCondimentDecorator {

    public Milk(BaseBeverage beverage) {
        this.description = "Milk";
        this.beverage = beverage;
    }

    @Override
    protected BigDecimal condimentCost() {
        return new BigDecimal("5");
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + " and " + description;
    }
}
