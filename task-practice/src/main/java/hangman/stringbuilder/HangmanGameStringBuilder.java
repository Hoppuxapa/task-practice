package hangman.stringbuilder;

import hangman.Hangman;

public class HangmanGameStringBuilder extends Hangman {

    public String guessLetter() {
        long countMisses = 0;
        String result = "";
        StringBuilder gameWord = new StringBuilder(randomWords.get(random.nextInt(randomWords.size())));
        StringBuilder userWord = encodeWord(gameWord);

        countMisses = getMisses(countMisses, gameWord, userWord);

        System.out.println("You missed " + countMisses + " times");
        return result;
    }

    private long getMisses(long countMisses, StringBuilder gameWord, StringBuilder userWord) {
        while (userWord.toString().contains("*")) {
            System.out.println("Coded word is: " + userWord);

            String guessLetter = getUserLetter();
            if (gameWord.toString().contains(guessLetter)) {
                decodeGuessedLetter(gameWord, userWord, guessLetter);
            } else {
                ++countMisses;
            }
        }
        return countMisses;
    }

    private StringBuilder encodeWord(StringBuilder gameWord) {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < gameWord.length(); i++) {
            s.append("*");
        }
        return s;
    }

    private String getUserLetter() {
        String guessLetter = scanner.next();
        if (guessLetter.length() > 1) {
            System.out.println("Please enter only one letter!");
        }
        return guessLetter;
    }

    private void decodeGuessedLetter(StringBuilder gameWord, StringBuilder userWord, String guessLetter) {
        for (int i = 0; i < gameWord.length(); i++) {
            if (gameWord.charAt(i) == guessLetter.charAt(0)) {
                userWord.delete(i, i);
                userWord.insert(i, guessLetter);
            }
        }
        System.out.println("Great! You guessed the letter: " + guessLetter);
    }

}

