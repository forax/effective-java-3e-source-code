package effectivejava.chapter5.item33;
import java.lang.annotation.*;
import java.lang.reflect.*;

// Use of asSubclass to safely cast to a bounded type token (Page 155)
public class PrintAnnotation {
    static Annotation getAnnotation(AnnotatedElement element,
                                    String annotationTypeName) {
        Class<?> annotationType; // Unbounded type token
        try {
            annotationType = Class.forName(annotationTypeName);
        } catch (ClassNotFoundException ex) {
            throw new IllegalArgumentException(ex);
        }
        return element.getAnnotation(
                annotationType.asSubclass(Annotation.class));
    }

    // Test program to print named annotation of named class
    public static void main(String[] args) throws Exception {
        if (args.length != 2) {
            System.out.println(
                "Usage: java PrintAnnotation <class> <annotation>");
            System.exit(1);
        }
        var className = args[0];
        var annotationTypeName = args[1];
        var klass = Class.forName(className);
        System.out.println(getAnnotation(klass, annotationTypeName));
    }
}
