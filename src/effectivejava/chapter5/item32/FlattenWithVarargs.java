package effectivejava.chapter5.item32;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

// Safe method with a generic varargs parameter (page 149)
public class FlattenWithVarargs {
    @SafeVarargs
    static <T> List<T> flatten(List<? extends T>... lists) {
        // var result = new ArrayList<T>();
        // for (var list : lists)
        //     result.addAll(list);
        // return result;

        // using a stream
        return Arrays.stream(lists).flatMap(List::stream).collect(toList());
    }

    public static void main(String[] args) {
        var flatList = flatten(
                List.of(1, 2), List.of(3, 4, 5), List.of(6,7));
        System.out.println(flatList);
    }
}
