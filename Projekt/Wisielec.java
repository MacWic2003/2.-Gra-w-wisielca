import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.HashSet;
import java.util.Set;

public class Wisielec {
    List<String> easyWords = new ArrayList<>(Arrays.asList("kot", "dom", "las", "pies", "oko"));
    List<String> mediumWords = new ArrayList<>(Arrays.asList("komputer", "biblioteka", "delfin", "słownik", "kwarc"));
    List<String> hardWords = new ArrayList<>(Arrays.asList("konstantynopolitanczykowianeczka", "wyimaginowana", "jeżozwierze", "szczebrzeszynie", "człekokształtny"));

    List<String> currentWords;
    String word;
    char[] userWord;
    int lives;
    int wins = 0;
    int losses = 0;
    Set<Character> guessedLetters = new HashSet<>();

    public void play() {
        Scanner scanner = new Scanner(System.in);

        boolean continuePlaying = true;
        while (continuePlaying) {
            System.out.println("Wybierz opcję:");
            System.out.println("1. Zagraj");
            System.out.println("2. Dodaj słowo");
            System.out.println("3. Wyświetl statystyki");
            System.out.println("4. Wyświetl listę słów");
            System.out.println("5. Wyjdź");
            int option = Integer.parseInt(scanner.nextLine());

            switch (option) {
                case 1:
                    chooseDifficulty(scanner);
                    playGame(scanner);
                    break;
                case 2:
                    addWord(scanner);
                    break;
                case 3:
                    showStatistics();
                    break;
                case 4:
                    showWordList(scanner);
                    break;
                case 5:
                    continuePlaying = false;
                    break;
                default:
                    System.out.println("Nieprawidłowy wybór. Spróbuj ponownie.");
            }
        }

        scanner.close();
    }

    private void chooseDifficulty(Scanner scanner) {
        System.out.println("Wybierz poziom trudności:");
        System.out.println("1. Łatwy");
        System.out.println("2. Średni");
        System.out.println("3. Trudny");
        int difficulty = Integer.parseInt(scanner.nextLine());

        switch (difficulty) {
            case 1:
                currentWords = easyWords;
                break;
            case 2:
                currentWords = mediumWords;
                break;
            case 3:
                currentWords = hardWords;
                break;
            default:
                System.out.println("Nieprawidłowy wybór. Domyślnie wybrano poziom średni.");
                currentWords = mediumWords;
        }
    }

    private void playGame(Scanner scanner) {
        resetGame();

        Random random = new Random();
        word = currentWords.get(random.nextInt(currentWords.size()));

        userWord = new char[word.length()];
        Arrays.fill(userWord, '_');

        while (!gameEnded()) {
            System.out.println(userWord);
            System.out.println();
            System.out.println("Podaj kolejną literę: ");
            System.out.println("Pozostało żyć: " + lives);

            char letter = getSingleLetter(scanner);
            checkLetter(letter);
        }

        if (lives == 0) {
            System.out.println("Przegrałeś. Słowo to: " + word);
            losses++;
        } else {
            System.out.println("Wygrałeś");
            wins++;
        }

        showStatistics();
    }

    private char getSingleLetter(Scanner scanner) {
        String input;
        while (true) {
            input = scanner.nextLine().toLowerCase();
            if (input.length() == 1 && Character.isLetter(input.charAt(0))) {
                char letter = input.charAt(0);
                if (guessedLetters.contains(letter)) {
                    System.out.println("Ta litera została już użyta. Podaj inną literę.");
                } else {
                    guessedLetters.add(letter);
                    return letter;
                }
            } else {
                System.out.println("Podaj pojedynczą literę.");
            }
        }
    }

    private void addWord(Scanner scanner) {
        System.out.println("Podaj nowe słowo do dodania:");
        String newWord = scanner.nextLine().toLowerCase();
        System.out.println("Wybierz poziom trudności dla tego słowa:");
        System.out.println("1. Łatwy");
        System.out.println("2. Średni");
        System.out.println("3. Trudny");
        int difficulty = Integer.parseInt(scanner.nextLine());

        List<String> targetList;
        switch (difficulty) {
            case 1:
                targetList = easyWords;
                break;
            case 2:
                targetList = mediumWords;
                break;
            case 3:
                targetList = hardWords;
                break;
            default:
                System.out.println("Nieprawidłowy wybór. Słowo nie zostało dodane.");
                return;
        }

        if (!targetList.contains(newWord)) {
            targetList.add(newWord);
            System.out.println("Słowo dodane do bazy.");
        } else {
            System.out.println("Słowo już istnieje w bazie.");
        }
    }

    private void showStatistics() {
        int totalGames = wins + losses;
        System.out.println("Statystyki gry:");
        System.out.println("Liczba zwycięstw: " + wins);
        System.out.println("Liczba porażek: " + losses);
        System.out.println("Liczba zagranych gier: " + totalGames);
    }

    private void showWordList(Scanner scanner) {
        System.out.println("Wybierz poziom trudności, dla którego chcesz zobaczyć listę słów:");
        System.out.println("1. Łatwy");
        System.out.println("2. Średni");
        System.out.println("3. Trudny");
        int difficulty = Integer.parseInt(scanner.nextLine());

        List<String> targetList;
        switch (difficulty) {
            case 1:
                targetList = easyWords;
                break;
            case 2:
                targetList = mediumWords;
                break;
            case 3:
                targetList = hardWords;
                break;
            default:
                System.out.println("Nieprawidłowy wybór.");
                return;
        }

        System.out.println("Lista słów:");
        for (String word : targetList) {
            System.out.println(word);
        }
    }

    private void checkLetter(char letter) {
        boolean foundLetter = false;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == letter) {
                userWord[i] = letter;
                foundLetter = true;
            }
        }
        if (!foundLetter) {
            System.out.println("Brak takiej litery w słowie");
            lives--;
        }
    }

    private boolean gameEnded() {
        return lives == 0 || word.equals(String.valueOf(userWord));
    }

    private void resetGame() {
        lives = 6;
        guessedLetters.clear();
    }
}