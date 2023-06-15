import java.util.Scanner;

public class T2NavyBattle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        String[][] matrix = new String[size][size];
        int[] positionSanmarine = new int[2];

        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = scanner.nextLine().split("");
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j].equals("S")) {
                    positionSanmarine[0] = i;
                    positionSanmarine[1] = j;
                }
            }
        }

        int countMines = 0;
        int countEleminateShip = 0;
        while (countMines != 3 && countEleminateShip != 3){
            String command = scanner.nextLine();
            int rowSanmarine = positionSanmarine[0];
            int colSanmarine = positionSanmarine[1];

            switch (command){
                case "left":
                    if (matrix[rowSanmarine][colSanmarine-1].equals("-")){
                        matrix[rowSanmarine][colSanmarine]="-";
                        matrix[rowSanmarine][colSanmarine-1]="S";
                        positionSanmarine[1]=positionSanmarine[1]-1;
                    } else if (matrix[rowSanmarine][colSanmarine-1].equals("*")) {
                        matrix[rowSanmarine][colSanmarine]="-";
                        matrix[rowSanmarine][colSanmarine-1]="S";
                        positionSanmarine[1]=positionSanmarine[1]-1;
                        countMines++;
                    } else if (matrix[rowSanmarine][colSanmarine-1].equals("C")) {
                        matrix[rowSanmarine][colSanmarine]="-";
                        matrix[rowSanmarine][colSanmarine-1]="S";
                        positionSanmarine[1]=positionSanmarine[1]-1;
                        countEleminateShip++;
                    }
                    break;
                case "right":
                    if (matrix[rowSanmarine][colSanmarine+1].equals("-")){
                    matrix[rowSanmarine][colSanmarine]="-";
                    matrix[rowSanmarine][colSanmarine+1]="S";
                        positionSanmarine[1]=positionSanmarine[1]+1;
                } else if (matrix[rowSanmarine][colSanmarine+1].equals("*")) {
                        matrix[rowSanmarine][colSanmarine]="-";
                        matrix[rowSanmarine][colSanmarine+1]="S";
                        positionSanmarine[1]=positionSanmarine[1]+1;
                    countMines++;
                } else if (matrix[rowSanmarine][colSanmarine+1].equals("C")) {
                        matrix[rowSanmarine][colSanmarine]="-";
                        matrix[rowSanmarine][colSanmarine+1]="S";
                        positionSanmarine[1]=positionSanmarine[1]+1;
                    countEleminateShip++;
                }
                    break;
                case "up":
                    if (matrix[rowSanmarine-1][colSanmarine].equals("-")){
                        matrix[rowSanmarine][colSanmarine]="-";
                        matrix[rowSanmarine-1][colSanmarine]="S";
                        positionSanmarine[0]=positionSanmarine[0]-1;
                    } else if (matrix[rowSanmarine-1][colSanmarine].equals("*")) {
                        matrix[rowSanmarine][colSanmarine]="-";
                        matrix[rowSanmarine-1][colSanmarine]="S";
                        positionSanmarine[0]=positionSanmarine[0]-1;
                        countMines++;
                    } else if (matrix[rowSanmarine-1][colSanmarine].equals("C")) {
                        matrix[rowSanmarine][colSanmarine]="-";
                        matrix[rowSanmarine-1][colSanmarine]="S";
                        positionSanmarine[0]=positionSanmarine[0]-1;
                        countEleminateShip++;
                    }
                    break;
                case "down":
                    if (matrix[rowSanmarine+1][colSanmarine].equals("-")){
                        matrix[rowSanmarine][colSanmarine]="-";
                        matrix[rowSanmarine+1][colSanmarine]="S";
                        positionSanmarine[0]=positionSanmarine[0]+1;
                    } else if (matrix[rowSanmarine+1][colSanmarine].equals("*")) {
                        matrix[rowSanmarine][colSanmarine]="-";
                        matrix[rowSanmarine+1][colSanmarine]="S";
                        positionSanmarine[0]=positionSanmarine[0]+1;
                        countMines++;
                    } else if (matrix[rowSanmarine+1][colSanmarine].equals("C")) {
                        matrix[rowSanmarine][colSanmarine]="-";
                        matrix[rowSanmarine+1][colSanmarine]="S";
                        positionSanmarine[0]=positionSanmarine[0]+1;
                        countEleminateShip++;
                    }
                    break;
            }
        }
        if (countEleminateShip==3){
            System.out.println("Mission accomplished, U-9 has destroyed all battle cruisers of the enemy!");
        }else {
            System.out.printf("Mission failed, U-9 disappeared! Last known coordinates [%d, %d]!%n",
                    positionSanmarine[0],positionSanmarine[1]);
        }
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                System.out.print(matrix[r][c]);
            }
            System.out.println();
        }
    }
}
