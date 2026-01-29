/*
    Pytanie 9: Wyrażenie Switch (Java 14) Nowy switch zapobiega "przelatywaniu" (fall-through) dzięki składni
    strzałkowej (->) i pozwala zwracać wartość bezpośrednio do zmiennej.

    Pytanie 19: Rekordy (Records) Rekord to zwięzły sposób na tworzenie klas przechowywujących dane (data carriers).
    Generuje automatycznie konstruktor, gettery, equals, hashCode i toString.
*/

package ModernJava_9_19;

public class ModernJava {
        // Definicja rekordu (zamiast całej klasy z polami private final) [cite: 275]
        public record Osoba(String imie, int wiek) {}

        public static void main(String[] args) {
            // Użycie switch expression
            String dzien = "Sobota";
            String typDnia = switch (dzien) {
                case "Poniedziałek", "Wtorek", "Środa", "Czwartek", "Piątek" -> "Pracujący";
                case "Sobota", "Niedziela" -> "Weekend";
                default -> "Nieznany";
            }; // Średnik na końcu wymagany, bo to przypisanie wartości [cite: 170-175]

            System.out.println("Typ dnia: " + typDnia);

            // Użycie rekordu
            Osoba o = new Osoba("Jan", 30);
            System.out.println(o.imie()); // Dostęp bez getImie(), po prostu imie()
            System.out.println(o);        // Automatyczny toString
        }
    }
