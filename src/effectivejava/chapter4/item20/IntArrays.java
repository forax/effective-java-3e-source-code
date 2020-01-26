package effectivejava.chapter4.item20;
import java.util.*;

// Concrete implementation built atop skeletal implementation (Page 101)
public class IntArrays {
    static List<Integer> intArrayAsList(int[] a) {
        Objects.requireNonNull(a);

        // The diamond operator is only legal here in Java 9 and later
        // If you're using an earlier release, specify <Integer>
        return new AbstractList<>() {
            @Override public Integer get(int i) {
                return a[i];  // Autoboxing (Item 6)
            }

            @Override public Integer set(int i, Integer val) {
                int oldVal = a[i];
                a[i] = val;     // Auto-unboxing
                return oldVal;  // Autoboxing
            }

            @Override public int size() {
                return a.length;
            }
        };
    }

    public static void main(String[] args) {
        var array = new int[10];
        for (var i = 0; i < array.length; i++)
            array[i] = i;

       var list = intArrayAsList(array);
        Collections.shuffle(list);
        System.out.println(list);
    }
}
