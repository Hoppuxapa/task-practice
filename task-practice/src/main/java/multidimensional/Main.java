package multidimensional;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        CalculateSum calculateSum = new CalculateSum();
        Random random = new Random();
        int square = random.nextInt(5);
        int[][] array = new int[square][square];
        for (int i = 0; i < square; i++) {
            for (int j = 0; j < square; j++) {
                array[i][j] = random.nextInt(10);
            }
        }
        Integer i = calculateSum.sumBelowAverageLine(array);
        System.out.println("result = " + i);
    }
}
