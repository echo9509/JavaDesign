package cn.sh.decorator;

import cn.sh.decorator.base.BaseBeverage;
import cn.sh.decorator.beverage.DarkRoast;
import cn.sh.decorator.condiment.Milk;
import cn.sh.decorator.condiment.Mocha;

import java.math.BigDecimal;

/**
 * @author sh
 */
public class Application {

    public static void main(String[] args) {
        BaseBeverage darkRoast = new DarkRoast(new BigDecimal(50));
        Milk milkDarkRoast = new Milk(darkRoast);
        System.out.println(milkDarkRoast.getDescription() + " cost " + milkDarkRoast.cost());
        Mocha mochaMilkDarkRoast = new Mocha(milkDarkRoast);
        System.out.println(mochaMilkDarkRoast.getDescription() + " cost " + mochaMilkDarkRoast.cost());
    }
}
