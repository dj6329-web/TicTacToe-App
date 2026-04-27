import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
    static char[][] board = new char[3][3];
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        createBoard();
        
        // UC3: Get Input
        int slot = getUserSlot();
        
        // UC4: Convert and Display Mapping
        int row = getRowFromSlot(slot);
        int col = getColFromSlot(slot);
        
        System.out.println("Slot entered: " + slot);
        System.out.println("Mapped to Row: " + row + ", Column: " + col);
        
        displayBoard();
    }

    /**
     * UC4: Converts slot number (1-9) into row index (0-2)
     */
    static int getRowFromSlot(int slot) {
        return (slot - 1) / 3;
    }

    /**
     * UC4: Converts slot number (1-9) into column index (0-2)
     */
    static int getColFromSlot(int slot) {
        return (slot - 1) % 3;
    }

    // --- Previous Methods ---
    public static int getUserSlot() {
        System.out.print("Enter a slot number (1-9): ");
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