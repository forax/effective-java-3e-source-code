package effectivejava.chapter2.item2.hierarchicalbuilder;
import java.util.*;

// Builder pattern for class hierarchies (Page 14)

// Note that the underlying "simulated self-type" idiom  allows for arbitrary fluid hierarchies, not just builders

public interface Pizza {
    public enum Topping { HAM, MUSHROOM, ONION, PEPPER, SAUSAGE }

    /*private*/ abstract static class Builder<T extends Builder<T>> {
        final EnumSet<Topping> toppings = EnumSet.noneOf(Topping.class);
        public T addTopping(Topping topping) {
            Objects.requireNonNull(topping);
            toppings.add(topping);
            return self();
        }

        abstract Pizza build();

        // Subclasses must override this method to return "this"
        abstract T self();
    }

    Set<Topping> toppings();
}
