package jvm.heap;

/**
 * @author sh
 */
public class EscapeAnalysis {

    public static class User {
        private int id = 0;
        private String name = "";
    }

    public static void alloc() {
        User u = new User();
        u.id = 5;
        u.name = "xiaohong";
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 100000000; i++) {
            alloc();
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}
