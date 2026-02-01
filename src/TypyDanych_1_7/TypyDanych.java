package TypyDanych_1_7;

// Definicja szablonu
class TypyDanych {
    // ▼▼▼ To jest POLE KLASY (Field / Instance Variable) ▼▼▼
    // Jest "przyklejone" do obiektu. Żyje tak długo, jak żyje obiekt.
    int $value = 5;
}

// Klasa uruchomieniowa
class Main {
    public static void main(String[] args) {

        // 1. Tworzymy obiekt (instancję) klasy TypyDanych
        TypyDanych obiekt = new TypyDanych();

        // 2. Sięgamy do jego wnętrza używając kropki
        System.out.println("stPlace: " + obiekt.$value);


        // ▼▼▼ To są ZMIENNE LOKALNE (Local Variables) ▼▼▼
        // Żyją tylko wewnątrz klamerek metody main { ... }

        System.out.println("Math: " + 1 + 1); // Uwaga: tutaj Java zrobi z tego tekst "11"!
        System.out.println("Glue(Concatenation): " + "1" + "1");

        int maly = 100;
        double duzy = maly;
        System.out.println("Widening: " + duzy);

        double precyzyjny = 9.99;
        System.out.println("Precyzyjne: " + precyzyjny);

        int uciety = (int) precyzyjny;
        System.out.println("Narrowing: " + uciety);
    }
}