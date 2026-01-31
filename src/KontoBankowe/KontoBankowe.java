package KontoBankowe;

import java.util.ArrayList;

public class KontoBankowe {
    // 1. Pola są prywatne (ukryte)
    private double saldo;
    String numerKonta;

    // Lista, "<>" typ generyczny może przechowywać tylko obiekty typu HistoriaTransakcji
    private ArrayList<HistoriaTransakcji> historia = new ArrayList<>();

    public void zrobPrzelew(double kwota, String data) {
        // 1. Zmieniamy saldo (dodajemy kwotę)
        this.saldo = this.saldo + kwota;

        // 2. Tworzymy wpis do historii
        HistoriaTransakcji wpis = new HistoriaTransakcji(data, kwota);

        // 3. Dodajemy wpis do listy!
        historia.add(wpis);
    }

    public void drukujHistorie() {
        System.out.println("\nHistoria operacji:");
        // "Dla każdego wpisu w liście historia..."
        for (HistoriaTransakcji wpis : historia) {
            System.out.println("Data: " + wpis.data + " | Kwota: " + wpis.kwota);
        }
    }

    // 2. GETTER - pozwala sprawdzić ile mam kasy
    public double getSaldo() {
        return saldo;
    }

    public KontoBankowe(String numerKonta) {
        this.numerKonta=numerKonta;
    }

    public String getNumerKonta() {
        return numerKonta;
    }

    // 3. SETTER - pozwala wpłacić, ale z kontrolą!
    public void setSaldo(double nowaKwota) {
        if (nowaKwota >= 0) {
            this.saldo = nowaKwota;
        } else {
            System.out.println("Błąd: Nie można mieć ujemnego salda!");
        }
    }

    // Drugi konstruktor (Przeciążony) - przyjmuje numer ORAZ saldo na start
    public KontoBankowe(String numerKonta, double kwotaStartowa) {
        this.numerKonta = numerKonta;
        // Używamy settera, żeby od razu sprawdzić, czy kwota nie jest ujemna!
        setSaldo(kwotaStartowa);
    }
    @Override //przesłanianie metody toString
    public String toString() {
        return "Konto nr: " + numerKonta + " | Dostępne środki: " + getSaldo();
    }

    static class HistoriaTransakcji {
        String data;
        double kwota;

        public HistoriaTransakcji(String data, double kwota) {
            this.data = data;
            this.kwota = kwota;
        }
    }
}

class Main {
    public static void main(String[] args) {
        // Tutaj wpiszemy nasz kod testowy
        KontoBankowe mojeKonto = new KontoBankowe("1234567890");
        KontoBankowe kontoKlientaVip = new KontoBankowe("9876543210", (5000.0));
        KontoBankowe.HistoriaTransakcji historia = new KontoBankowe.HistoriaTransakcji("2022-01-01", -1000);

        System.out.println("nr konta klienta: " + mojeKonto.getNumerKonta()+ " saldo= " + mojeKonto.getSaldo());
        System.out.println("\nnr konta klienta VIP: " + kontoKlientaVip.getNumerKonta()+ " saldo= " + kontoKlientaVip.getSaldo());

        mojeKonto.setSaldo(1500);
        System.out.println("\nwpłata: " + mojeKonto.getSaldo());

        mojeKonto.setSaldo(-200);
        System.out.println("wyplata: " + mojeKonto.getSaldo());
        System.out.println("\n" + mojeKonto);

//        System.out.println("wyplata: " + historia.kwota + " data: " + historia.data);

        mojeKonto.zrobPrzelew(500, "2023-10-01");
        mojeKonto.zrobPrzelew(-200, "2023-10-02");
        mojeKonto.drukujHistorie();
    }
}
