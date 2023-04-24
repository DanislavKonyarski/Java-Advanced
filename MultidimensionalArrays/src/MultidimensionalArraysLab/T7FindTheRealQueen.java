package MultidimensionalArraysLab;

import java.util.Arrays;
import java.util.Scanner;

public class T7FindTheRealQueen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[][] matrix = new String[8][8];
        for (int r = 0; r < matrix.length; r++) {
            matrix[r] = scanner.nextLine().split(" ");
        }
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                if (matrix[r][c].equals("q")) {
                    int countQinRow = 0;
                    int countQinCol = 0;
                    int countQinFirstDiagonals = 0;
                    int countQinSecondDiagonals = 0;
                    for (int i = 0; i < matrix[r].length; i++) {
                        if (matrix[r][i].equals("q")) {
                            countQinRow++;
                        }
                    }
                    if (countQinRow >= 2) {
                        continue;
                    }
                    for (int i = 0; i < matrix[c].length; i++) {   //!
                        if (matrix[i][c].equals("q")) {
                            countQinCol++;
                        }
                    }
                    if (countQinCol >= 2) {
                        continue;
                    }
                    int currentI = 0;
                    for (int i = Math.abs(r - c); i < matrix.length; i++) {
                        if (r > c) {
                            if (matrix[i][currentI].equals("q")) {
                                countQinFirstDiagonals++;
                            }
                        } else {
                            if (matrix[currentI][i].equals("q")) {
                                countQinFirstDiagonals++;

                            }
                        }
                        currentI++;
                    }
                    if (countQinFirstDiagonals >= 2) {
                        continue;
                    }
                    int row = r + c;
                    if (row <= matrix.length - 1) {
                        int maxRow = row;
                        for (int i = 0; i <= maxRow; i++) {
                            if (matrix[row][i].equals("q")) {
                                countQinSecondDiagonals++;
                            }
                            row--;
                        }
                        if (countQinSecondDiagonals >= 2) {
                            continue;
                        }
                    } else {
                        row = (r + c) - (matrix.length - 1);
                        int maxCol = matrix[r].length - 1;
                        for (int i = row; i < matrix.length; i++) {
                            if (matrix[i][maxCol].equals("q")) {
                                countQinSecondDiagonals++;
                            }
                            maxCol--;
                        }
                        if (countQinSecondDiagonals >= 2) {
                            continue;
                        }
                    }
                    if (countQinRow == 1 && countQinCol == 1 && countQinFirstDiagonals == 1 && countQinSecondDiagonals == 1) {
                        System.out.println(r + " " + c);
                        return;
                    }
                }
            }
        }
    }
}

