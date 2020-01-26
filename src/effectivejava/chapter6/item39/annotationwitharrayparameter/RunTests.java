package effectivejava.chapter6.item39.annotationwitharrayparameter;
import effectivejava.chapter6.item39.markerannotation.Test;

import java.lang.reflect.*;

// Program to process marker annotations and annotations with array parameter (Page 185)
public class RunTests {
    public static void main(String[] args) throws Exception {
        var tests = 0;
        var passed = 0;
        var testClass = Class.forName(args[0]);
        for (var m : testClass.getDeclaredMethods()) {
            if (m.isAnnotationPresent(Test.class)) {
                tests++;
                try {
                    m.invoke(null);
                    passed++;
                } catch (InvocationTargetException wrappedExc) {
                    Throwable cause = wrappedExc.getCause();
                    System.out.println(m + " failed: " + cause);
                } catch (Exception exc) {
                    System.out.println("Invalid @Test: " + m);
                }
            }

            // Code to process annotations with array parameter (Page 185)
            if (m.isAnnotationPresent(ExceptionTest.class)) {
                tests++;
                try {
                    m.invoke(null);
                    System.out.printf("Test %s failed: no exception%n", m);
                } catch (Throwable wrappedExc) {
                    Throwable cause = wrappedExc.getCause();
                    var oldPassed = passed;
                    var excTypes =
                            m.getAnnotation(ExceptionTest.class).value();
                    for (var excType : excTypes) {
                        if (excType.isInstance(cause)) {
                            passed++;
                            break;
                        }
                    }
                    if (passed == oldPassed)
                        System.out.printf("Test %s failed: %s %n", m, cause);
                }
            }
        }
        System.out.printf("Passed: %d, Failed: %d%n",
                passed, tests - passed);
    }
}
