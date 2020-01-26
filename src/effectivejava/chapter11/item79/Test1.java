package effectivejava.chapter11.item79;
import java.util.*;

// Simple test of ObservableSet - Page 318
public class Test1 {
    public static void main(String[] args) {
        var set =
                new ObservableSet<>(new HashSet<Integer>());

        set.addObserver((s, e) -> System.out.println(e));

        for (var i = 0; i < 100; i++)
            set.add(i);
    }
}
