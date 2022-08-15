package hangman.string;

import hangman.Hangman;

public class HangmanGame extends Hangman {

    public String guessLetter() {
        long countMisses = 0;
        String result = "";
        String gameWord = randomWords.get(random.nextInt(randomWords.size()));
        String userWord = gameWord;

        userWord = encodeWord(userWord);

        countMisses = getMisses(countMisses, gameWord, userWord);

        System.out.println("You missed " + countMisses + " times");
        return result;
    }

    private long getMisses(long countMisses, String gameWord, String userWord) {
        while (userWord.contains("*")) {
            System.out.println("Coded word is: " + userWord);

            String guessLetter = getUserLetter();
            if (gameWord.contains(guessLetter)) {
                userWord = decodeGuessedLetter(gameWord, userWord, guessLetter);
            } else {
                ++countMisses;
            }
        }
        return countMisses;
    }

    private String encodeWord(String userWord) {
        for (int i = 0; i < userWord.length(); i++) {
            userWord = userWord.replace(userWord.charAt(i), '*');
        }
        return userWord;
    }

    private String getUserLetter() {
        String guessLetter = scanner.next();
        if (guessLetter.length() > 1) {
            System.out.println("Please enter only one letter!");
        }
        return guessLetter;
    }

    private String decodeGuessedLetter(String gameWord, String userWord, String guessLetter) {
        for (int i = 0; i < gameWord.length(); i++) {
            if (gameWord.charAt(i) == guessLetter.charAt(0)) {
                userWord = userWord.substring(0, i) + guessLetter +
                        userWord.substring(i + 1, gameWord.length());
            }
        }
        System.out.println("Great! You guessed the letter: " + guessLetter);
        return userWord;
    }

}
