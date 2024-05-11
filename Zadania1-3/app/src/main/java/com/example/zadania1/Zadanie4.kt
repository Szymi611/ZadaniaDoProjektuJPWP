// Definicja klasy KontoBankowe
class KontoBankowe(private val imie: String) {
    private var saldoPLN: Double = 0.0
    private var saldoUSD: Double = 0.0
    private var saldoEUR: Double = 0.0

    // Metoda wpłaty w określonej walucie
    fun wplac(kwota: Double, waluta: String) {
        when (waluta.toUpperCase()) {
            "PLN" -> saldoPLN += kwota
            "USD" -> saldoUSD += kwota
            "EUR" -> saldoEUR += kwota
            else -> println("Nieznana waluta: $waluta")
        }
    }

    // Metoda wypłaty w określonej walucie
    fun wyplac(kwota: Double, waluta: String) {
        when (waluta.toUpperCase()) {
            "PLN" -> {
                if (kwota <= saldoPLN) {
                    saldoPLN -= kwota
                } else {
                    println("Brak wystarczających środków w PLN")
                }
            }
            "USD" -> {
                if (kwota <= saldoUSD) {
                    saldoUSD -= kwota
                } else {
                    println("Brak wystarczających środków w USD")
                }
            }
            "EUR" -> {
                if (kwota <= saldoEUR) {
                    saldoEUR -= kwota
                } else {
                    println("Brak wystarczających środków w EUR")
                }
            }
            else -> println("Nieznana waluta: $waluta")
        }
    }

    // Metoda przeliczenia salda na inną walutę
    fun przeliczSaldo(walutaDocelowa: String): Double {
        return when (walutaDocelowa.toUpperCase()) {
            "PLN" -> saldoPLN
            "USD" -> saldoUSD * 3.8 // Przykładowy kurs wymiany USD na PLN
            "EUR" -> saldoEUR * 4.5 // Przykładowy kurs wymiany EUR na PLN
            else -> {
                println("Nieznana waluta: $walutaDocelowa")
                0.0
            }
        }
    }

    // Metoda wyświetlenia aktualnego salda
    fun wyswietlSaldo(waluta: String) {
        val saldo = przeliczSaldo(waluta)
        println("Saldo konta $imie w walucie $waluta: $saldo")
    }
}

// Przykładowe użycie kalkulatora bankowego
fun main() {
    val mojeKonto = KontoBankowe("TwojeImię")
    mojeKonto.wplac(1000.0, "PLN")
    mojeKonto.wplac(500.0, "USD")
    mojeKonto.wplac(800.0, "EUR")

    println("Wybierz walutę, w której chcesz zobaczyć saldo (PLN, USD, EUR): ")
    val walutaWybrana = readLine() ?: ""
    mojeKonto.wyswietlSaldo(walutaWybrana)
}
