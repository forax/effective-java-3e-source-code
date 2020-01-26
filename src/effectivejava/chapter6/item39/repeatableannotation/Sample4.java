package effectivejava.chapter6.item39.repeatableannotation;

import java.util.ArrayList;
import java.util.List;

// Program containing repeatable annotations (Page 186)
public class Sample4 {
    @ExceptionTest(ArithmeticException.class)
    public static void m1() {  // Test should pass
        var i = 0;
        i = i / i;
    }

    @ExceptionTest(ArithmeticException.class)
    public static void m2() {  // Should fail (wrong exception)
        var a = new int[0];
        var i = a[1];
    }

    @ExceptionTest(ArithmeticException.class)
    public static void m3() { }  // Should fail (no exception)

    // Code containing a repeated annotation (Page 186)
    @ExceptionTest(IndexOutOfBoundsException.class)
    @ExceptionTest(NullPointerException.class)
    public static void doublyBad() {
        var list = new ArrayList<String>();

        // The spec permits this staticfactory to throw either
        // IndexOutOfBoundsException or NullPointerException
        list.addAll(5, null);
    }
}
