/*
    30. Czym jest interfejs? Jakie są jego własności?
    31.	Czym różni się klasa abstrakcyjna od interfejsu?
    10. Jakie są róznice między equals(), a "=="
*/

package ZooProject_30_31;

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
    // Wilk NIE implementuje Pupil, więc nie musi (i nie może) się bawić.
}

class Nietoperz extends Zwierze {
    public Nietoperz(String imie) {
        super(imie);
    }
    @Override
    void dajGlos() {
        System.out.println(imie + " Pisk!");
    }

    @Override
    void spij() {
        System.out.println(imie + " wisi głową w dół i śpi: Zzz...");
    }
}

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
        burek.bawsie();
        // klow.bawsie(); // BŁĄD! Wilk nie ma interfejsu Pupil
        System.out.println("==: " + (burek == zUlicy)); // false bo sprawdza adres
        System.out.println("equals: " + burek.equals(zUlicy)); // true, nauczyliśmy klase zwierze aby sprawdzała treść,
                                                               // domyślnie sprawdza również adres jak '==' bo to jest klasa

    }
}
