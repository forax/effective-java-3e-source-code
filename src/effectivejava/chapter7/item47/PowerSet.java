package effectivejava.chapter7.item47;

import java.util.*;

public class PowerSet {
    // Returns the power set of an input set as custom collection (Page 218)
    public static <E> Collection<Set<E>> of(Set<E> set) {
        if (set.size() > 30)
            throw new IllegalArgumentException("Set too big " + set);
        var src = List.copyOf(set);
        return new AbstractList<>() {
            @Override public int size() {
                return 1 << src.size(); // 2 to the power srcSize
            }

            @Override public boolean contains(Object o) {
                return o instanceof Set<?> set && src.containsAll(set);
            }

            @Override public Set<E> get(int index) {
                var result = new HashSet<E>();
                for (var i = 0; index != 0; i++, index >>= 1)
                    if ((index & 1) == 1)
                        result.add(src.get(i));
                return result;
            }
        };
    }

    public static void main(String[] args) {
        var set = Set.of(args);
        System.out.println(PowerSet.of(set));
    }
}