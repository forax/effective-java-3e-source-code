package effectivejava.chapter8.item52;
import java.util.*;

// What does this program print? (Page 241)
public class SetList {
    public static void main(String[] args) {
        var set = new TreeSet<Integer>();
        var list = new ArrayList<Integer>();

        for (var i = -3; i < 3; i++) {
            set.add(i);
            list.add(i);
        }
        for (var i = 0; i < 3; i++) {
            set.remove(i);
            list.remove(i);
        }
        System.out.println(set + " " + list);
    }
}
