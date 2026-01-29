/*
    Pytanie 32 i 33:
    Wyrażenia Lambda i Interfejs Funkcyjny ma dokładnie jedną metodę abstrakcyjną
    (np. Runnable, Comparator). Lambda to skrócony zapis implementacji takiego interfejsu: (parametry) -> { kod }.
*/

package LambdaInterface_32_33;

import java.util.function.BinaryOperator;

public class LambdaInterface {
    public static void main(String[] args) {
        // Tradycyjnie (klasa anonimowa)
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("Stary sposób");
            }
        };

        // Lambda (bez parametrów) [cite: 397]
        Runnable r2 = () -> System.out.println("Nowy sposób z Lambdą");

        r1.run();
        r2.run();

        // Lambda z parametrami (interfejs funkcyjny przyjmujący 2 argumenty)
        // x i y to parametry, x + y to zwracany wynik [cite: 399]
        BinaryOperator<Integer> dodawanie = (x, y) -> x + y;

        System.out.println("Suma: " + dodawanie.apply(5, 10));
    }
}
