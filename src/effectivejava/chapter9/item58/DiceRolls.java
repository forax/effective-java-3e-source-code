package effectivejava.chapter9.item58;
import java.util.*;

// Same bug as NestIteration.java (but different symptom)!! - Page 213
public class DiceRolls {
    enum Face { ONE, TWO, THREE, FOUR, FIVE, SIX }

    public static void main(String[] args) {
        // Same bug, different symptom!
        var faces = EnumSet.allOf(Face.class);

        for (var i = faces.iterator(); i.hasNext(); )
            for (var j = faces.iterator(); j.hasNext(); )
                System.out.println(i.next() + " " + j.next());

        System.out.println("***************************");

        for (var face1 : faces)
            for (var face2 : faces)
                System.out.println(face1 + " " + face2);
    }
}
