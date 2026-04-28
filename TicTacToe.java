import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
    static char[][] board = new char[3][3];
    static Scanner sc = new Scanner(System.in);
    static Random random = new Random(); // Reuse random for UC7

    static boolean isHumanTurn;
    static char humanSymbol;
    static char computerSymbol;

    public static void main(String[] args) {
        createBoard();
        tossAndAssignSymbols();
        
        // UC7: Simulate the computer taking its first turn
        System.out.println("--- Computer is thinking... ---");
        computerMove();
        
        displayBoard();
    }

    /**
     * UC7: Generates random slots until a valid one is found, 
     * then places the computer's symbol.
     */
    static void computerMove() {
        boolean movePlaced = false;
        
        while (!movePlaced) {
            // Generate random slot between 1 and 9
            int slot = random.nextInt(9) + 1; 
            int row = getRowFromSlot(slot);
            int col = getColFromSlot(slot);
            
            // Reuse validation logic from UC5
            if (isValidMove(row, col)) {
                placeMove(row, col, computerSymbol);
                System.out.println("Computer placed " + computerSymbol + " in slot " + slot);
                movePlaced = true;
            }
        }
    }

    // --- Helper Methods (Reused from UC4, UC5, UC6) ---
    static int getRowFromSlot(int slot) { return (slot - 1) / 3; }
    static int getColFromSlot(int slot) { return (slot - 1) % 3; }
    
    static boolean isValidMove(int row, int col) {
        return (row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == '-');
    }

    static void placeMove(int row, int col, char symbol) {
        board[row][col] = symbol;
    }

    // --- Setup Methods ---
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

    public static void tossAndAssignSymbols() {
        isHumanTurn = random.nextBoolean();
        humanSymbol = isHumanTurn ? 'X' : 'O';
        computerSymbol = (humanSymbol == 'X') ? 'O' : 'X';
    }
}