package cn.sh.decorator.factory;

/**
 * New York Pizza Store
 * @author sh
 */
public class NYPizzaStore extends PizzaStore {

    @Override
    protected Pizza createPizza() {
        return new NYStyleCheesePizza();
    }
}
