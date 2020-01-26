package effectivejava.chapter3.item10;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

// Broken - violates symmetry!  (Page 39)
public final class CaseInsensitiveString {
    private final String s;

    public CaseInsensitiveString(String s) {
        this.s = Objects.requireNonNull(s);
    }

    // Broken - violates symmetry!
    @Override public boolean equals(Object o) {
        if (o instanceof CaseInsensitiveString cis)
            return s.equalsIgnoreCase(cis.s);
        if (o instanceof String s2)  // One-way interoperability!
            return s.equalsIgnoreCase(s2);
        return false;
    }

    // Demonstration of the problem (Page 40)
    public static void main(String[] args) {
        var cis = new CaseInsensitiveString("Polish");
        var string = "polish";

        var list = List.of(cis);

        System.out.println(list.contains(string));
    }

//    // Fixed equals method (Page 40)
//    @Override public boolean equals(Object o) {
//        return o instanceof CaseInsensitiveString cis &&
//                cis.s.equalsIgnoreCase(s);
//    }
}
