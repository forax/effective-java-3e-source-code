package effectivejava.chapter2.item9.trywithresources;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class TopLine {
    // try-with-resources - the the best way to close resources!  (Page 35)
    static String firstLineOfFile(Path path) throws IOException {
        try (var reader = Files.newBufferedReader(path)) {
            return reader.readLine();
        }
    }

    public static void main(String[] args) throws IOException {
        var path = Path.of(args[0]);
        System.out.println(firstLineOfFile(path));
    }
}
