import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
    static char[][] board = new char[3][3];
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        createBoard();
        
        // UC3 & UC4: Get and Convert Input
        int slot = getUserSlot();
        int row = getRowFromSlot(slot);
        int col = getColFromSlot(slot);
        
        // UC5: Validation Logic
        if (isValidMove(row, col)) {
            System.out.println("Move is valid!");
            // In UC6, we will actually place the mark here
        } else {
            System.out.println("Invalid move! Position already taken or out of bounds.");
        }
        
        displayBoard();
    }

    /**
     * UC5: Checks if the move is within bounds and the cell is empty.
     * Returns true if valid, false otherwise.
     */
    static boolean isValidMove(int row, int col) {
        // Check boundary (0-2)
        if (row >= 0 && row < 3 && col >= 0 && col < 3) {
            // Check if cell is empty
            return board[row][col] == '-';
        }
        return false;
    }

    // --- Conversion Methods (UC4) ---
    static int getRowFromSlot(int slot) { return (slot - 1) / 3; }
    static int getColFromSlot(int slot) { return (slot - 1) % 3; }

    // --- Previous Methods ---
    public static int getUserSlot() {
        System.out.print("Enter slot (1-9): ");
        return sc.nextInt();
    }
    public static void createBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) board[i][j] = '-';
        }
    }
    public static void displayBoard() {
        for (int i = 0; i < 3; i++) {
            System.out.println(" " + board[i][0] + " | " + board[i][1] + " | " + board[i][2]);
            if (i < 2) System.out.println("-----------");
        }
    }
}