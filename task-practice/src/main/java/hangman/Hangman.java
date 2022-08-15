package hangman;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

public abstract class Hangman {
    protected static Random random = new Random();
    protected static Scanner scanner = new Scanner(System.in);
    protected static List<String> randomWords = List.of("Dad", "Mom", "Sister", "Brother", "Son", "Daughter", "Family");

}
