package multidimensional;

public class CalculateSum {
    public Integer sumBelowAverageLine(int[][] array) {
        Integer result = checkIfArrayIsSquare(array);

        for (int i = 1; i < array.length; i++) {
            for (int j = 0; j < i; j++) {
                result += array[i][j];
            }
        }

        return result;
    }

    private Integer checkIfArrayIsSquare(int[][] array) {
        if (array.length != array[0].length) {
            System.out.printf("Array should be a square");
            return null;
        }
        return 0;
    }
}
