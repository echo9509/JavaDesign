package cn.sh.decorator.base;

import java.math.BigDecimal;

/**
 * @author sh
 * 调料组件
 */
public abstract class BaseCondimentDecorator extends BaseBeverage {

    protected BaseBeverage beverage;

    @Override
    public final BigDecimal cost() {
        return beverage.cost().add(condimentCost());
    }

    /**
     * 调料价格
     * @return
     */
    protected abstract BigDecimal condimentCost();

    @Override
    public abstract String getDescription();
}
