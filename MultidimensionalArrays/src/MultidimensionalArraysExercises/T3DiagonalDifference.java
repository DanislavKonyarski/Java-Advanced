package MultidimensionalArraysExercises;

import java.util.Arrays;
import java.util.Scanner;

public class T3DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int countRowColumn = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[countRowColumn][countRowColumn];

        for (int r = 0; r < matrix.length; r++) {
            matrix[r] = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        }

        int sumFirstDiagonal = 0;
        for (int r = 0; r < matrix.length; r++) {
            sumFirstDiagonal+= matrix[r][r];
        }
        int sumSecondDiagonal = 0;
        for (int r = 0; r < matrix.length; r++) {
            int col = matrix[r].length-1-r;
                sumSecondDiagonal+=matrix[r][col];
        }
        System.out.println(Math.abs(sumFirstDiagonal-sumSecondDiagonal));
    }
}
