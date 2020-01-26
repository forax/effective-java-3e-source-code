package effectivejava.chapter3.item10.inheritance;
import effectivejava.chapter3.item10.Point;

import java.util.*;

// Test program that uses CounterPoint as Point
public class CounterPointTest {
    // Initialize unitCircle to contain all Points on the unit circle  (Page 43)
    private static final Set<Point> UNIT_CIRCLE = Set.of(
            new Point( 1,  0), new Point( 0,  1),
            new Point(-1,  0), new Point( 0, -1));

    public static boolean onUnitCircle(Point p) {
        return UNIT_CIRCLE.contains(p);
    }

    public static void main(String[] args) {
        var p1 = new Point(1,  0);
        var p2 = new CounterPoint(1,  0);

        // Prints true
        System.out.println(onUnitCircle(p1));

        // Should print true, but doesn't if Point uses getClass-based equals
        System.out.println(onUnitCircle(p2));
    }
}
