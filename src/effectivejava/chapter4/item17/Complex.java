package effectivejava.chapter4.item17;

// Immutable complex number class (Pages 81-82)
public record Complex(double realPart/*realPart*/, double imaginaryPart) {
    public static final Complex ZERO = new Complex(0, 0);
    public static final Complex ONE  = new Complex(1, 0);
    public static final Complex I    = new Complex(0, 1);

    public Complex plus(Complex c) {
        return new Complex(realPart + c.realPart, imaginaryPart + c.imaginaryPart);
    }

    // Static factory, used in conjunction with private constructor (Page 85)
    public static Complex valueOf(double re, double im) {
        return new Complex(re, im);
    }

    public Complex minus(Complex c) {
        return new Complex(realPart - c.realPart, imaginaryPart - c.imaginaryPart);
    }

    public Complex times(Complex c) {
        return new Complex(realPart * c.realPart - imaginaryPart * c.imaginaryPart,
                realPart * c.imaginaryPart + imaginaryPart * c.realPart);
    }

    public Complex dividedBy(Complex c) {
        var tmp = c.realPart * c.realPart + c.imaginaryPart * c.imaginaryPart;
        return new Complex((realPart * c.realPart + imaginaryPart * c.imaginaryPart) / tmp,
                (imaginaryPart * c.realPart - realPart * c.imaginaryPart) / tmp);
    }

    /* Unnecessary it's a record
    @Override public boolean equals(Object o) {
        if (o == this)
            return true;
        // See page 47 to find out why we use compare instead of ==
        return o instanceof Complex c
            && Double.compare(c.realPart, realPart) == 0
                && Double.compare(c.imaginaryPart, imaginaryPart) == 0;
    }
    @Override public int hashCode() {
        return 31 * Double.hashCode(realPart) + Double.hashCode(imaginaryPart);
    }*/

    @Override public String toString() {
        return "(" + realPart + " + " + imaginaryPart + "i)";
    }
}
