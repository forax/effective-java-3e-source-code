package effectivejava.chapter3.item10.composition;

import effectivejava.chapter3.item10.Color;
import effectivejava.chapter3.item10.Point;

import java.util.Objects;

// Adds a value component without violating the equals contract (page 44)
public record ColorPoint(Point point, Color color) {
    public ColorPoint {
        Objects.requireNonNull(point);
        Objects.requireNonNull(color);
    }

    public ColorPoint(int x, int y, Color color) {
        this(new Point(x, y), color);
    }

    /**
     * Returns the point-view of this color point.
     */
    public Point asPoint() {
        return point;
    }

    // not necessary, it's a record
    @Override public boolean equals(Object o) {
        return o instanceof ColorPoint cp && cp.point.equals(point) && cp.color == color;
    }

    // not necessary, it's a record
    @Override public int hashCode() {
        return 31 * point.hashCode() + color.hashCode();
    }
}