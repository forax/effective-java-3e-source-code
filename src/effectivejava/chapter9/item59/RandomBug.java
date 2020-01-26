package effectivejava.chapter9.item59;
import java.util.*;

// Random number generation is hard! - Page 215
public class RandomBug {
    // Common but deeply flawed!
    static final Random rnd = new Random();

    static int random(int n) {
        return Math.abs(rnd.nextInt()) % n;
    }

    public static void main(String[] args) {
        var n = 2 * (Integer.MAX_VALUE / 3);
        var low = 0;
        for (var i = 0; i < 1_000_000; i++)
            if (random(n) < n/2)
                low++;
        System.out.println(low);
    }
}
