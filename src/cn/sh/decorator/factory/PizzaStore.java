package cn.sh.decorator.factory;

/**
 * @author sh
 */
public abstract class PizzaStore {

    /**
     * Order pizza
     * @return
     */
    public Pizza orderPizza() {
        Pizza pizza = createPizza();
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();
        return pizza;
    }

    /**
     * Make pizza
     * @return
     */
    abstract Pizza createPizza();
}
