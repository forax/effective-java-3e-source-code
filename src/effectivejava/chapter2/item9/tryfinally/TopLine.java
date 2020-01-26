package effectivejava.chapter2.item9.tryfinally;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class TopLine {
    // try-finally - No longer the best way to close resources! (page 34)
    static String firstLineOfFile(Path path) throws IOException {
        var reader = Files.newBufferedReader(path);
        try {
            return reader.readLine();
        } finally {
            reader.close();
        }
    }

    public static void main(String[] args) throws IOException {
        var path = Path.of(args[0]);
        System.out.println(firstLineOfFile(path));
    }
}
