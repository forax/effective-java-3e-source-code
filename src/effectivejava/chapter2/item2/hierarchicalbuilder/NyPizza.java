package effectivejava.chapter2.item2.hierarchicalbuilder;

import java.util.Objects;
import java.util.Set;

// Subtype with hierarchical builder (Page 15)
public record NyPizza(Set<Topping>toppings, Size size) implements Pizza {
    public enum Size { SMALL, MEDIUM, LARGE }

    public static class Builder extends Pizza.Builder<Builder> {
        private final Size size;

        public Builder(Size size) {
            this.size = Objects.requireNonNull(size);
        }

        @Override public NyPizza build() {
            return new NyPizza(this);
        }

        @Override Builder self() { return this; }
    }

    private NyPizza(Builder builder) {
        this(builder.toppings.clone(), builder.size);
    }
}
