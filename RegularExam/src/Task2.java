import java.util.Arrays;
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] sizeMatrix = Arrays.stream(scanner.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        int row = sizeMatrix[0];
        int col = sizeMatrix[1];
        String[][] matrix = new String[row][col];
        int rowMause = 0;
        int colMause = 0;
        for (int r = 0; r < row; r++) {
            matrix[r] = scanner.nextLine().split("");
            for (int c = 0; c < matrix[r].length; c++) {
                if (matrix[r][c].equals("M")) {
                    rowMause = r;
                    colMause = c;
                }
            }
        }
        String command = scanner.nextLine();
        boolean isOutOfCupboard = false;
        boolean isFinishCheese = false;
        boolean isStepOfTrap = false;
        while (!command.equals("danger")) {
            switch (command) {
                case "left":
                    if (isOutOfMatrix(matrix, rowMause, colMause-1)){
                        isOutOfCupboard = true;
                        break;
                    }
                     if (matrix[rowMause][colMause-1].equals("C")){
                         matrix[rowMause][colMause]="*";
                         matrix[rowMause][colMause-1]="M";
                         colMause--;
                     } else if (matrix[rowMause][colMause-1].equals("*")) {
                         matrix[rowMause][colMause]="*";
                         matrix[rowMause][colMause-1]="M";
                         colMause--;
                     } else if (matrix[rowMause][colMause-1].equals("T")) {
                         matrix[rowMause][colMause]="*";
                         matrix[rowMause][colMause-1]="M";
                         colMause--;
                         isStepOfTrap = true;
                     }
                    break;
                case "right":  if (isOutOfMatrix(matrix, rowMause, colMause+1)){
                    isOutOfCupboard = true;
                    break;
                }
                    if (matrix[rowMause][colMause+1].equals("C")){
                        matrix[rowMause][colMause]="*";
                        matrix[rowMause][colMause+1]="M";
                        colMause++;
                    } else if (matrix[rowMause][colMause+1].equals("*")) {
                        matrix[rowMause][colMause]="*";
                        matrix[rowMause][colMause+1]="M";
                        colMause++;
                    } else if (matrix[rowMause][colMause+1].equals("T")) {
                        matrix[rowMause][colMause]="*";
                        matrix[rowMause][colMause+1]="M";
                        colMause++;
                        isStepOfTrap = true;
                    }
                    break;
                case "up":
                    if (isOutOfMatrix(matrix, rowMause-1, colMause)){
                        isOutOfCupboard = true;
                        break;
                    }
                    if (matrix[rowMause-1][colMause].equals("C")){
                        matrix[rowMause][colMause]="*";
                        matrix[rowMause-1][colMause]="M";
                        rowMause--;
                    } else if (matrix[rowMause-1][colMause].equals("*")) {
                        matrix[rowMause][colMause]="*";
                        matrix[rowMause-1][colMause]="M";
                        rowMause--;
                    } else if (matrix[rowMause-1][colMause].equals("T")) {
                        matrix[rowMause][colMause]="*";
                        matrix[rowMause-1][colMause]="M";
                        rowMause--;
                        isStepOfTrap = true;
                    }
                    break;
                case "down":  if (isOutOfMatrix(matrix, rowMause+1, colMause)){
                    isOutOfCupboard = true;
                    break;
                }
                    if (matrix[rowMause+1][colMause].equals("C")){
                        matrix[rowMause][colMause]="*";
                        matrix[rowMause+1][colMause]="M";
                        rowMause++;
                    } else if (matrix[rowMause+1][colMause].equals("*")) {
                        matrix[rowMause][colMause]="*";
                        matrix[rowMause+1][colMause]="M";
                        rowMause++;
                    } else if (matrix[rowMause+1][colMause].equals("T")) {
                        matrix[rowMause][colMause]="*";
                        matrix[rowMause+1][colMause]="M";
                        rowMause++;
                        isStepOfTrap = true;
                    }
                    break;
            }
            if (isOutOfCupboard||isStepOfTrap){
                break;
            }
            if (isCheeseFinish(matrix)){
                isFinishCheese = true;
                break;
            }
            command = scanner.nextLine();
        }
       if (isOutOfCupboard){
           System.out.println("No more cheese for tonight!");
       } else if (isFinishCheese) {
           System.out.println("Happy mouse! All the cheese is eaten, good night!");
       } else if (isStepOfTrap) {
           System.out.println("Mouse is trapped!");
       }else {
           System.out.println("Mouse will come back later!");
       }
        printMatrix(matrix);
    }

    private static void printMatrix(String[][] matrix) {
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                System.out.print(matrix[r][c]);
            }
            System.out.println();
        }
    }

    private static boolean isCheeseFinish(String[][] matrix) {
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                if (matrix[r][c].equals("C")){
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isOutOfMatrix(String[][] matrix, int rowMause, int colMause) {
        if (rowMause<0||rowMause>matrix.length-1||colMause<0||colMause>matrix[rowMause].length-1){
            return true;
        }
        return false;
    }
}
