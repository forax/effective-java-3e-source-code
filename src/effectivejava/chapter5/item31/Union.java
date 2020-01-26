package effectivejava.chapter5.item31;
import java.util.*;

// Generic union method with wildcard types for enhanced flexibility (Pages 142-3)
public class Union {
    public static <E> Set<E> union(Set<? extends E> s1,
                                   Set<? extends E> s2) {
        var result = new HashSet<E>(s1);
        result.addAll(s2);
        return result;
    }

    // Simple program to exercise flexible generic staticfactory
    public static void main(String[] args) {
        var integers = new HashSet<Integer>();
        integers.add(1); 
        integers.add(3); 
        integers.add(5); 

        var doubles =  new HashSet<Double>();
        doubles.add(2.0); 
        doubles.add(4.0); 
        doubles.add(6.0); 

        Set<Number> numbers = union(integers, doubles);

//      // Explicit type parameter - required prior to Java 8
//      Set<Number> numbers = Union.<Number>union(integers, doubles);

//     // Using var since Java 10
//     var numbers = union(integers, doubles);

        System.out.println(numbers);
    }
}
