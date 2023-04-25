package MultidimensionalArraysLab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class T8WrongMeasurements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int countRow = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[countRow][];
        for (int r = 0; r < matrix.length; r++) {
            matrix[r] = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        }
        String[] indexes = scanner.nextLine().split(" ");
        int indexRow = Integer.parseInt(indexes[0]);
        int indexColumn = Integer.parseInt(indexes[1]);
        int wrongDigit = matrix[indexRow][indexColumn];
        List<int[]> correctDigit = new ArrayList<>();
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                if (matrix[r][c] == wrongDigit){
                    int upDigit = 0;
                    int downDigit = 0;
                    int leftDigit = 0;
                    int rightDigit = 0;

                        if (r>0&&matrix[r-1][c]!=wrongDigit){
                        upDigit = matrix[r-1][c];
                        }
                        if (r<matrix.length-1&&matrix[r+1][c]!=wrongDigit){
                        downDigit = matrix[r+1][c];
                        }


                        if (c>0&&matrix[r][c-1]!=wrongDigit){
                        leftDigit = matrix[r][c-1];
                        }
                        if (c<matrix[r].length-1&&matrix[r][c+1]!=wrongDigit){
                        rightDigit = matrix[r][c+1];
                        }

                    int sum = upDigit+downDigit+leftDigit+rightDigit;
                        correctDigit.add(new int[]{r,c,sum});
                }
            }
        }
        for (int i = 0; i < correctDigit.size(); i++) {
           int r = correctDigit.get(i)[0];
           int c = correctDigit.get(i)[1];
           int sum = correctDigit.get(i)[2];
           matrix[r][c] = sum;
        }
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                System.out.print(matrix[r][c]+" ");
            }
            System.out.println();
        }
    }
}
