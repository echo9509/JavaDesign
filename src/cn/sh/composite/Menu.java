package cn.sh.composite;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author sh
 */
public class Menu extends MenuComponent {

    List<MenuComponent> menuComponentList = new ArrayList<>();

    String name;

    String desc;

    public Menu(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    @Override
    protected void add(MenuComponent component) {
        menuComponentList.add(component);
    }

    @Override
    protected void remove(MenuComponent component) {
        menuComponentList.remove(component);
    }

    @Override
    protected MenuComponent getChild(int index) {
        return menuComponentList.get(index);
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
    protected void print() {
        System.out.println("\n" + getName());
        System.out.println(", " + getDesc());
        System.out.println("---------------------");
        Iterator<MenuComponent> iterator = menuComponentList.iterator();
        while (iterator.hasNext()) {
            MenuComponent next = iterator.next();
            next.print();
        }
    }
}
