package effectivejava.chapter2.item2.telescopingconstructor;

// Telescoping constructor pattern - does not scale well! (Pages 10-11)
public record NutritionFacts(int servingSize, int servings, int calories, int fat, int sodium, int carbohydrate) {
    public NutritionFacts(int servingSize, int servings) {
        this(servingSize, servings, 0);
    }

    public NutritionFacts(int servingSize, int servings,
                          int calories) {
        this(servingSize, servings, calories, 0);
    }

    public NutritionFacts(int servingSize, int servings,
                          int calories, int fat) {
        this(servingSize, servings, calories, fat, 0);
    }

    public NutritionFacts(int servingSize, int servings,
                          int calories, int fat, int sodium) {
        this(servingSize, servings, calories, fat, sodium, 0);
    }

    public static void main(String[] args) {
        var cocaCola =
                new NutritionFacts(240, 8, 100, 0, 35, 27);
    }
    
}