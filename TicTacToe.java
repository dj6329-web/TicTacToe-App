import java.util.Random;
import java.util.Scanner; // Added for UC3

public class TicTacToe {
    static char[][] board = new char[3][3];
    static boolean isHumanTurn;
    static char humanSymbol;
    static char computerSymbol;
    
    // Scanner is defined here so all methods can use it
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        createBoard();
        tossAndAssignSymbols();
        displayTossResult();
        
        // UC3 Feature: Getting and showing the input
        int slot = getUserSlot();
        System.out.println("Slot entered: " + slot);
        
        displayBoard();
    }

    /**
     * UC3: Reads an integer slot value from the user.
     * Future UCs will handle validation (checking if 1-9 or if occupied).
     */
    public static int getUserSlot() {
        System.out.print("Enter a slot number (1-9): ");
        int slot = sc.nextInt();
        return slot;
    }

    // --- Previous UC Methods (Keep these) ---
    public static void tossAndAssignSymbols() {
        Random random = new Random();
        if (random.nextInt(2) == 0) {
            isHumanTurn = true;
            humanSymbol = 'X';
            computerSymbol = 'O';
        } else {
            isHumanTurn = false;
            humanSymbol = 'O';
            computerSymbol = 'X';
        }
    }

    public static void displayTossResult() {
        System.out.println("Toss Result: " + (isHumanTurn ? "Human" : "Computer") + " starts first.");
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
