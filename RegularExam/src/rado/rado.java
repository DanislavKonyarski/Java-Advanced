package rado;

import java.util.Scanner;

public class rado {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] arrSize = scanner.nextLine().split(",");
        int n = Integer.parseInt(arrSize[0]);
        int m = Integer.parseInt(arrSize[1]);

        char[][] matrix = new char[n][m];
        for (int row = 0; row < matrix.length; row++) {
            char[] rowData = scanner.nextLine().toCharArray();
            matrix[row] = rowData;
        }

        int mouseRow = -1;
        int mouseCol = -1;
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                if (matrix[r][c] == 'M') {
                    mouseRow = r;
                    mouseCol = c;
                }

            }
        }
        String command = scanner.nextLine();
        boolean isDimennsion = false;
        boolean isHappyMouse = false;
        boolean isTrap = false;

        while (!command.equals("danger") || isDimennsion == false || isHappyMouse==false) {
            if (command.equals("left")) {
                if (mouseCol - 1 < 0) {
                    System.out.println("No more cheese for tonight!");
                    isDimennsion = true;
                    break;
                } else {
                    mouseCol--;
                    if (matrix[mouseRow][mouseCol] == 'C') {
                        matrix[mouseRow][mouseCol] = 'M';
                        matrix[mouseRow][mouseCol+1] = '*';
                        int otherCheseRow = -1;
                        int otherCheseCol = -1;
                        for (int r = 0; r < matrix.length; r++) {
                            for (int c = 0; c < matrix[r].length; c++) {
                                if (matrix[r][c] == 'C') {
                                    otherCheseRow = r;
                                    otherCheseCol = c;
                                }
                            }
                        }
                        if (otherCheseRow == -1 && otherCheseCol == -1) {
                            matrix[mouseRow][mouseCol] = 'M';
                            matrix[mouseRow][mouseCol+1]='*';
                            isHappyMouse = true;
                        }
                    } else if (matrix[mouseRow][mouseCol] == 'T') {
                        isTrap = true;
                        matrix[mouseRow][mouseCol+1] = '*';
                        matrix[mouseRow][mouseCol] = 'M';
                    } else if (matrix[mouseRow][mouseCol] == '@') {
                        mouseCol++;
                    } else if (matrix[mouseRow][mouseCol] == '*') {
                        matrix[mouseRow][mouseCol] = 'M';
                        matrix[mouseRow][mouseCol+1] = '*';
                    }
                }
            } else if (command.equals("right")) {
                if (mouseCol + 1 > matrix.length) {
                    System.out.println("No more cheese for tonight!");
                    isDimennsion = true;
                } else {
                    mouseCol++;
                    if (matrix[mouseRow][mouseCol] == 'C') {
                        matrix[mouseRow][mouseCol] = '*';
                        int otherCheseRow = -1;
                        int otherCheseCol = -1;
                        for (int r = 0; r < matrix.length; r++) {
                            for (int c = 0; c < matrix[r].length; c++) {
                                if (matrix[r][c] == 'C') {
                                    otherCheseRow = r;
                                    otherCheseCol = c;
                                }
                            }
                        }
                        if (otherCheseRow == -1 && otherCheseCol == -1) {
                            matrix[mouseRow][mouseCol] = 'M';
                            isHappyMouse = true;
                        }
                    } else if (matrix[mouseRow][mouseCol] == 'T') {
                        isTrap = true;
                        matrix[mouseRow][mouseCol] = 'M';
                    } else if (matrix[mouseRow][mouseCol] == '@') {
                        mouseCol--;
                    } else if (matrix[mouseRow][mouseCol] == '*') {
                        matrix[mouseRow][mouseCol-1] = 'M';
                        matrix[mouseRow][mouseCol] = '*';
                    }
                }
            } else if (command.equals("up")) {
                if (mouseRow - 1 < 0) {
                    System.out.println("No more cheese for tonight!");
                    isDimennsion = true;
                } else {
                    mouseRow--;
                    if (matrix[mouseRow][mouseCol] == 'C') {
                        matrix[mouseRow][mouseCol] = '*';
                        int otherCheseRow = -1;
                        int otherCheseCol = -1;
                        for (int r = 0; r < matrix.length; r++) {
                            for (int c = 0; c < matrix[r].length; c++) {
                                if (matrix[r][c] == 'C') {
                                    otherCheseRow = r;
                                    otherCheseCol = c;
                                }
                            }
                        }
                        if (otherCheseRow == -1 && otherCheseCol == -1) {
                            matrix[mouseRow][mouseCol] = 'M';
                            isHappyMouse = true;
                        }
                    } else if (matrix[mouseRow][mouseCol] == 'T') {
                        isTrap = true;
                        matrix[mouseRow][mouseCol] = 'M';
                    } else if (matrix[mouseRow][mouseCol] == '@') {
                        mouseRow++;
                    } else if (matrix[mouseRow][mouseCol] == '*') {
                        matrix[mouseRow+1][mouseCol] = 'M';
                        matrix[mouseRow][mouseCol] = '*';
                    }
                }
            } else if (command.equals("down")) {
                if (mouseRow + 1 > matrix.length) {
                    System.out.println("No more cheese for tonight!");
                    isDimennsion = true;
                } else {
                    mouseRow++;
                    if (matrix[mouseRow][mouseCol] == 'C') {
                        matrix[mouseRow][mouseCol] = '*';
                        int otherCheseRow = -1;
                        int otherCheseCol = -1;
                        for (int r = 0; r < matrix.length; r++) {
                            for (int c = 0; c < matrix[r].length; c++) {
                                if (matrix[r][c] == 'C') {
                                    otherCheseRow = r;
                                    otherCheseCol = c;
                                }
                            }
                        }
                        if (otherCheseRow == -1 && otherCheseCol == -1) {
                            matrix[mouseRow][mouseCol] = 'M';
                            isHappyMouse = true;
                        }
                    } else if (matrix[mouseRow][mouseCol] == 'T') {
                        isTrap = true;
                        matrix[mouseRow][mouseCol] = 'M';
                    } else if (matrix[mouseRow][mouseCol] == '@') {
                        mouseRow--;
                    } else if (matrix[mouseRow][mouseCol] == '*') {
                        matrix[mouseRow-1][mouseCol] = 'M';
                        matrix[mouseRow][mouseCol] = '*';
                    }
                }
            }
            if (isTrap||isHappyMouse){
                break;
            }
            command = scanner.nextLine();
        }

        if (isTrap){
            System.out.println("Mouse is trapped!");
        } else if (isHappyMouse) {
            System.out.println("Happy mouse! All the cheese is eaten, good night!");
        }
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                System.out.print(matrix[r][c]);
            }
            System.out.println();
        }
    }
}
