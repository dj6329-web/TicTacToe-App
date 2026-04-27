import java.util.Random;

public class TicTacToe {
    // UC1 Variables
    static char[][] board = new char[3][3];

    // UC2 Variables: Game State
    static boolean isHumanTurn;
    static char humanSymbol;
    static char computerSymbol;

    public static void main(String[] args) {
        // UC1 Features
        createBoard();
        
        // UC2 Features
        tossAndAssignSymbols();
        displayTossResult();
        
        // Final Display of Empty Board from UC1
        displayBoard();
    }

    // --- UC2 Methods ---

    /**
     * Uses random logic (0 or 1) to decide who plays first.
     * Assigns 'X' to the starter and 'O' to the second player.
     */
    public static void tossAndAssignSymbols() {
        Random random = new Random();
        int toss = random.nextInt(2); // Generates 0 or 1

        if (toss == 0) {
            isHumanTurn = true;
            humanSymbol = 'X';
            computerSymbol = 'O';
        } else {
            isHumanTurn = false;
            humanSymbol = 'O';
            computerSymbol = 'X';
        }
    }

    /**
     * Prints the result of the toss to the console.
     */
    public static void displayTossResult() {
        System.out.println("Toss Result:");
        if (isHumanTurn) {
            System.out.println("Human starts first with symbol: " + humanSymbol);
            System.out.println("Computer symbol: " + computerSymbol);
        } else {
            System.out.println("Computer starts first with symbol: " + computerSymbol);
            System.out.println("Human symbol: " + humanSymbol);
        }
        System.out.println();
    }

    // --- UC1 Methods (Keep these below) ---
    public static void createBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }
    }

    public static void displayBoard() {
        for (int i = 0; i < 3; i++) {
            System.out.println(" " + board[i][0] + " | " + board[i][1] + " | " + board[i][2]);
            if (i < 2) System.out.println("-----------");
        }
    }
}
