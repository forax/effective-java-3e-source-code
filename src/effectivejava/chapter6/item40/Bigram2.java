package effectivejava.chapter6.item40;

import java.util.HashSet;
import java.util.Set;

// Fixed Bigram class (Page 189)
public record Bigram2(char first, char second) {
    public static void main(String[] args) {
        var set = new HashSet<Bigram2>();
        for (var i = 0; i < 10; i++)
            for (var ch = 'a'; ch <= 'z'; ch++)
                set.add(new Bigram2(ch, ch));
        System.out.println(set.size());
    }
}
