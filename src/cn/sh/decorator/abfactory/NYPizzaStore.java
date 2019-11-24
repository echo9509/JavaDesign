package cn.sh.decorator.abfactory;

import cn.sh.decorator.abfactory.pizza.CheesePizza;
import cn.sh.decorator.abfactory.pizza.ClamsPizza;

/**
 * @author sh
 */
public class NYPizzaStore extends PizzaStore {

    @Override
    Pizza createPizza(String item) {
        Pizza pizza = null;
        PizzaIngredientFactory factory = new NYPizzaIngredientFactory();
        if ("cheese".equals(item)) {
            pizza = new CheesePizza(factory);
            pizza.setName("New York Style Cheese Pizza");
        } else if ("clams".equals(item)) {
            pizza = new ClamsPizza(factory);
            pizza.setName("New York Clam Pizza");
        }
        return pizza;
    }
}
