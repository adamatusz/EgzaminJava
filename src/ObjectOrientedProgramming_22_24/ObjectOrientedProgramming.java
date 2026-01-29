/*
    Pytanie 22:
    Klasy niezmienne (Immutable) Obiekty, których stanu nie można zmienić po utworzeniu.
    Wymagają: klasy final, pól private final, braku setterów i inicjalizacji w konstruktorze.

    Pytanie 24:
    Przeciążanie kontra Przesłanianie
    Przeciążanie (Overloading): Ta sama nazwa, inne parametry (w tej samej klasie).
    Przesłanianie (Overriding): Ta sama sygnatura, zmiana implementacji w klasie dziedziczącej (wymaga @Override).
*/

package ObjectOrientedProgramming_22_24;

public class ObjectOrientedProgramming {

    // 1. Klasa niezmienna (Immutable)
    // Dodajemy 'static', aby można jej było używać w main bez tworzenia obiektu klasy głównej
    static final class ImmutablePerson {
        private final String name; // [cite: 307]

        public ImmutablePerson(String name) {
            this.name = name;
        }

        public String getName() { return name; }
        // Brak setterów! [cite: 302]
        public ImmutablePerson withName(String noweImie) {
            return new ImmutablePerson(noweImie);
        }
    }

    // 2. Klasa bazowa
    static class Zwierze {
        void dajGlos() {
            System.out.println("..." );
        }
    }

    // 3. Dziedziczenie
    static class Pies extends Zwierze {
        // Przesłanianie (Overriding) [cite: 329]
        @Override
        void dajGlos() { System.out.println("Hau!"); }

        // Przeciążanie (Overloading) - inna liczba argumentów [cite: 328]
        void dajGlos(int razy) {
            for(int i=0; i<razy; i++) {
                System.out.print("Hau! ");
            }
             System.out.println(); // Czytelniejsze formatowanie po pętli
        }
    }

    // Metoda main bezpośrednio w klasie głównej
    public static void main(String[] args) {
        // Testowanie dziedziczenia i polimorfizmu
        Pies burek = new Pies();
        Zwierze burek2 = new Pies();
        Pies burek3 = new Pies();


        System.out.print("Zwykłe szczekanie: ");
        burek.dajGlos();      // Wywoła przesłoniętą metodę

        System.out.print("Wielokrotne szczekanie: ");
        burek.dajGlos(3);     // Wywoła przeciążoną metodę
        System.out.print("Zwierzę: ");
        burek2.dajGlos();
        // RZUTOWANIE (Casting) - Zmieniamy pilota na chwilę
        System.out.print("Zwierzę, które na bank jest psem: ");
        ((Pies) burek2).dajGlos(10);
        System.out.print("burek3: ");
        burek3.dajGlos();

        // Testowanie klasy niezmiennej
        ImmutablePerson osoba = new ImmutablePerson("Agnieszka");
        System.out.println("Osoba immutable: " + osoba.getName());
        ImmutablePerson withName = new ImmutablePerson("Teresa");
        System.out.println("Osoba immutable2: " + withName.getName());
        }

    }