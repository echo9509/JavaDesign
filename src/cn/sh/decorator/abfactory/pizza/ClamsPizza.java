package cn.sh.decorator.abfactory.pizza;

import cn.sh.decorator.abfactory.Pizza;
import cn.sh.decorator.abfactory.PizzaIngredientFactory;

/**
 * @author sh
 */
public class ClamsPizza extends Pizza {

    private PizzaIngredientFactory ingredientFactory;

    public ClamsPizza(PizzaIngredientFactory ingredientFactory) {
        this.ingredientFactory = ingredientFactory;
    }

    @Override
    protected void prepare() {
        System.out.println("Prepare " + getName());
        dough = ingredientFactory.createDough();
        sauce = ingredientFactory.createSauce();
        cheese = ingredientFactory.createCheese();
        clams = ingredientFactory.createClams();
    }
}
