package effectivejava.chapter6.item37;
import java.util.*;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

// Using a nested EnumMap to associate data with enum pairs - (Pages 174-5)
public enum Phase {
    SOLID, LIQUID, GAS;
    public enum Transition {
        MELT(SOLID, LIQUID), FREEZE(LIQUID, SOLID),
        BOIL(LIQUID, GAS), CONDENSE(GAS, LIQUID),
        SUBLIME(SOLID, GAS), DEPOSIT(GAS, SOLID);

//        // Adding a new phase (Page 175)
//        SOLID, LIQUID, GAS, PLASMA;
//        public enum Transition {
//            MELT(SOLID, LIQUID), FREEZE(LIQUID, SOLID),
//            BOIL(LIQUID, GAS), CONDENSE(GAS, LIQUID),
//            SUBLIME(SOLID, GAS), DEPOSIT(GAS, SOLID),
//            IONIZE(GAS, PLASMA), DEIONIZE(PLASMA, GAS);

        private final Phase from;
        private final Phase to;
        Transition(Phase from, Phase to) {
            this.from = from;
            this.to = to;
        }

        // Initialize the phase transition map
        private static final Map<Phase, Map<Phase, Transition>>
                m = Stream.of(values()).collect(groupingBy(t -> t.from,
                () -> new EnumMap<>(Phase.class),
                toMap(t -> t.to, t -> t,
                        (x, y) -> y, () -> new EnumMap<>(Phase.class))));
        
        public static Optional<Transition> from(Phase from, Phase to) {
            return Optional.ofNullable(m.get(from).get(to));
        }
    }

    // Simple demo program - prints a sloppy table
    public static void main(String[] args) {
        for (var src : Phase.values()) {
            for (var dst : Phase.values()) {
                var transition = Transition.from(src, dst);
                transition.ifPresent(t -> System.out.printf("%s to %s : %s %n", src, dst, t));
            }
        }
    }
}
