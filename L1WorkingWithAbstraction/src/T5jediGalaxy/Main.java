package T5jediGalaxy;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimestions = readIntegerArr(scanner.nextLine());
        int r = dimestions[0];
        int c = dimestions[1];

        int[][] matrix = new int[r][c];

        int ofNumber = 0;
        createMatrix(r, c, matrix, ofNumber);

        String command = scanner.nextLine();
        long sum = 0;
        while (!"Let the Force be with you".equals(command)) {
            int[] ivoS = readIntegerArr(command);
            int[] evil = readIntegerArr(scanner.nextLine());
            int rEvil = evil[0];
            int cEvil = evil[1];

            evilDiagToZero(matrix, rEvil, cEvil);

            int rI = ivoS[0];
            int cI = ivoS[1];

            sum = calculateIvoS(matrix, sum, rI, cI);

            command = scanner.nextLine();
        }

        System.out.println(sum);


    }

    private static int[] readIntegerArr(String scanner) {
        return Arrays.stream(scanner.split(" ")).mapToInt(Integer::parseInt).toArray();
    }

    private static long calculateIvoS(int[][] matrix, long sum, int rI, int cI) {
        while (rI >= 0 && cI < matrix[1].length) {
            if (rI < matrix.length && cI >= 0 && cI < matrix[0].length) {
                sum += matrix[rI][cI];
            }
            cI++;
            rI--;
        }
        return sum;
    }

    private static void evilDiagToZero(int[][] matrix, int rEvil, int cEvil) {
        while (rEvil >= 0 && cEvil >= 0) {
            if (rEvil < matrix.length && cEvil < matrix[0].length) {
                matrix[rEvil][cEvil] = 0;
            }
            rEvil--;
            cEvil--;
        }
    }

    private static void createMatrix(int x, int y, int[][] matrix, int value) {
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                matrix[i][j] = value++;
            }
        }
    }
}
