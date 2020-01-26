package effectivejava.chapter3.item14;
import java.util.*;

// The benefits of implementing Comparable (Page 66)
public class WordList {
    public static void main(String[] args) {
        var set = new TreeSet<String>();
        Collections.addAll(set, args);
        System.out.println(set);
    }
}
