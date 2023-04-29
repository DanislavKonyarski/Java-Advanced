package MultidimensionalArraysExercises;

import java.util.Arrays;
import java.util.Scanner;

public class T11ReverseMatrixDiagonals {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\s+");
        int rows = Integer.parseInt(input[0]);
        int cols = Integer.parseInt(input[1]);
        int[][] matrix = new int[rows][cols];
        for (int r = 0; r < matrix.length; r++) {
            matrix[r] = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        }
        if (rows > cols) {
            for (int r = 0; r < matrix[0].length ; r++) {
                int count = 0;
                for (int c = matrix[r].length - 1 - r; c < matrix[r].length; c++) {
                    if (matrix[r].length - 1 - r < 0) {
                        break;
                    }
                    System.out.print(matrix[matrix.length - 1 - count][c] + " ");
                    count++;
                }
                System.out.println();
            }

            for (int r = matrix.length - 2; r >= 0; r--) {
                for (int c = 0; c < matrix[r].length ; c++) {
                    if (r-c<0){
                        break;
                    }
                    System.out.print(matrix[r - c][c] + " ");
                }
                System.out.println();
            }
        } else {
            for (int r = 0; r < matrix[0].length; r++) {
                int count = 0;
                for (int c = matrix[0].length - 1 - r; c < matrix[0].length; c++) {
                    if (matrix.length - 1 - count < 0) {
                        break;
                    }
                    System.out.print(matrix[matrix.length - 1 - count][c] + " ");
                    count++;
                }
                System.out.println();
            }
            int count = 0;
            for (int r = matrix.length - 2; r >= 0; r--) {
                for (int c = 0; c < matrix[r].length  ; c++) {
                    if (r - c < 0) {
                        break;
                    }
                    System.out.print(matrix[r - c][c] + " ");
                }
                System.out.println();
            }
        }
    }
}
