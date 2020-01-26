package effectivejava.chapter6.item34;

// Takes earth-weight and prints table of weights on all planets (Page 160)
public class WeightTable {
   public static void main(String[] args) {
      var earthWeight = Double.parseDouble(args[0]);
      var mass = earthWeight / Planet.EARTH.surfaceGravity();
      for (var planet : Planet.values())
         System.out.printf("Weight on %s is %f%n",
                 planet, planet.surfaceWeight(mass));
   }
}
