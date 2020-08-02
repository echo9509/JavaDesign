package demo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sh
 */
public class IgnoreCaseString {

    private final String s;

    public IgnoreCaseString(String s) {
        this.s = s;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof IgnoreCaseString) {
            return s.equalsIgnoreCase(((IgnoreCaseString) obj).s);
        }
        if (obj instanceof String) {
            return s.equalsIgnoreCase((String) obj);
        }
        return false;
    }

    public static void main(String[] args) {
        IgnoreCaseString ignoreCaseString = new IgnoreCaseString("Phone");
        String string = "phone";
        System.out.println(ignoreCaseString.equals(string));
        System.out.println(string.equals(ignoreCaseString));
        System.out.println("------------------------------");
        List<String> list = new ArrayList<>();
        list.add(string);
        System.out.println(list.contains(ignoreCaseString));
    }
}
