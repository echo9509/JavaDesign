package cn.sh.decorator.factory;

import java.util.ArrayList;

/**
 * New York Style Cheese Pizza
 * @author sh
 */
public class NYStyleCheesePizza extends Pizza {

    public NYStyleCheesePizza() {
        name = "NY Style Sauce and Cheese Pizza";
        dough = "Thin Crust Dough";
        sauce = "Marinara Sauce";
        toppingList = new ArrayList<>();
        toppingList.add("Grated Reggiano Cheese");
    }
}
