package hangman.chars;

import hangman.Hangman;

import java.util.Arrays;

public class HangmanGameChars extends Hangman {

    public char[] guessLetter() {
        long countMisses = 0;
        char[] gameWord = randomWords.get(random.nextInt(randomWords.size())).toCharArray();
        char[] result = new char[gameWord.length];
        char[] userWord = new char[gameWord.length];
        Arrays.fill(userWord, '*');

        countMisses = getMisses(countMisses, gameWord, userWord);

        System.out.println("You missed " + countMisses + " times");
        return result;
    }

    private long getMisses(long countMisses, char[] gameWord, char[] userWord) {
        while (isContainsCharacter(userWord, '*')) {
            System.out.println("Coded word is: " + new String(userWord));

            char guessLetter = getUserLetter();
            if (isContainsCharacter(gameWord, guessLetter)) {
                userWord = decodeGuessedLetter(gameWord, userWord, guessLetter);
            } else {
                ++countMisses;
            }
        }
        return countMisses;
    }

    private boolean isContainsCharacter(char[] userWord, char charToSearch) {
        boolean isContains = false;
        for (char userWordChar : userWord) {
            if (userWordChar == charToSearch) {
                isContains = true;
                break;
            }

        }
        return isContains;
    }

    private Character getUserLetter() {
        String guessLetter = scanner.next();
        if (guessLetter.length() > 1) {
            System.out.println("Please enter only one letter!");
        }
        return guessLetter.charAt(0);
    }

    private char[] decodeGuessedLetter(char[] gameWord, char[] userWord, char guessLetter) {
        boolean isLetterGuessed = false;
        for (int i = 0; i < gameWord.length; i++) {
            if (gameWord[i] == guessLetter) {
                char decodedChar = gameWord[i];
                userWord[i] = decodedChar;
                isLetterGuessed = true;
            }
        }
        if (isLetterGuessed) {
            System.out.println("Great! You guessed the letter: " + guessLetter);
        }
        return userWord;
    }

}
