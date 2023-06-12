import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class T2TheSquirrel {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int matrixSize = Integer.parseInt(scanner.nextLine());
        List<String> commands = Arrays.stream(scanner.nextLine().split(",\\s+")).collect(Collectors.toList());
        String[][] matrix = new String[matrixSize][matrixSize];
        int[] positionSquirrel = new int[2];
        for (int i = 0; i < matrixSize; i++) {
            matrix[i] = scanner.nextLine().split("");
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j].equals("s")) {
                    positionSquirrel[0] = i;
                    positionSquirrel[1] = j;
                }
            }
        }
        boolean trap = true;
        int countHazelnut = 0;
        int positionRow = positionSquirrel[0];
        int positionCol = positionSquirrel[1];
        while (countHazelnut != 3 && isOutMatrix(matrix, positionRow, positionCol)
                && trap && commands.size() != 0) {
            String command = commands.get(0);
            commands.remove(0);
            switch (command) {
                case "left":
                    if (positionCol - 1 < 0) {
                        positionCol--;
                        break;
                    }
                    if (matrix[positionRow][positionCol - 1].equals("*")) {
                        matrix[positionRow][positionCol] = "*";
                        matrix[positionRow][positionCol - 1] = "s";
                        positionCol--;
                    } else if (matrix[positionRow][positionCol - 1].equals("h")) {
                        matrix[positionRow][positionCol] = "*";
                        matrix[positionRow][positionCol - 1] = "s";
                        positionCol--;
                        countHazelnut++;
                    } else if (matrix[positionRow][positionCol - 1].equals("t")) {
                        matrix[positionRow][positionCol] = "*";
                        trap = false;
                    }
                    break;
                case "right":
                    if (positionCol + 1 > matrixSize - 1) {
                        positionCol++;
                        break;
                    }
                    if (matrix[positionRow][positionCol + 1].equals("*")) {
                        matrix[positionRow][positionCol] = "*";
                        matrix[positionRow][positionCol + 1] = "s";
                        positionCol++;
                    } else if (matrix[positionRow][positionCol + 1].equals("h")) {
                        matrix[positionRow][positionCol] = "*";
                        matrix[positionRow][positionCol + 1] = "s";
                        positionCol++;
                        countHazelnut++;
                    } else if (matrix[positionRow][positionCol + 1].equals("t")) {
                        matrix[positionRow][positionCol] = "*";
                        trap = false;
                    }
                    break;
                case "up":
                    if (positionRow - 1 < 0) {
                        positionRow--;
                        break;
                    }
                    if (matrix[positionRow - 1][positionCol].equals("*")) {
                        matrix[positionRow][positionCol] = "*";
                        matrix[positionRow - 1][positionCol] = "s";
                        positionRow--;
                    } else if (matrix[positionRow - 1][positionCol].equals("h")) {
                        matrix[positionRow][positionCol] = "*";
                        matrix[positionRow - 1][positionCol] = "s";
                        positionRow--;
                        countHazelnut++;
                    } else if (matrix[positionRow - 1][positionCol].equals("t")) {
                        matrix[positionRow][positionCol] = "*";
                        trap = false;
                    }
                    break;
                case "down":
                    if (positionRow + 1 > matrixSize - 1) {
                        positionCol++;
                        break;
                    }
                    if (matrix[positionRow + 1][positionCol].equals("*")) {
                        matrix[positionRow][positionCol] = "*";
                        matrix[positionRow + 1][positionCol] = "s";
                        positionRow++;
                    } else if (matrix[positionRow + 1][positionCol].equals("h")) {
                        matrix[positionRow][positionCol] = "*";
                        matrix[positionRow + 1][positionCol] = "s";
                        positionRow++;
                        countHazelnut++;
                    } else if (matrix[positionRow + 1][positionCol].equals("t")) {
                        matrix[positionRow][positionCol] = "*";
                        trap = false;
                    }
                    break;
            }
        }
        if (countHazelnut == 3) {
            System.out.println("Good job! You have collected all hazelnuts!");
            System.out.println("Hazelnuts collected: " + countHazelnut);
        } else if (!trap) {
            System.out.println("Unfortunately, the squirrel stepped on a trap...");
            System.out.println("Hazelnuts collected: " + countHazelnut);
        }  else if (!isOutMatrix(matrix, positionRow, positionCol)) {
            System.out.println("The squirrel is out of the field.");
            System.out.println("Hazelnuts collected: " + countHazelnut);
        }else {
            System.out.println("There are more hazelnuts to collect.");
            System.out.println("Hazelnuts collected: " + countHazelnut);
        }
    }

    public static boolean isOutMatrix(String[][] matrix, int row, int col) {
        if (row < 0 || matrix.length-1 < row) {
            return false;
        }
        for (int i = 0; i < matrix.length; i++) {
            if (col < 0 || matrix[i].length-1 < col) {
                return false;
            }
        }
        return true;
    }

}
