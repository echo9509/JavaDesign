package cn.sh.state;

/**
 * @author sh
 */
public class SoldState implements State {

    private GumballMachine gumballMachine;

    public SoldState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertQuarter() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void ejectQuarter() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void turnCrank() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void dispense() {
        gumballMachine.releaseBall();
        if (gumballMachine.getCount() > 0) {
            gumballMachine.setCurrentState(gumballMachine.getNoQuarterState());
        } else {
            gumballMachine.setCurrentState(gumballMachine.getSoldOutState());
        }
    }
}
