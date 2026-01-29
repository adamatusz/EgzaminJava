package FinalFeatures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class  FinalFeatures {
    public static void main(String[] args) {
        final int[] liczby = {1, 2, 3};
        System.out.println(Arrays.toString(liczby));

// PRÓBA 1: Zmiana adresu (przypięcie innej tablicy)
// liczby = new int[] {4, 5, 6}; // BŁĄD KOMPILACJI! (Smycz jest zablokowana)

// PRÓBA 2: Zmiana wnętrza (edycja elementu)
        liczby[0] = 99; // TO JEST DOZWOLONE!}
        System.out.println(Arrays.toString(liczby));

        List<String> kolory = new ArrayList<>(Arrays.asList("Czerwony", "Zielony"));
        System.out.println("kolory: " + kolory);
        kolory.add("Niebieski");
        System.out.println("kolory: " + kolory);
    }
}