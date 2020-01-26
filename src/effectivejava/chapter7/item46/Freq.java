package effectivejava.chapter7.item46;

import java.io.IOException;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Stream;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.*;
import static java.util.stream.Collectors.*;

// Frequency table examples showing improper and proper use of stream (Page 210-11)
public class Freq {
    public static void main(String[] args) throws IOException {
        var file = Path.of(args[0]);

//        // Uses the streams API but not the paradigm--Don't do this!
//        var freq = new HashMap<String, Long>();
//        try (var words = new Scanner(file).tokens()) {
//            words.forEach(word -> {
//                freq.merge(word.toLowerCase(), 1L, Long::sum);
//            });
//        }

        // Proper use of streams to initialize a frequency table (
        Map<String, Long> freq;
        try (var words = new Scanner(file).tokens()) {
            freq = words
                    .collect(groupingBy(String::toLowerCase, counting()));
        }

        System.out.println(freq);

        // Pipeline to get a top-ten list of words from a frequency table
        var topTen = freq.keySet().stream()
                .sorted(comparing(freq::get).reversed())
                .limit(10)
                .collect(toList());

        System.out.println(topTen);
    }
}
