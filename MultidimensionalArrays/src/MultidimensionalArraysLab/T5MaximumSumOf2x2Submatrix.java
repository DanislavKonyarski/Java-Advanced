package MultidimensionalArraysLab;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class T5MaximumSumOf2x2Submatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] sizeMatrix = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
        int row = sizeMatrix[0];
        int col = sizeMatrix[1];
        int[][] matrix = new int[row][col];

        for (int r = 0; r < row; r++) {
            matrix[r] = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
        }
        int sum = Integer.MIN_VALUE;
        int maxRc = 0;
        int maxRCc = 0;
        int maxRrC = 0;
        int maxRrCc = 0;
        for (int r = 0; r < matrix.length - 1; r++) {
            for (int c = 0; c < matrix[r].length - 1; c++) {
                int currentSum = matrix[r][c] + matrix[r][c + 1] + matrix[r + 1][c] + matrix[r + 1][c + 1];
                if (sum < currentSum) {
                    sum = currentSum;
                    maxRc = matrix[r][c];
                    maxRCc = matrix[r][c+1];
                    maxRrC = matrix[r+1][c];
                    maxRrCc = matrix[r+1][c+1];
                }
            }
        }
        System.out.println(maxRc+" "+maxRCc);
        System.out.println(maxRrC+" "+maxRrCc);
        System.out.println(sum);
    }
}
