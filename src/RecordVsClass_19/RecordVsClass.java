/*
    Pytanie 19
    Omów rekordy i jakie są podstawowe różnice między klasą a
    rekordem? wygeneruj przykładową klasę i wytłumacz
*/

package RecordVsClass_19;

import java.util.Objects;

// GŁÓWNA KLASA (Uruchomieniowa)
public class RecordVsClass {
    public static void main(String[] args) {

        // 1. Użycie ZWYKŁEJ KLASY (Dużo kodu, trzeba pisać gettery)
        PracownikKlasa p1 = new PracownikKlasa("Jan", 1);
        System.out.println("Klasa: " + p1.toString());
        System.out.println("Pobieranie imienia (klasa): " + p1.getImie()); // getter z "get"

        // 2. Użycie REKORDU (To samo, a kod krótszy)
        PracownikRekord r1 = new PracownikRekord("Jan", 1);
        System.out.println("Rekord: " + r1.toString());
        System.out.println("Pobieranie imienia (rekord): " + r1.imie());   // getter bez "get"!

        // 3. Porównanie (equals)
        PracownikRekord r2 = new PracownikRekord("Jan", 1);
        System.out.println("Czy rekordy są równe? " + r1.equals(r2)); // TRUE (automat)
    }
}

// ==========================================
// WERSJA 1: ZWYKŁA KLASA (Old School) 👴
// Musisz napisać 40 linijek kodu...
// ==========================================
class PracownikKlasa {
    private final String imie;
    private final int id;

    public PracownikKlasa(String imie, int id) {
        this.imie = imie;
        this.id = id;
    }

    // Musisz sam napisać gettery
    public String getImie() { return imie; }
    public int getId() { return id; }

    // Musisz sam napisać equals i hashCode (tutaj poprawna implementacja)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PracownikKlasa that = (PracownikKlasa) o;
        return id == that.id && Objects.equals(imie, that.imie);
    }

    @Override
    public int hashCode() {
        return Objects.hash(imie, id);
    }

    @Override
    public String toString() {
        return "PracownikKlasa{imie='" + imie + "', id=" + id + "}";
    }
}

// ==========================================
// WERSJA 2: REKORD (New School) 👶
// Robi to samo co klasa wyżej, w 1 linijce!
// ==========================================
record PracownikRekord(String imie, int id) {
    // Java automatycznie generuje:
    // 1. Konstruktor
    // 2. Pola private final
    // 3. Gettery (imie(), id())
    // 4. equals(), hashCode(), toString()
}