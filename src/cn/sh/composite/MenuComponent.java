package cn.sh.composite;

import java.math.BigDecimal;

/**
 * @author sh
 */
public abstract class MenuComponent {

    protected String getName() {
        throw new UnsupportedOperationException();
    }

    protected String getDesc() {
        throw new UnsupportedOperationException();
    }

    protected BigDecimal getPrice() {
        throw new UnsupportedOperationException();
    }

    protected boolean isVegetarian() {
        throw new UnsupportedOperationException();
    }

    protected void print() {
        throw new UnsupportedOperationException();
    }

    protected void add(MenuComponent component) {
        throw new UnsupportedOperationException();
    }

    protected void remove(MenuComponent component) {
        throw new UnsupportedOperationException();
    }

    protected MenuComponent getChild(int index) {
        throw new UnsupportedOperationException();
    }
}
