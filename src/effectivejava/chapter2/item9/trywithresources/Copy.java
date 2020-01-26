package effectivejava.chapter2.item9.trywithresources;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class Copy {
    // try-with-resources on multiple resources - short and sweet (Page 35)
    static void copy(Path src, Path dst) throws IOException {
        try (var in = Files.newInputStream(src);
             var out = Files.newOutputStream(dst)) {
            in.transferTo(out);
        }
    }

    public static void main(String[] args) throws IOException {
        var src = Path.of(args[0]);
        var dst = Path.of(args[1]);
        copy(src, dst);
    }
}
