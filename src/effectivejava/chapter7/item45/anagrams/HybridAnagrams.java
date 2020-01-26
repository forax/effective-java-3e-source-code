package effectivejava.chapter7.item45.anagrams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;

// Tasteful use of streams enhances clarity and conciseness (Page 205)
public class HybridAnagrams {
    public static void main(String[] args) throws IOException {
        var dictionary = Path.of(args[0]);
        var minGroupSize = Integer.parseInt(args[1]);

        try (var words = Files.lines(dictionary)) {
            words.collect(groupingBy(word -> alphabetize(word)))
                    .values().stream()
                    .filter(group -> group.size() >= minGroupSize)
                    .forEach(g -> System.out.println(g.size() + ": " + g));
        }
    }

    private static String alphabetize(String s) {
        var array = s.toCharArray();
        Arrays.sort(array);
        return new String(array);
    }
}
