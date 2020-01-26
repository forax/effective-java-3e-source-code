package effectivejava.chapter9.item65;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Set;

// Reflective instantiaion demo (Page 283)
public class ReflectiveInstantiation {
    // Reflective instantiation with interface access
    public static void main(String[] args) {
        // Translate the class name into a Class object
        Class<? extends Set<String>> cl;
        try {
            cl = (Class<? extends Set<String>>)  // Unchecked cast!
                    Class.forName(args[0]);
        } catch (ClassNotFoundException e) {
            throw fatalError("Class not found.");
        }

        // Get the constructor
        Constructor<? extends Set<String>> cons;
        try {
            cons = cl.getDeclaredConstructor();
        } catch (NoSuchMethodException e) {
            throw fatalError("No parameterless constructor");
        }

        // Instantiate the set
        Set<String> s;
        try {
            s = cons.newInstance();
        } catch (IllegalAccessException e) {
            throw fatalError("Constructor not accessible");
        } catch (InstantiationException e) {
            throw fatalError("Class not instantiable.");
        } catch (InvocationTargetException e) {
            throw fatalError("Constructor threw " + e.getCause());
        } catch (ClassCastException e) {
            throw fatalError("Class doesn't implement Set");
        }

        // Exercise the set
        s.addAll(Arrays.asList(args).subList(1, args.length));
        System.out.println(s);
    }

    private static Error fatalError(String msg) {
        System.err.println(msg);
        System.exit(1);
        return new AssertionError(msg);
    }
}
