package effectivejava.chapter2.item9.tryfinally;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class Copy {
    // try-finally is ugly when used with more than one resource! (Page 34)
    static void copy(Path src, Path dst) throws IOException {
        var in = Files.newInputStream(src);
        try {
            var out = Files.newOutputStream(dst);
            try {
                in.transferTo(out);
            } finally {
                out.close();
            }
        } finally {
            in.close();
        }
    }

    public static void main(String[] args) throws IOException {
        var src = Path.of(args[0]);
        var dst = Path.of(args[1]);
        copy(src, dst);
    }
}
