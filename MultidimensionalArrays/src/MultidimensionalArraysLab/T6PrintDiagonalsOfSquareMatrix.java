package MultidimensionalArraysLab;

import java.util.Arrays;
import java.util.Scanner;

public class T6PrintDiagonalsOfSquareMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sizeMatrix = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[sizeMatrix][sizeMatrix];
        for (int r = 0; r < matrix.length; r++) {
            matrix[r] = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        for (int r = 0; r < matrix.length; r++) {
            System.out.print(matrix[r][r] + " ");
        }
        System.out.println();
        for (int r = matrix.length - 1; r >= 0; r--) {
            int col = matrix.length - 1 - r;
            System.out.print(matrix[r][col]+" ");
        }
    }
}
