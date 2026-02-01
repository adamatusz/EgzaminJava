package TypyDanych_1_7;

public class TypyDanych { // <--- To jest DEFINICJA KLASY

    // (TUTAJ byłoby miejsce na pola klasy, gdybyś je miał - np. private int liczba;)
    // (TUTAJ byłoby miejsce na KONSTRUKTOR, gdybyś go napisał)

    // ▼▼▼ To jest METODA (konkretnie metoda startowa "main") ▼▼▼
    public static void main(String[] args) {

        // ▼▼▼ To są ZMIENNE (Typ + Nazwa = Wartość) ▼▼▼
        int $value = 5;      // Typ: int, Nazwa: $value

        System.out.println("stPlace: " + $value); // Wywołanie innej metody (println)
        System.out.println("Math: " + 1 + 1);
        System.out.println("Glue(Concatenation): " + "1" + "1");

        int maly = 100;      // Typ: int, Nazwa: maly
        double duzy = maly;  // Typ: double, Nazwa: duzy
        System.out.println("Widening: " + duzy);

        double precyzyjny = 9.99; // Typ: double, Nazwa: precyzyjny
        System.out.println("Precyzyjne: " + precyzyjny);

        int uciety = (int) precyzyjny; // Typ: int, Nazwa: uciety
        System.out.println("Narrowing: " + uciety);
    } // ▲▲▲ Koniec metody main
}
