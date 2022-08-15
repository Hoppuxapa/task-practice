package hangman;

import hangman.stringbuilder.HangmanGameStringBuilder;

public class Main {

    public static void main(String[] args) {
        HangmanGameStringBuilder hangmanGame = new HangmanGameStringBuilder();
        hangmanGame.guessLetter();
    }
}
