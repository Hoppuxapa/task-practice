package connect.four;

import lombok.Data;

import java.util.Scanner;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

public class ConnectFourGame {
    private static Scanner scanner = new Scanner(System.in);
    private boolean isFirstPlayerTurn = true;

    public void connectFourGame() {
        String[][] gameField = new String[6][7];
        while (true) {
            if (hasSpace(gameField)) {
                Turn turn = getPlayerTurn(gameField);

                setTurn(gameField, turn);

                if (isPlayerWon(gameField)) {
                    if (isFirstPlayerTurn) {
                        System.out.println("Winner is Red");
                    } else {
                        System.out.println("Winner is Yellow");
                    }
                    break;
                }
                isFirstPlayerTurn = !isFirstPlayerTurn;
            }
            System.out.println("It is draw!");
        }
    }

    private boolean hasSpace(String[][] gameField) {
        for (int i = 0; i < 5; i++) {
            if (nonNull(gameField[0][i])) {
                return true;
            }
        }
        return false;
    }

    private void setTurn(String[][] gameField, Turn turn) {
        for (int i = 5; i >= 0; i--) {
            if (isNull(gameField[i][turn.row])) {
                gameField[i][turn.row] = turn.colour;
                break;
            }
        }
    }

    private boolean isPlayerWon(String[][] gameField) {
        for (int i = 0; i < 6; i++) {
            int countToWin = 0;
            for (int j = 0; j < 5; j++) {
                if (nonNull(gameField[i][j]) && nonNull(gameField[i][j + 1]) && gameField[i][j].equals(gameField[i][j + 1])) {
                    ++countToWin;
                }
            }
            if (countToWin == 3) {
                return true;
            }
        }
        return false;
    }

    private Turn getPlayerTurn(String[][] gameField) {
        String userString = scanner.next();
        Turn turn = new Turn();
        if (userString.length() != 2) {
            System.out.println("Please enter correct number of symbols");
            return getPlayerTurn(gameField);
        }

        try {
            turn.setRow(Integer.parseInt(userString.substring(0, 1)));
            turn.setColour(userString.substring(1));
        } catch (Exception e) {
            System.out.println("Please enter first number from 0 to 6, second number from 0 to 5 and third letter R or Y colour");
            return getPlayerTurn(gameField);
        }

        if (turn.row > 6 || turn.row < 0) {
            System.out.println("Row must be from 0 to 5");
            return getPlayerTurn(gameField);
        }

        if ((turn.colour.equals("Y") && isFirstPlayerTurn) || (turn.colour.equals("R") && !isFirstPlayerTurn)) {
            System.out.println("Please enter correct colour");
            return getPlayerTurn(gameField);
        }

        if (nonNull(gameField[0][turn.row])) {
            System.out.println("This column is full pick up another one!");
            return getPlayerTurn(gameField);
        }

        return turn;
    }

    @Data
    private class Turn {
        int row;
        String colour;
    }
}
