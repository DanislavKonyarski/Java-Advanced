package MultidimensionalArraysExercises;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class T5MatrixShuffling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\s+");
        int row = Integer.parseInt(input[0]);
        int col = Integer.parseInt(input[1]);
        String[][] matrix = new String[row][col];
        for (int r = 0; r < matrix.length; r++) {
            matrix[r] = scanner.nextLine().split("\\s+");
        }
        String command = scanner.nextLine();
        while (!command.equals("END")) {
            String[] commandArr = command.split("\\s+");

            Pattern pattern = Pattern.compile("swap [0-9]+ [0-9]+ [0-9]+ [0-9]+");
            Matcher matcher = pattern.matcher(command);

            if (matcher.find() && commandArr.length == 5) {
                int rowFirst = Integer.parseInt(commandArr[1]);
                int colFirst = Integer.parseInt(commandArr[2]);
                int rowSecond = Integer.parseInt(commandArr[3]);
                int colSecond = Integer.parseInt(commandArr[4]);

                if (rowFirst < matrix.length && colFirst < matrix[0].length &&
                        rowSecond < matrix.length && colSecond < matrix[0].length) {
                    String firstWord = matrix[rowFirst][colFirst];
                    String secondWord = matrix[rowSecond][colSecond];
                    matrix[rowFirst][colFirst] = secondWord;
                    matrix[rowSecond][colSecond] = firstWord;
                    for (int r = 0; r < matrix.length; r++) {
                        for (int c = 0; c < matrix[r].length; c++) {
                            System.out.print(matrix[r][c] + " ");
                        }
                        System.out.println();
                    }
                } else {
                    System.out.println("Invalid input!");
                }
            } else {
                System.out.println("Invalid input!");
            }
            command = scanner.nextLine();
        }
    }
}
