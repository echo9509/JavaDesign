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
public abstract class Pizza {

    String name;

    protected Dough dough;

    protected Sauce sauce;

    protected Veggies[] veggies;

    protected Cheese cheese;

    protected Pepperoni pepperoni;

    protected Clams clams;

    /**
     * collect ingredient
     */
    protected abstract void prepare();

    void bake() {
        System.out.println("Bake for 25 minutes at 350");
    }

    void cut() {
        System.out.println("Cutting the pizza into diagonal slices");
    }

    void box() {
        System.out.println("Place pizza in official PizzaStore box");
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
