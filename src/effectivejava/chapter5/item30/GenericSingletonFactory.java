package effectivejava.chapter5.item30;

import java.util.function.UnaryOperator;

// Generic singleton factory pattern (Page 136-7)
public class GenericSingletonFactory {
    // Generic singleton factory pattern
    private static UnaryOperator<Object> IDENTITY_FN = t -> t;

    @SuppressWarnings("unchecked")
    public static <T> UnaryOperator<T> identityFunction() {
        return (UnaryOperator<T>) IDENTITY_FN;
    }

    // Sample program to exercise generic singleton
    public static void main(String[] args) {
        var strings = new String[] { "jute", "hemp", "nylon" };
        UnaryOperator<String> sameString = identityFunction();
        for (var s : strings)
            System.out.println(sameString.apply(s));

        var numbers = new Number[] { 1, 2.0, 3L };
        UnaryOperator<Number> sameNumber = identityFunction();
        for (var n : numbers)
            System.out.println(sameNumber.apply(n));
    }
}