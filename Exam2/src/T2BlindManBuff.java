import java.util.Arrays;
import java.util.Scanner;

public class T2BlindManBuff {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] inputSizeMatrix = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int row = inputSizeMatrix[0];
        int col = inputSizeMatrix[1];
        String[][] matrix = new String[row][col];

        int[] playerCoordination = new int[2];
        for (int r = 0; r < row; r++) {
            matrix[r] = scanner.nextLine().split(" ");
            for (int c = 0; c < matrix[r].length; c++) {
                if (matrix[r][c].equals("B")){
                    playerCoordination[0] = r;
                    playerCoordination[1] = c;
                }
            }
        }
        int countPeople = 0;
        int countMove = 0;

        String input = scanner.nextLine();
        while (!input.equals("Finish")&&countPeople!=3) {

            switch (input) {
                case "left":
                    if (!isRange(matrix,playerCoordination[0],playerCoordination[1]-1)
                            ||matrix[playerCoordination[0]][playerCoordination[1]-1].equals("O")){
                        break;
                    }
                    if (matrix[playerCoordination[0]][playerCoordination[1]-1].equals("P")){
                        countPeople++;
                        countMove++;
                        matrix[playerCoordination[0]][playerCoordination[1]] = "-";
                        matrix[playerCoordination[0]][playerCoordination[1]-1] = "B";
                        playerCoordination[1] = playerCoordination[1] - 1;
                    } else if (matrix[playerCoordination[0]][playerCoordination[1]-1].equals("-")) {
                        countMove++;
                        matrix[playerCoordination[0]][playerCoordination[1]] = "-";
                        matrix[playerCoordination[0]][playerCoordination[1]-1] = "B";
                        playerCoordination[1] = playerCoordination[1] - 1;
                    }
                    break;
                case "right":if (!isRange(matrix,playerCoordination[0],playerCoordination[1]+1)
                        ||matrix[playerCoordination[0]][playerCoordination[1]+1].equals("O")){
                    break;
                }
                    if (matrix[playerCoordination[0]][playerCoordination[1]+1].equals("P")){
                        countPeople++;
                        countMove++;
                        matrix[playerCoordination[0]][playerCoordination[1]] = "-";
                        matrix[playerCoordination[0]][playerCoordination[1]+1] = "B";
                        playerCoordination[1] = playerCoordination[1] + 1;
                    } else if (matrix[playerCoordination[0]][playerCoordination[1]+1].equals("-")) {
                        countMove++;
                        matrix[playerCoordination[0]][playerCoordination[1]] = "-";
                        matrix[playerCoordination[0]][playerCoordination[1]+1] = "B";
                        playerCoordination[1] = playerCoordination[1] + 1;
                    }
                    break;
                case "up":
                    if (!isRange(matrix,playerCoordination[0]-1,playerCoordination[1])
                            ||matrix[playerCoordination[0]-1][playerCoordination[1]].equals("O")){
                        break;
                    }
                    if (matrix[playerCoordination[0]-1][playerCoordination[1]].equals("P")){
                        countPeople++;
                        countMove++;
                        matrix[playerCoordination[0]][playerCoordination[1]] = "-";
                        matrix[playerCoordination[0]-1][playerCoordination[1]] = "B";
                        playerCoordination[0] = playerCoordination[0] - 1;
                    } else if (matrix[playerCoordination[0]-1][playerCoordination[1]].equals("-")) {
                        countMove++;
                        matrix[playerCoordination[0]][playerCoordination[1]] = "-";
                        matrix[playerCoordination[0]-1][playerCoordination[1]] = "B";
                        playerCoordination[0] = playerCoordination[0] - 1;
                    }
                    break;
                case "down":
                    if (!isRange(matrix,playerCoordination[0]+1,playerCoordination[1])
                            ||matrix[playerCoordination[0]+1][playerCoordination[1]].equals("O")){
                        break;
                    }
                    if (matrix[playerCoordination[0]+1][playerCoordination[1]].equals("P")){
                        countPeople++;
                        countMove++;
                        matrix[playerCoordination[0]][playerCoordination[1]] = "-";
                        matrix[playerCoordination[0]+1][playerCoordination[1]] = "B";
                        playerCoordination[0] = playerCoordination[0] + 1;
                    } else if (matrix[playerCoordination[0]+1][playerCoordination[1]].equals("-")) {
                        countMove++;
                        matrix[playerCoordination[0]][playerCoordination[1]] = "-";
                        matrix[playerCoordination[0]+1][playerCoordination[1]] = "B";
                        playerCoordination[0] = playerCoordination[0] + 1;
                    }
                    break;
            }
            input = scanner.nextLine();
        }
        System.out.printf("Game over!%nTouched opponents: %d Moves made: %d",countPeople,countMove);
    }

    private static boolean isRange(String[][] matrix, int row, int col) {
        if (row<0||col<0||row>matrix.length-1){
            return false;
        }
        for (int i = 0; i < matrix.length; i++) {
            if (col>matrix[i].length-1){
                return false;
            }
        }
        return true;
    }
}
