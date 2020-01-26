package effectivejava.chapter6.item39.annotationwitharrayparameter;

import java.util.*;

// Program containing an annotation with an array parameter (Page 185)
public class Sample3 {
    // This variant can process annotations whose parameter is a single element (identical to those on page 183)
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

    // Code containing an annotation with an array parameter (Page 185)
    @ExceptionTest({ IndexOutOfBoundsException.class,
                     NullPointerException.class })
    public static void doublyBad() {   // Should pass
        var list = new ArrayList<String>();

        // The spec permits this method to throw either
        // IndexOutOfBoundsException or NullPointerException
        list.addAll(5, null);
    }
}
