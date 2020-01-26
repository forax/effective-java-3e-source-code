package effectivejava.chapter5.item32;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

// Safe version of PickTwo using lists instead of arrays (Page 150)
public class SafePickTwo {
    static <T> List<T> pickTwo(T a, T b, T c) {
        return switch(ThreadLocalRandom.current().nextInt(3)) {
            case 0 -> List.of(a, b);
            case 1 -> List.of(a, c);
            case 2 -> List.of(b, c);
            default -> throw new AssertionError();
        };
    }

    public static void main(String[] args) {
        var attributes = pickTwo("Good", "Fast", "Cheap");
        System.out.println(attributes);
    }
}
