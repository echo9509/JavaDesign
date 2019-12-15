package cn.sh.composite;

import java.math.BigDecimal;

/**
 * @author sh
 */
public class MenuItem extends MenuComponent {

    private String name;

    private String desc;

    private boolean isVegetarian;

    private BigDecimal price;

    public MenuItem(String name, String desc, boolean isVegetarian, BigDecimal price) {
        this.name = name;
        this.desc = desc;
        this.isVegetarian = isVegetarian;
        this.price = price;
    }

    @Override
    protected String getName() {
        return name;
    }

    @Override
    protected String getDesc() {
        return desc;
    }

    @Override
    protected BigDecimal getPrice() {
        return price;
    }

    @Override
    protected boolean isVegetarian() {
        return isVegetarian;
    }

    @Override
    protected void print() {
        System.out.println(" " + getName());
        if (isVegetarian()) {
            System.out.println("(v)");
        }
        System.out.println(", " + getPrice());
        System.out.println(" -- " + getDesc());
    }
}
