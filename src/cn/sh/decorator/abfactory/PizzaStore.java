package cn.sh.decorator.abfactory;


/**
 * @author sh
 */
public abstract class PizzaStore {

    /**
     * Order pizza
     * @return
     */
    public Pizza orderPizza(String item) {
        Pizza pizza = createPizza(item);
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
    abstract Pizza createPizza(String item);

}
