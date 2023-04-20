package MultidimensionalArraysLab;

import java.util.Arrays;
import java.util.Scanner;

public class T4SumMatrixElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] input = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
        int countRow = input[0];
        int countCol = input[1];
        int[][] matrix = new int[countRow][countCol];

        for (int r = 0; r < matrix.length; r++) {
            matrix[r] = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
        }
        int sum = 0;
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                sum += matrix[r][c];
            }
        }
        System.out.println(countRow);
        System.out.println(countCol);
        System.out.println(sum);
    }
}
