package ttt;

import java.util.Scanner;

public class TTT {

    public static int fila, columna;
    public static Scanner scan = new Scanner(System.in);
    public static char[][] board = new char[3][3];
    public static char turno = 'X';

    public static void Play() {
        boolean Playing = true;
        while (Playing) {
            System.out.println();
            System.out.println("Ingrese la fila y columna donde quiere hacer su jugada: ");

            fila = scan.nextInt() - 1;
            columna = scan.nextInt() - 1;
            board[fila][columna] = turno;

            PrintBoard();

            if (GameOver(fila, columna)) {
                Playing = false;
                System.out.println();
                System.out.println("Game Over! Player " + turno + " wins!");
            }

            if (turno == 'X') {
                turno = 'O';
            } else {
                turno = 'X';
            }

        }
    }

    public static void PrintBoard() {
        for (int i = 0; i < 3; i++) {
            System.out.println();
            for (int j = 0; j < 3; j++) {
                if (j == 0) {
                    System.out.print("| ");
                }
                System.out.print(board[i][j] + " | ");
            }
        }
        System.out.println();
    }

    public static boolean GameOver(int fMove, int cMove) {
        //Check perpendicular victory
        if (board[0][cMove] == board[1][cMove] && board[0][cMove] == board[2][cMove]) {
            return true;
        }
        if (board[fMove][0] == board[fMove][1] && board[fMove][0] == board[fMove][2]) {
            return true;
        }
        //Check diagonal victory
        if (board[0][0] == board[1][1] && board[0][0] == board[2][2] && board[1][1] != '_') {
            return true;
        }
        if (board[0][2] == board[1][1] && board[0][2] == board[2][0] && board[1][1] != '_') {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '_';
            }
        }
        Play();
    }
}
