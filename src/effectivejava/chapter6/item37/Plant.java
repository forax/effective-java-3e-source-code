package effectivejava.chapter6.item37;
import java.util.*;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toSet;

// Using an EnumMap to associate data with an enum (Pages 171-3)

// Simplistic class representing a plant (Page 171)
record Plant(String name, LifeCycle lifeCycle) {
    enum LifeCycle { ANNUAL, PERENNIAL, BIENNIAL }

    public Plant {
        Objects.requireNonNull(name);
        Objects.requireNonNull(lifeCycle);
    }

    @Override public String toString() {
        return name;
    }

    public static void main(String[] args) {
        var garden = new Plant[] {
            new Plant("Basil",    LifeCycle.ANNUAL),
            new Plant("Carroway", LifeCycle.BIENNIAL),
            new Plant("Dill",     LifeCycle.ANNUAL),
            new Plant("Lavendar", LifeCycle.PERENNIAL),
            new Plant("Parsley",  LifeCycle.BIENNIAL),
            new Plant("Rosemary", LifeCycle.PERENNIAL)
        };

        // Using ordinal() to index into an array - DON'T DO THIS!  (Page 171)
        var plantsByLifeCycleArr =
                (Set<Plant>[]) new Set<?>[Plant.LifeCycle.values().length];
        Arrays.setAll(plantsByLifeCycleArr, __ -> new HashSet<>());
        for (var plant : garden)
            plantsByLifeCycleArr[plant.lifeCycle.ordinal()].add(plant);
        // Print the results
        for (int i = 0; i < plantsByLifeCycleArr.length; i++) {
            System.out.printf("%s: %s%n",
                    Plant.LifeCycle.values()[i], plantsByLifeCycleArr[i]);
        }

        // Using an EnumMap to associate data with an enum (Page 172)
        var plantsByLifeCycle =
                new EnumMap<Plant.LifeCycle, Set<Plant>>(Plant.LifeCycle.class);
        for (var plant : garden)
            plantsByLifeCycle.computeIfAbsent(plant.lifeCycle, __ -> new HashSet<>()).add(plant);
        System.out.println(plantsByLifeCycle);

        // Naive stream-based approach - unlikely to produce an EnumMap!  (Page 172)
        System.out.println(Arrays.stream(garden)
                .collect(groupingBy(p -> p.lifeCycle)));

        // Using a stream and an EnumMap to associate data with an enum (Page 173)
        System.out.println(Arrays.stream(garden)
                .collect(groupingBy(p -> p.lifeCycle,
                        () -> new EnumMap<>(LifeCycle.class), toSet())));
    }
}
