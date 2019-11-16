package cn.sh.decorator.base;

import java.math.BigDecimal;

/**
 * @author sh
 * 饮料抽象类
 */
public abstract class BaseBeverage {

    protected String description;

    protected BigDecimal cost;

    pfo

    /**
     * 饮料价格抽象方法
     * @return 价格
     */
    public abstract BigDecimal cost();

    public String getDescription() {
        return description;
    }


}
