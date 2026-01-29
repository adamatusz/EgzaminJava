package TypyDanych_1_7;

public class TypyDanych {
    public static void main(String[] args) {
        int $value = 5;
        // 1. Math vs Glue (String)
        System.out.println("stPlace: " + $value);
        System.out.println("Math: " + 1 + 1);       // Math
        System.out.println("Glue(Concatenation): " + "1" + "1");   // Glue (Concatenation)

        // 2. Widening (Automatic: int -> double)
        int maly = 100;
        double duzy = maly; // No special code needed!
        System.out.println("Widening: " + duzy);

        // 3. Narrowing (Manual: double -> int)
        double precyzyjny = 9.99;
        // We must Force it with (int)
        int uciety = (int) precyzyjny;
        System.out.println("Narrowing: " + uciety);
    }
}
