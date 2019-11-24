package cn.sh.decorator.factory;

/**
 * Chicago Pizza Store
 * @author sh
 */
public class ChicagoPizzaStore extends PizzaStore {

    @Override
    protected Pizza createPizza() {
        return new ChicagoStyleCheesePizza();
    }
}
