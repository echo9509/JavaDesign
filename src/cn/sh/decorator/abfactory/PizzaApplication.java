package cn.sh.decorator.abfactory;

/**
 * @author sh
 */
public class PizzaApplication {

    public static void main(String[] args) {
        PizzaStore pizzaStore = new NYPizzaStore();
        Pizza pizza = pizzaStore.orderPizza("cheese");
        System.out.println("Devi order " + pizza.getName() + "\n");
    }
}
