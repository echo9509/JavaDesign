package cn.sh.decorator.factory;

import java.util.List;
import java.util.Objects;

/**
 * @author sh
 */
public abstract class Pizza {

    String name;

    String dough;

    String sauce;

    List<String> toppingList;

    void prepare() {
        System.out.println("Preparing " + name);
        System.out.println("Tossing dough...");
        System.out.println("Adding sauce");
        System.out.println("Adding toppings:");
        Objects.requireNonNull(toppingList).forEach(topping -> System.out.println("\t" +topping));
    }

    void bake() {
        System.out.println("Bake for 25 minutes at 350");
    }

    void cut() {
        System.out.println("Cutting the pizza into diagonal slices");
    }

    void box() {
        System.out.println("Place pizza in official PizzaStore box");
    }

    public String getName() {
        return name;
    }
}
