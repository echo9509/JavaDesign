package cn.sh.decorator.abfactory.pizza;

import cn.sh.decorator.abfactory.Pizza;
import cn.sh.decorator.abfactory.PizzaIngredientFactory;

/**
 * @author sh
 */
public class CheesePizza extends Pizza {

    PizzaIngredientFactory ingredientFactory;

    public CheesePizza(PizzaIngredientFactory ingredientFactory) {
        this.ingredientFactory = ingredientFactory;
    }

    @Override
    protected void prepare() {
        System.out.println("Prepare " + getName());
        dough = ingredientFactory.createDough();
        sauce = ingredientFactory.createSauce();
        cheese = ingredientFactory.createCheese();
    }
}
