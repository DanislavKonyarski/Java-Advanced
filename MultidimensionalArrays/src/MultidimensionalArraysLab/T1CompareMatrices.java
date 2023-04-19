package MultidimensionalArraysLab;

import java.util.Arrays;
import java.util.Scanner;

public class T1CompareMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int countRow = scanner.nextInt();
        int countCol = scanner.nextInt();

        int[][] firstMatrix = new int[countRow][countCol];
        for (int r = 0; r < countRow; r++) {
            for (int c = 0; c < countCol; c++) {
                firstMatrix[r][c] = scanner.nextInt();
            }
        }
        countRow = scanner.nextInt();
        countCol = scanner.nextInt();
        int[][] secondMatrix = new int[countRow][countCol];
        for (int r = 0; r < countRow; r++) {
            for (int c = 0; c < countCol; c++) {
                secondMatrix[r][c] = scanner.nextInt();
            }
        }
        int a = firstMatrix.length;
        boolean isEqual = true;
        if (firstMatrix.length!=secondMatrix.length){
            isEqual = false;
        } else {
            for (int r = 0; r < firstMatrix.length; r++) {
                if (firstMatrix[r].length!=secondMatrix[r].length){
                    isEqual=false;
                }else {
                    for (int c = 0; c < firstMatrix[r].length ; c++) {
                        if (firstMatrix[r][c]!=secondMatrix[r][c]){
                            isEqual = false;
                            break;
                        }
                    }
                }
            }
        }
        if (isEqual){
            System.out.println("equal");
        }else {
            System.out.println("not equal");
        }
    }
}
