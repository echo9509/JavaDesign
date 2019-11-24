package cn.sh.decorator.abfactory;

import cn.sh.decorator.abfactory.cheese.Cheese;
import cn.sh.decorator.abfactory.cheese.ReggianoCheese;
import cn.sh.decorator.abfactory.clams.Clams;
import cn.sh.decorator.abfactory.clams.FreshClams;
import cn.sh.decorator.abfactory.dough.Dough;
import cn.sh.decorator.abfactory.dough.ThinCrustDough;
import cn.sh.decorator.abfactory.pepperoni.Pepperoni;
import cn.sh.decorator.abfactory.pepperoni.SlicedPepperoni;
import cn.sh.decorator.abfactory.sauce.MarinaraSauce;
import cn.sh.decorator.abfactory.sauce.Sauce;
import cn.sh.decorator.abfactory.veggies.Garlic;
import cn.sh.decorator.abfactory.veggies.Onion;
import cn.sh.decorator.abfactory.veggies.Veggies;

/**
 * @author sh
 */
public class NYPizzaIngredientFactory implements PizzaIngredientFactory {

    @Override
    public Dough createDough() {
        return new ThinCrustDough();
    }

    @Override
    public Sauce createSauce() {
        return new MarinaraSauce();
    }

    @Override
    public Cheese createCheese() {
        return new ReggianoCheese();
    }

    @Override
    public Veggies[] createVeggies() {
        return new Veggies[]{new Garlic(), new Onion()};
    }

    @Override
    public Pepperoni createPepperoni() {
        return new SlicedPepperoni();
    }

    @Override
    public Clams createClams() {
        return new FreshClams();
    }
}
