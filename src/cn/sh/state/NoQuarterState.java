package cn.sh.state;

public class NoQuarterState implements State {

    private GumballMachine gumballMachine;

    public NoQuarterState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("You insert a quarter!");
        gumballMachine.setCurrentState(gumballMachine.getHasQuarterState());
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
        throw new UnsupportedOperationException();
    }
}
