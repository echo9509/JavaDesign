package cn.sh.state;

/**
 * @author sh
 */
public class GumballMachineTest {

    public static void main(String[] args) {
        GumballMachine gumballMachine = new GumballMachine(2);
        gumballMachine.insertQuarter();
        gumballMachine.turnCrank();

        System.out.println("------------------------------");

        gumballMachine.insertQuarter();
        gumballMachine.turnCrank();

        System.out.println("------------------------------");

        gumballMachine.insertQuarter();
        gumballMachine.turnCrank();


        System.out.println("------------------------------");

        gumballMachine.insertQuarter();
        gumballMachine.turnCrank();
    }
}
