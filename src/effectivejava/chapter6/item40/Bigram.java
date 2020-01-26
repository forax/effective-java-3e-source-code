package effectivejava.chapter6.item40;
import java.util.*;

// Can you spot the bug? (Page 188)
public class Bigram {
    private final char first;
    private final char second;

    public Bigram(char first, char second) {
        this.first  = first;
        this.second = second;
    }

    public boolean equals(Bigram b) {
        return b.first == first && b.second == second;
    }

    public int hashCode() {
        return 31 * first + second;
    }

    public static void main(String[] args) {
        var set = new HashSet<Bigram>();
        for (var i = 0; i < 10; i++)
            for (var ch = 'a'; ch <= 'z'; ch++)
                set.add(new Bigram(ch, ch));
        System.out.println(set.size());
    }
}
