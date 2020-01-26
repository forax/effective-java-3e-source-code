package effectivejava.chapter6.item39.markerannotation;

// Program to process marker annotations (Page 182)

import java.lang.reflect.*;

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
        }
        System.out.printf("Passed: %d, Failed: %d%n",
                passed, tests - passed);
    }
}
