# Wisielec

`Wisielec` to implementacja klasycznej gry w wisielca w języku Java. Gra polega na odgadywaniu słów poprzez podawanie pojedynczych liter. Gracz ma ograniczoną liczbę żyć i może dodawać nowe słowa do listy dostępnych słów.

## Funkcjonalności

- Wybór poziomu trudności gry: łatwy, średni, trudny.
- Rozgrywanie gry wisielca z wybranym poziomem trudności.
- Dodawanie nowych słów do listy słów w odpowiedniej kategorii trudności.
- Wyświetlanie statystyk gracza (liczba wygranych i przegranych gier).
- Wyświetlanie listy słów dla wybranego poziomu trudności.

## Struktura kodu

### Pola

- `easyWords`, `mediumWords`, `hardWords`: Listy słów podzielone według poziomu trudności.
- `currentWords`: Aktualnie używana lista słów, zależna od wybranego poziomu trudności.
- `word`: Słowo do odgadnięcia w bieżącej grze.
- `userWord`: Tablica znaków reprezentująca aktualny stan odgadniętego słowa.
- `lives`: Liczba pozostałych żyć.
- `wins`, `losses`: Liczniki wygranych i przegranych gier.
- `guessedLetters`: Zbiór już odgadniętych liter.

### Metody

- `play()`: Główna metoda uruchamiająca grę i obsługująca menu.
- `chooseDifficulty(Scanner scanner)`: Wybór poziomu trudności gry.
- `playGame(Scanner scanner)`: Rozgrywanie jednej gry.
- `getSingleLetter(Scanner scanner)`: Pobieranie pojedynczej litery od użytkownika.
- `addWord(Scanner scanner)`: Dodawanie nowego słowa do odpowiedniej listy słów.
- `showStatistics()`: Wyświetlanie statystyk gracza.
- `showWordList(Scanner scanner)`: Wyświetlanie listy słów dla wybranego poziomu trudności.
- `checkLetter(char letter)`: Sprawdzanie, czy podana litera znajduje się w słowie.
- `gameEnded()`: Sprawdzanie, czy gra się zakończyła (wygrana lub przegrana).
- `resetGame()`: Resetowanie stanu gry przed rozpoczęciem nowej rundy.

## Sposób użycia

1. Uruchom program.
2. Wybierz opcję z menu:
   - `1`: Rozpocznij nową grę.
   - `2`: Dodaj nowe słowo do listy słów.
   - `3`: Wyświetl statystyki gry.
   - `4`: Wyświetl listę słów dla wybranego poziomu trudności.
   - `5`: Zakończ program.

### Przykładowe działanie

1. Po uruchomieniu programu wybierz `1`, aby zagrać.
2. Wybierz poziom trudności: `1` dla łatwego, `2` dla średniego, `3` dla trudnego.
3. Program losuje słowo i wyświetla jego ukryte litery jako `_`.
4. Podaj litery, aby zgadywać słowo. Liczba prób jest ograniczona przez ilość żyć.
5. Program informuje o wyniku gry i aktualizuje statystyki.

## Wymagania

- Java 8 lub nowsza.
- Kompilator Java.

## Kompilacja i uruchomienie

Aby uruchomić program, użyj następujących poleceń w terminalu:

```
java Main
```
