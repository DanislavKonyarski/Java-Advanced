package MultidimensionalArraysExercises;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int rows = Integer.parseInt(input.split(" ")[0]);
        int cols = Integer.parseInt(input.split(" ")[1]);
        int[][] matrix = new int[rows][cols];
        int countForInput = 1;
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                matrix[r][c] = countForInput;
                countForInput++;
            }
        }
        input = scanner.nextLine();
        while (!input.equals("Nuke it from orbit")) {
            int targetRow = Integer.parseInt(input.split(" ")[0]);
            int targetCol = Integer.parseInt(input.split(" ")[1]);
            int radius = Integer.parseInt(input.split(" ")[2]);

            for (int r = targetRow - radius; r <= targetRow + radius; r++) {
                if (0 <= r && r < matrix.length && targetCol >= 0 && targetCol < matrix[r].length) {
                    matrix[r][targetCol] = 0;
                }
            }

            for (int c = targetCol - radius; c <= targetCol + radius; c++) {
                if (0 <= targetRow && targetRow < matrix.length && 0 <= c && c < matrix[targetRow].length) {
                    matrix[targetRow][c] = 0;
                }
            }
            int count = 0;
            int[][] currentMatrix = matrix;
            for (int r = 0; r < currentMatrix.length; r++) {
                List<Integer> currentList = new ArrayList<>();
                for (int c = 0; c < currentMatrix[r].length; c++) {
                    if (currentMatrix[r][c] != 0) {
                        currentList.add(currentMatrix[r][c]);
                    }
                }
                int[] currentArr = new int[currentList.size()];
                int index = 0;
                for (Integer item : currentList) {
                    currentArr[index++] = item;
                }
                currentMatrix[r - count] = currentArr;
                if (currentArr.length == 0) {
                    count++;
                }
            }
            matrix = new int[currentMatrix.length - count][];
            for (int r = 0; r < matrix.length; r++) {
                matrix[r] = currentMatrix[r];

            }
            input = scanner.nextLine();
        }
        for (int r = 0; r < matrix.length; r++) {
            boolean flag = false;
            for (int c = 0; c < matrix[r].length; c++) {
                System.out.print(matrix[r][c] + " ");
                flag = true;
            }
            if (flag) {
                System.out.println();
            }
        }
    }
}
