package effectivejava.chapter7.item45.anagrams;

import java.io.IOException;
import java.nio.file.Path;
import java.util.*;

// Prints all large anagram groups in a dictionary iteratively (Page 204)
public class IterativeAnagrams {
    public static void main(String[] args) throws IOException {
        var dictionary = Path.of(args[0]);
        var minGroupSize = Integer.parseInt(args[1]);

        var groups = new HashMap<String, Set<String>>();
        try (var scanner = new Scanner(dictionary)) {
            while (scanner.hasNext()) {
                var word = scanner.next();
                groups.computeIfAbsent(alphabetize(word),
                        (unused) -> new TreeSet<>()).add(word);
            }
        }

        for (var group : groups.values())
            if (group.size() >= minGroupSize)
                System.out.println(group.size() + ": " + group);
    }

    private static String alphabetize(String s) {
        var array = s.toCharArray();
        Arrays.sort(array);
        return new String(array);
    }
}
