package cn.sh.state;

/**
 * @author sh
 */
public class HasQuarterState implements State {

    private GumballMachine gumballMachine;

    public HasQuarterState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertQuarter() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void ejectQuarter() {
        System.out.println("You eject a quarter!");
        gumballMachine.setCurrentState(gumballMachine.getNoQuarterState());
    }

    @Override
    public void turnCrank() {
        System.out.println("You turn this crank!");
        gumballMachine.setCurrentState(gumballMachine.getSoldState());
    }

    @Override
    public void dispense() {
        throw new UnsupportedOperationException();
    }
}
