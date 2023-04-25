package MultidimensionalArraysExercises;

import java.util.Scanner;

public class T1FillTheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(",\\s+");
        int rowCol = Integer.parseInt(input[0]);
        String method = input[1];
        int[][] matrix = new int[rowCol][rowCol];

        if (method.equals("A")) {
            methodA(matrix);
        } else if (method.equals("B")) {
            methodB(matrix);
        }
        printMatrix(matrix);
    }

    private static void printMatrix(int[][] matrix) {
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                System.out.print(matrix[r][c]+" ");
            }
            System.out.println();
        }
    }

    private static void methodB(int[][] matrix) {
        int currentDigit = 1;
        for (int c = 0; c < matrix.length; c++) {
            if (c % 2 == 0) {
                for (int r = 0; r < matrix[c].length; r++) {
                    matrix[r][c] = currentDigit;
                    currentDigit++;
                }
            }else {
                for (int r = matrix.length-1; r >= 0; r--) {
                    matrix[r][c] = currentDigit;
                    currentDigit++;
                }
            }
        }
    }

    private static void methodA(int[][] matrix) {
        int currentDigit = 1;
        for (int c = 0; c < matrix.length; c++) {
            for (int r = 0; r < matrix[c].length; r++) {
                matrix[r][c] = currentDigit;
                currentDigit++;
            }
        }
    }
}
