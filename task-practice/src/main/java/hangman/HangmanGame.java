package hangman;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class HangmanGame {

    List<String> randomWords = List.of("Dad", "Mom", "Sister", "Brother", "Son", "Daughter", "Family");
    Random random = new Random();
    int randomIdx = random.nextInt(randomWords.size());
    Scanner scanner = new Scanner(System.in);

    public String guessLetter() {
        boolean isWordGuessed = true;
        long countMisses = 0;
        String result = "";
        String word = randomWords.get(randomIdx);
        String codedWord = word;
        for (int i = 0; i < codedWord.length(); i++) {
            codedWord = codedWord.replace(codedWord.charAt(i), '*');
        }
        while (isWordGuessed) {
            System.out.println("Coded word is: " + codedWord);
            String guessLetter = scanner.next();
            if (guessLetter.length() > 1) {
                System.out.println("Please enter only one letter!");
            }
            if (word.contains(guessLetter)) {
                for (int i = 0; i < word.length(); i++) {
                    if (word.charAt(i) == guessLetter.charAt(0)) {
                        int index = word.indexOf(word.charAt(i));
                        codedWord = codedWord.substring(0, index) + guessLetter +
                                codedWord.substring(index + 1, word.length());
                    }
                }
                System.out.println("Great! You guessed the letter: " + guessLetter);
            } else {
                ++countMisses;
            }
            if (!codedWord.contains("*")) {
                isWordGuessed = false;
            }
        }
        System.out.println("You missed " + countMisses + " times");
        return result;
    }
}
