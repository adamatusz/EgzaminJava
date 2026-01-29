/*
    Pytanie 10: Różnice między equals() a == Operator == porównuje referencje (adresy w pamięci) dla obiektów,
    a wartości tylko dla typów prostych. Metoda equals() służy do logicznego porównania zawartości obiektów.

    Pytanie 8: Inkrementacja przedrostkowa kontra przyrostkowa
    ++a (przedrostkowa): Zmień i użyj (najpierw dodaje, potem zwraca wynik).
    a++ (przyrostkowa): Użyj i zmień (najpierw zwraca obecną wartość, potem dodaje).
*/

package OperatoryTest_8;

public class OperatoryTest {
    public static void main(String[] args) {
        // == vs equals()
        String s1 = new String("Java");
        String s2 = new String("Java"); // Nowy obiekt w pamięci

        System.out.println("== : " + (s1 == s2));       // false (różne adresy) [cite: 190]
        System.out.println("equals: " + s1.equals(s2)); // true (ta sama treść) [cite: 190]

        // Inkrementacja
        int a = 5;
        int b = 5;
        System.out.println("++a: " + (++a)); // Wypisze 6 [cite: 155]
        System.out.println("b++: " + (b++)); // Wypisze 5 (ale b w pamięci ma już 6) [cite: 156]
        System.out.println("b po operacji: " + b); // 6
    }
}
