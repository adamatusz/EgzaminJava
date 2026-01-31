/*
    30. Czym jest interfejs? Jakie są jego własności?
    31.	Czym różni się klasa abstrakcyjna od interfejsu?
    10. Jakie są róznice między equals(), a "=="
*/

package ZooProject_30_31;

import javax.swing.plaf.synth.SynthLookAndFeel;

// 1. KLASA ABSTRAKCYJNA
// Nie można zrobić: new Zwierze();
abstract class Zwierze {
    String imie;

    // Konstruktor w klasie abstrakcyjnej? TAK!
    // Służy do inicjalizowania pól, gdy tworzymy Psa lub Kota.
    public Zwierze(String imie) {
        this.imie = imie;
    }

    // 2. METODA ABSTRAKCYJNA
    // Nie ma klamerek { body }, ma średnik ;
    // Tłumaczenie: "Każde dziecko MUSI napisać własną wersję tej metody"
    abstract void dajGlos();

    @Override
    public boolean equals(Object o) {
        // 1. Jeśli to ten sam adres w pamięci -> TRUE
        if (this == o) return true;

        // 2. Jeśli porównujemy z nullem lub inną klasą -> FALSE
        if (o == null || getClass() != o.getClass()) return false;

        // 3. Rzutowanie na Zwierze, żeby dostać się do pola 'imie'
        Zwierze zwierze = (Zwierze) o;

        // 4. Porównanie imion (String ma już swoje gotowe equals!)
        return imie.equals(zwierze.imie);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(imie);
    }

    // Zwykła metoda (nie abstrakcyjna) też może tu być!
    void spij() {
        System.out.println(imie + " idzie spać: Zzz...");
    }
//    abstract void spij();
}

// 3. INTERFEJS
// To nie jest "co to jest", tylko "co to potrafi".
interface Pupil {
    // W interfejsie metody są domyślnie publiczne i abstrakcyjne
    void bawsie();
}

// 4. KLASA KONKRETNA
// Pies JEST Zwierzęciem (extends) i POTRAFI być Pupilem (implements)
class Pies extends Zwierze implements Pupil {

    public Pies(String imie) {
        super(imie); // Wywołanie konstruktora rodzica (Zwierze)
    }

    // MUSIMY zaimplementować dajGlos (bo rodzic kazał)
    @Override
    void dajGlos() {
        System.out.println(imie + ": Hau hau!");
    }

/*    @Override
    void spij() {System.out.println(imie + " : chrrrrr....");}*/

    // MUSIMY zaimplementować bawsie (bo interfejs kazał)
    @Override
    public void bawsie() {
        System.out.println(imie + " macha ogonem i łapie piłkę.");
    }
}

class Wilk extends Zwierze {
    public Wilk(String imie) {
        super(imie);
    }

    @Override
    void dajGlos() {
        System.out.println(imie + ": Auuuuuu!");
    }
/*    @Deprecated
    public void bawsie() {
        System.out.println("Wilk NIE implementuje Pupil, więc nie musi" +
                "(i nie może)się bawić, może zjeść");
    }*/

/*    @Override
    void spij() {
        System.out.println(imie + " : aaaarr...");
    }*/
}

class Nietoperz extends Zwierze implements Pupil {

    public Nietoperz(String imie) {
        super(imie);
    }

    @Override
    void dajGlos() {
        System.out.println(imie + " Pisk!");
    }

    @Override
    void spij() {
        System.out.println(imie + " wisi głową w dół i śpi: Zzz...");}

    @Override
    public void bawsie() {
        System.out.println(imie + " huśta się wisząc głową w dół ");}
}

// --- CZĘŚĆ 2: REKORDY ---

// Rekord może być zdefiniowany w tym samym pliku (nie musi być wewnątrz klasy Main)

// Definicja rekordu - to jest cała klasa!
// Java automatycznie tworzy:
// 1. Pola private final
// 2. Konstruktor
// 3. Metody dostępowe (imie(), id()) - BEZ "get"
// 4. equals(), hashCode(), toString()

/*
    // stara metoda

    class Opiekun {
        private final String imie;
        private final String sekcja;

        public Opiekun(String imie, String sekcja) {
            this.imie = imie;
            this.sekcja = sekcja;
        }

        // Musisz sam napisać gettery
        public String getImie() { return imie; }
        public String getSekcja() { return sekcja; }

        // Musisz sam napisać equals i hashCode (tutaj poprawna implementacja)
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Opiekun that = (Opiekun) o;
            return sekcja == that.sekcja && java.util.Objects.equals(imie, that.imie);
        }

        @Override
        public int hashCode() {
            return java.util.Objects.hash(imie, sekcja);
        }

        @Override
        public String toString() {
            return "Opiekun{imie='" + imie + "', id=" + sekcja + "'}";
        }
    }


 */
   // nowa metoda - record

record Opiekun(String imie, String sekcja) {}

class ZooMain {
    public static void main(String[] args) {
        // Zwierze z = new Zwierze("Duch"); // BŁĄD! Nie można tworzyć obiektu klasy abstrakcyjnej.

        Pies burek = new Pies("Burek");
        Pies zUlicy = new Pies("Burek");
        Wilk klow = new Wilk("Kieł");
        Nietoperz bat = new Nietoperz("Bat");

        // Polimorfizm nadal działa!
        Zwierze[] klatka = {burek, klow, bat};

        System.out.println("--- Obchód ZOO ---");
        for (Zwierze z : klatka) {
            z.dajGlos(); // Każdy robi to po swojemu
            z.spij();    // Wspólna metoda z klasy abstrakcyjnej
        }

        System.out.println("\n--- Czas zabawy ---");
        for (Zwierze z : klatka) {
            // Sprawdzamy: Czy to zwierzę jest też Pupilem?
            if (z instanceof Pupil) {
                // Jeśli tak, rzutujemy (zmieniamy etykietę) i się bawimy
                Pupil p = (Pupil) z;
                p.bawsie();
            }
        }

        // klow.bawsie(); // BŁĄD! Wilk nie ma interfejsu Pupil
        System.out.println("\n--- Equals kontra '==' ---");
        System.out.println("burek == zUlicy '==': " + (burek == zUlicy)); // false bo sprawdza adres
        System.out.println("burek.equals(zUlicy) equals: " + burek.equals(zUlicy)); // true, nauczyliśmy klase zwierze aby sprawdzała treść,
        // domyślnie sprawdza również adres jak '==' bo to jest klasa

        System.out.println("\n\n====== CZĘŚĆ 2: PRACOWNICY (Rekordy) ======");

        Opiekun o1 = new Opiekun("Marek", "Lwy");
        Opiekun o2 = new Opiekun("Marek", "Lwy");
        Opiekun o3 = new Opiekun("Kasia", "Foki");

        // nowa wersja: rekordy

        System.out.println("\nToString w rekordzie: " + o1);
        System.out.println("Pobieranie pola (bez get): " + o1.sekcja());
        System.out.println("Czy opiekunowie to ta sama osoba (equals)? " + o1.equals(o2)); // true (automat)
        System.out.println("Czy opiekunowie to ta sama osoba (==)? " + (o1 == o2));
        System.out.println("Gdzie biegnie: " + o3.imie() + ": " + " do " + o3.sekcja());

/*
        // stara wersja

        System.out.println("\nToString w rekordzie: " + o1);
        System.out.println("Pobieranie pola (bez get): " + o1.getSekcja());
        System.out.println("Czy opiekunowie to ta sama osoba (equals)? " + o1.equals(o2)); // true (automat)
        System.out.println("Czy opiekunowie to ta sama osoba (==)? " + (o1 == o2));
        System.out.println("Gdzie biegnie: " + o3.getImie() + ": " + " do " + o3.getSekcja());
*/

        }
    }
