package effectivejava.chapter2.item2.hierarchicalbuilder;

import java.util.Collections;
import java.util.Set;

// Subtype with hierarchical builder (Page 15)
public record Calzone(Set<Topping>toppings, boolean sauceInside) implements Pizza {
    public static class Builder extends Pizza.Builder<Builder> {
        private boolean sauceInside = false; // Default

        public Builder sauceInside() {
            sauceInside = true;
            return this;
        }

        @Override public Calzone build() {
            return new Calzone(this);
        }

        @Override Builder self() { return this; }
    }

    private Calzone(Builder builder) {
        this(builder.toppings.clone(), builder.sauceInside);
    }

    public Set<Topping> toppings() {
        return Collections.unmodifiableSet(toppings);
    }
}
