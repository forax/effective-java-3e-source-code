package effectivejava.chapter8.item50;

import java.util.*;

// Broken "immutable" time period class (Pages 231-3)
public record Period(Date start, Date end) {

    /**
     * @param  start the beginning of the period
     * @param  end the end of the period; must not precede start
     * @throws IllegalArgumentException if start is after end
     * @throws NullPointerException if start or end is null
     */
    public Period {
        if (start.compareTo(end) > 0)
            throw new IllegalArgumentException(
                    start + " after " + end);
    }

//    public Date start() {
//        return start;
//    }
//    public Date end() {
//        return end;
//    }

    public String toString() {
        return start + " - " + end;
    }

//    // Repaired constructor - makes defensive copies of parameters (Page 232)
//    public Period {
//        this.start = new Date(start.getTime());
//        this.end   = new Date(end.getTime());
//
//        if (this.start.compareTo(this.end) > 0)
//            throw new IllegalArgumentException(
//                    this.start + " after " + this.end);
//    }
//
//    // Repaired accessors - make defensive copies of internal fields (Page 233)
//    public Date start() {
//        return new Date(start.getTime());
//    }
//
//    public Date end() {
//        return new Date(end.getTime());
//    }

    // Remainder omitted
}