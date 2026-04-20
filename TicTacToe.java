public class TicTacToe {

    // 2D Array to represent the 3x3 board
    static char[][] board = new char[3][3];

    public static void main(String[] args) {
        // Step 1: Initialize the board with placeholders
        initializeBoard();
        
        // Step 2: Display the board to the console
        printBoard();
    }

    /**
     * Fills the 3x3 board with '-' to indicate empty positions.
     * Uses nested loops to access each cell.
     */
    static void initializeBoard() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                board[row][col] = '-';
            }
        }
    }

    /**
     * Prints the board in a readable format with separators.
     */
    static void printBoard() {
        System.out.println("-------------");
        for (int row = 0; row < 3; row++) {
            System.out.print("| ");
            for (int col = 0; col < 3; col++) {
                System.out.print(board[row][col] + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }
}
