package MultidimensionalArraysExercises;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class T4MaximalSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\s+");
        int countRow = Integer.parseInt(input[0]);
        int countCol = Integer.parseInt(input[1]);
        int[][] matrix = new int[countRow][countCol];

        for (int r = 0; r < matrix.length; r++) {
            matrix[r] = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        }
        int sum = Integer.MIN_VALUE;
        int row = 0;
        int col = 0;
        for (int r = 0; r < matrix.length - 2; r++) {
            for (int c = 0; c < matrix[r].length - 2; c++) {
                int currentSum = matrix[r][c] + matrix[r][c + 1] + matrix[r][c + 2] +
                                    matrix[r + 1][c] + matrix[r + 1][c + 1] + matrix[r + 1][c + 2] +
                                        matrix[r + 2][c] + matrix[r + 2][c + 1] + matrix[r + 2][c + 2];
                if (currentSum > sum) {
                    sum = currentSum;
                    row = r;
                    col = c;
                }
            }
        }
        System.out.println("Sum = "+sum);
        System.out.println(matrix[row][col]+" "+matrix[row][col+1]+" "+matrix[row][col+2]);
        System.out.println(matrix[row+1][col]+" "+matrix[row+1][col+1]+" "+matrix[row+1][col+2]);
        System.out.println(matrix[row+2][col]+" "+matrix[row+2][col+1]+" "+matrix[row+2][col+2]);
    }
}
