package cn.sh.decorator.abfactory;

import cn.sh.decorator.abfactory.cheese.Cheese;
import cn.sh.decorator.abfactory.clams.Clams;
import cn.sh.decorator.abfactory.dough.Dough;
import cn.sh.decorator.abfactory.pepperoni.Pepperoni;
import cn.sh.decorator.abfactory.sauce.Sauce;
import cn.sh.decorator.abfactory.veggies.Veggies;

/**
 * @author sh
 */
public interface PizzaIngredientFactory {

    Dough createDough();

    Sauce createSauce();

    Cheese createCheese();

    Veggies[] createVeggies();

    Pepperoni createPepperoni();

    Clams createClams();
}
