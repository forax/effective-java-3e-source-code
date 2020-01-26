package effectivejava.chapter5.item30;
import java.util.*;

// Generic union method and program to exercise it  (Pages 135-6)
public class Union {

    // Generic method
    public static <E> Set<E> union(Set<E> s1, Set<E> s2) {
        var result = new HashSet<E>(s1);
        result.addAll(s2);
        return result;
    }

    // Simple program to exercise generic method
    public static void main(String[] args) {
        var guys = Set.of("Tom", "Dick", "Harry");
        var stooges = Set.of("Larry", "Moe", "Curly");
        var aflCio = union(guys, stooges);
        System.out.println(aflCio);
    }
}
