package MultidimensionalArraysLab;

import java.util.Arrays;
import java.util.Scanner;

public class T2PositionsOf {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int countRow = scanner.nextInt();
        int countCol = scanner.nextInt();
        int[][] matrix = new int[countRow][countCol];

        for (int r = 0; r < matrix.length ; r++) {
            for (int c = 0; c <matrix[r].length ; c++) {
                matrix[r][c] = scanner.nextInt();
            }
        }
        boolean flag = true;
        int numberForSearch = scanner.nextInt();
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length ; c++) {
                if (matrix[r][c]==numberForSearch){
                    System.out.println(r+" "+c);
                    flag = false;
                }
            }
        }
        if (flag) {
            System.out.println("not found");
        }
    }
}
