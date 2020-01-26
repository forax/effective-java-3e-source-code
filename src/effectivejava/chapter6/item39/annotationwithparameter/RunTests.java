package effectivejava.chapter6.item39.annotationwithparameter;

import effectivejava.chapter6.item39.markerannotation.Test;
import java.lang.reflect.*;

// Program to process marker annotations and annotations with a parameter (Page 184)
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
                    var cause = wrappedExc.getCause();
                    System.out.println(m + " failed: " + cause);
                } catch (Exception exc) {
                    System.out.println("Invalid @Test: " + m);
                }
            }

            if (m.isAnnotationPresent(ExceptionTest.class)) {
                tests++;
                try {
                    m.invoke(null);
                    System.out.printf("Test %s failed: no exception%n", m);
                } catch (InvocationTargetException wrappedEx) {
                    var cause = wrappedEx.getCause();
                    var excType =
                            m.getAnnotation(ExceptionTest.class).value();
                    if (excType.isInstance(cause)) {
                        passed++;
                    } else {
                        System.out.printf(
                                "Test %s failed: expected %s, got %s%n",
                                m, excType.getName(), cause);
                    }
                } catch (Exception exc) {
                    System.out.println("Invalid @ExceptionTest: " + m);
                }
            }
        }

        System.out.printf("Passed: %d, Failed: %d%n",
                passed, tests - passed);
    }
}
