package MultidimensionalArraysLab;

import java.util.Arrays;
import java.util.Scanner;

public class T3IntersectionOfTwoMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int countRow = Integer.parseInt(scanner.nextLine());
        int countCol = Integer.parseInt(scanner.nextLine());
        char[][] firstMatrix = new char[countRow][countCol];

        for (int i = 0; i < firstMatrix.length; i++) {
            firstMatrix[i] = scanner.nextLine().toCharArray();
        }
        char[][] secondMatrix = new char[countRow][countCol];
        for (int i = 0; i < secondMatrix.length; i++) {
            secondMatrix[i] = scanner.nextLine().toCharArray();
        }
        for (int r = 0; r < firstMatrix.length; r++) {
            for (int c = 0; c < firstMatrix[r].length; c++) {
                if (firstMatrix[r][c] == secondMatrix[r][c]) {
                    System.out.print(firstMatrix[r][c]);
                }else {
                    System.out.print("*");
                }
            }
            System.out.println();
        }
    }
}
