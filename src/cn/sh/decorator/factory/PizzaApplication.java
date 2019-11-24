package cn.sh.decorator.factory;

/**
 * Factory Design
 * @author sh
 */
public class PizzaApplication {

    public static void main(String[] args) {
        PizzaStore pizzaStore = new NYPizzaStore();
        Pizza pizza = pizzaStore.orderPizza();
        System.out.println("Devi order a " + pizza.getName() + "\n");

        pizzaStore = new ChicagoPizzaStore();
        pizza = pizzaStore.orderPizza();
        System.out.println("John order a " + pizza.getName() + "\n");
    }
}
