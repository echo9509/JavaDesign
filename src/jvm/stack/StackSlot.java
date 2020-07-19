package jvm.stack;

/**
 * @author sh
 */
public class StackSlot {

    public static class StackObj {
        private int a = 2;
        private long b = 3;
    }

    public void stackSlot(int a, int b, long c) {
        try {
            long d = 2;
            long id = 111000000000L;
            int cc = 32768;
            String bbc = "et";
            System.out.println(d);
        } catch (Exception e) {
            return;
        }
        StackObj obj = new StackObj();
        int e = 3;
    }

    public static void stackStaticSlot(int a, int b, long c) {
        {
            long d = 2;
            System.out.println(d);
        }
        StackObj obj = new StackObj();
        int e = 3;
    }

    public static void main(String[] args) {
        StackSlot stackSlot = new StackSlot();
        stackSlot.stackSlot(1, 2, 3);
    }
}
