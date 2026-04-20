public class TicTacToe {
    static char[][] board = new char[3][3];

    public static void main(String[] args) {
        // Calling UC1 Features
        createBoard();
        displayBoard();
    }

    // Feature: Initialization
    public static void createBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }
    }

    // Feature: Display
    public static void displayBoard() {
        for (int i = 0; i < 3; i++) {
            System.out.println(" " + board[i][0] + " | " + board[i][1] + " | " + board[i][2]);
            if (i < 2) System.out.println("-----------");
        }
    }
}
