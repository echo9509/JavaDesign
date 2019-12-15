package cn.sh.state;

/**
 * @author sh
 */
public class GumballMachine implements State {

    private NoQuarterState noQuarterState;

    private HasQuarterState hasQuarterState;

    private SoldState soldState;

    private SoldOutState soldOutState;

    private State currentState;

    private int count;

    public GumballMachine(int count) {
        this.noQuarterState = new NoQuarterState(this);
        this.hasQuarterState = new HasQuarterState(this);
        this.soldState = new SoldState(this);
        this.soldOutState = new SoldOutState(this);
        this.count = count;
        currentState = noQuarterState;
    }

    public GumballMachine(State currentState) {
        this.currentState = currentState;
    }

    public void setCurrentState(State currentState) {
        this.currentState = currentState;
    }

    @Override
    public void insertQuarter() {
        currentState.insertQuarter();
    }

    @Override
    public void ejectQuarter() {
        currentState.ejectQuarter();
    }

    @Override
    public void turnCrank() {
        currentState.turnCrank();
        dispense();
    }

    @Override
    public void dispense() {
        currentState.dispense();
    }


    public void releaseBall() {
        System.out.println("A gumball comes rolling out the slot...");
        if (count != 0) {
            count -= 1;
        }
    }

    public NoQuarterState getNoQuarterState() {
        return noQuarterState;
    }

    public HasQuarterState getHasQuarterState() {
        return hasQuarterState;
    }

    public SoldState getSoldState() {
        return soldState;
    }

    public SoldOutState getSoldOutState() {
        return soldOutState;
    }

    public int getCount() {
        return count;
    }
}
