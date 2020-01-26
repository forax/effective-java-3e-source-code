package effectivejava.chapter2.item9.trywithresources;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;

public class TopLineWithDefault {
    // try-with-resources with a catch clause  (Page 36)
    static Optional<String> firstLineOfFile(Path path) {
        try (var reader = Files.newBufferedReader(path)) {
            return Optional.of(reader.readLine());
        } catch (IOException e) {
            return Optional.empty();
        }
    }

    public static void main(String[] args) throws IOException {
        var path = Path.of(args[0]);
        System.out.println(firstLineOfFile(path).orElse("Toppy McTopFace"));
    }
}
