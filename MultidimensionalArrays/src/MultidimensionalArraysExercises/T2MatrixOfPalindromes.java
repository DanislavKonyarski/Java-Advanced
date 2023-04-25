package MultidimensionalArraysExercises;

import java.util.Scanner;

public class T2MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int row = scanner.nextInt();
        int column = scanner.nextInt();
        String[][] matrix = new String[row][column];

        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                String charOne = Character.toString(r+97);
                String charTwo = Character.toString(r+c+97);
                String charThree = Character.toString(r+97);
                matrix[r][c] = charOne+charTwo+charThree;
                System.out.print(matrix[r][c]+" ");
            }
            System.out.println();
        }
    }
}
