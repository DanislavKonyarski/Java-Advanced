package MultidimensionalArraysExercises;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class T6StringMatrixRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().replace(")", "");
        int countRotation = Integer.parseInt(input.split("\\(")[1]) % 360;
        String inputLine = scanner.nextLine();
        int maxLength = 0;
        Deque<String> workStack = new ArrayDeque<>();
        while (!inputLine.equals("END")) {
            workStack.offer(inputLine);
            if (maxLength < inputLine.length()) {
                maxLength = inputLine.length();
            }
            inputLine = scanner.nextLine();
        }
        char[][] matrix = new char[workStack.size()][maxLength];
        for (int r = 0; r < matrix.length; r++) {
            String currentWord = workStack.poll();
            for (int c = 0; c < matrix[r].length; c++) {
                if (currentWord.length() > c) {
                    matrix[r][c] = currentWord.charAt(c);
                } else {
                    matrix[r][c] = ' ';
                }
            }
        }
        switch (countRotation) {
            case 0:
                for (int r = 0; r < matrix.length; r++) {
                    for (int c = 0; c < matrix[r].length; c++) {
                        System.out.print(matrix[r][c]);
                    }
                    System.out.println();
                }
                break;
            case 90:
                for (int c = 0; c < maxLength; c++) {
                    for (int r = matrix.length - 1; r >= 0; r--) {
                        System.out.print(matrix[r][c]);
                    }
                    System.out.println();
                }
                break;
            case 180:
                for (int r = matrix.length-1; r >=0 ; r--) {
                    for (int c = maxLength - 1; c >= 0; c--) {
                        System.out.print(matrix[r][c]);
                    }
                    System.out.println();
                }
                break;
            case 270:
                for (int c = maxLength - 1; c >= 0; c--) {
                    for (int r = 0; r < matrix.length; r++) {
                        System.out.print(matrix[r][c]);
                    }
                    System.out.println();
                }
                break;
        }
    }
}
