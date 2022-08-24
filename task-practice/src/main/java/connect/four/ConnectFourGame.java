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
            } else {
                System.out.println("It is draw!");
                break;
            }
        }
    }

    private boolean hasSpace(String[][] gameField) {
        for (int i = 0; i < gameField.length - 1; ++i) {
            if (isNull(gameField[0][i])) {
                return true;
            }
        }
        return false;
    }

    private void setTurn(String[][] gameField, Turn turn) {
        for (int i = gameField.length - 1; i >= 0; i--) {
            if (isNull(gameField[i][turn.row])) {
                gameField[i][turn.row] = turn.colour;
                break;
            }
        }
    }

    private boolean isPlayerWon(String[][] gameField) {
        for (int i = 0; i < gameField.length; i++) {
            int countToWin = 0;
            for (int j = 0, k = 1; j < gameField.length - 1; j++,k++) {
                if (nonNull(gameField[i][j]) && nonNull(gameField[i][k]) && gameField[i][j].equals(gameField[i][k])) {
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
        Turn turn = new Turn();

        while (true) {
            try {
                boolean isValid = true;
                String userString = scanner.next();
                if (userString.length() != 2) {
                    System.out.println("Please enter correct number of symbols");
                    isValid = false;
                }

                turn.setRow(Integer.parseInt(userString.substring(0, 1)));
                turn.setColour(userString.substring(1));

                if (turn.row > 6 || turn.row < 0) {
                    System.out.println("Row must be from 0 to 5");
                    isValid = false;
                }

                if ((turn.colour.equals("Y") && isFirstPlayerTurn) || (turn.colour.equals("R") && !isFirstPlayerTurn)) {
                    System.out.println("Please enter correct colour");
                    isValid = false;
                }

                if (nonNull(gameField[0][turn.row])) {
                    System.out.println("This column is full pick up another one!");
                    isValid = false;
                }
                if (isValid) {
                    break;
                }
            } catch (Exception e) {
                System.out.println("Please enter first number from 0 to 6, second number from 0 to 5 and third letter R or Y colour");
            }
        }

        return turn;
    }

    @Data
    private class Turn {
        int row;
        String colour;
    }
}
