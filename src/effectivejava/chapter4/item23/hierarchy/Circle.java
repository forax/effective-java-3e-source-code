package effectivejava.chapter4.item23.hierarchy;

// Class hierarchy replacement for a tagged class  (Page 110-11)
record Circle(double radius) implements Figure {
    @Override public double area() { return Math.PI * (radius * radius); }
}
