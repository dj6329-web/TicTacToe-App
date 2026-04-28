import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
    static char[][] board = new char[3][3];
    static Scanner sc = new Scanner(System.in);
    
    // UC2 State Variables
    static boolean isHumanTurn;
    static char humanSymbol;
    static char computerSymbol;

    public static void main(String[] args) {
        createBoard();
        tossAndAssignSymbols();
        
        // Show initial state
        displayBoard();
        
        // --- UC3, UC4, UC5 Logic ---
        int slot = getUserSlot();
        int row = getRowFromSlot(slot);
        int col = getColFromSlot(slot);
        
        if (isValidMove(row, col)) {
            // UC6: Actually update the board
            // Using a ternary operator to decide which symbol to place
            char currentSymbol = isHumanTurn ? humanSymbol : computerSymbol;
            placeMove(row, col, currentSymbol);
            
            System.out.println("Move placed successfully!");
        } else {
            System.out.println("Invalid move!");
        }
        
        // Show updated board
        displayBoard();
    }

    /**
     * UC6: Updates the board by placing the given symbol 
     * at the specified row and column.
     */
    static void placeMove(int row, int col, char symbol) {
        board[row][col] = symbol;
    }

    // --- UC5: Validation ---
    static boolean isValidMove(int row, int col) {
        return (row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == '-');
    }

    // --- UC4: Conversion ---
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
        System.out.println("\n--- Current Board ---");
        for (int i = 0; i < 3; i++) {
            System.out.println(" " + board[i][0] + " | " + board[i][1] + " | " + board[i][2]);
            if (i < 2) System.out.println("-----------");
        }
    }

    public static void tossAndAssignSymbols() {
        Random random = new Random();
        isHumanTurn = random.nextBoolean();
        humanSymbol = isHumanTurn ? 'X' : 'O';
        computerSymbol = (humanSymbol == 'X') ? 'O' : 'X';
        System.out.println("Toss won by: " + (isHumanTurn ? "Human" : "Computer"));
    }
}