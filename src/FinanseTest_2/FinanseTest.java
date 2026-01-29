/*
Pytanie 2: Dlaczego typy zmiennoprzecinkowe nie nadają się do obliczeń finansowych? Typy float i
        double opierają się na arytmetyce binarnej (IEEE 754), co prowadzi do błędów zaokrągleń
        przy ułamkach dziesiętnych (np. 0.1). W finansach używamy klasy BigDecimal.
 */

package FinanseTest_2;

import java.math.BigDecimal;

public class FinanseTest { // Klasa nazywa się tak samo jak plik

    public static void main(String[] args) {
        // Problem z double
        double a = 0.1;
        double b = 0.2;
        System.out.println("Double: " + (a + b));
        // Wynik: 0.30000000000000004

        // Rozwiązanie: BigDecimal
        // Ważne: Konstruktor musi przyjmować Stringa!
        BigDecimal x = new BigDecimal("0.1");
        BigDecimal y = new BigDecimal("0.2");
        BigDecimal result = x.add(y);
        System.out.println("BigDecimal: " + result);
        // Wynik: 0.3
    }
}