import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
    static char[][] board = new char[3][3];
    static Scanner sc = new Scanner(System.in);
    static Random random = new Random();

    static boolean isHumanTurn;
    static char humanSymbol;
    static char computerSymbol;
    static boolean gameOver = false; // UC8: Game state flag

    public static void main(String[] args) {
        createBoard();
        tossAndAssignSymbols();
        displayBoard();

        // UC8: Continuous Game Loop
        while (!gameOver) {
            if (isHumanTurn) {
                System.out.println("\n--- Your Turn (" + humanSymbol + ") ---");
                handleHumanTurn();
            } else {
                System.out.println("\n--- Computer's Turn (" + computerSymbol + ") ---");
                computerMove();
            }

            displayBoard();

            // Check for Win/Draw logic would go here
            // For now, we manually switch turns
            isHumanTurn = !isHumanTurn; 

            // Temporary safety break to prevent infinite loops during testing
            // Remove this once you implement win/draw detection
            if (isBoardFull()) {
                System.out.println("Board is full! Game Over.");
                gameOver = true;
            }
        }
    }

    /**
     * UC8: Helper to handle the human's input and validation cycle
     */
    static void handleHumanTurn() {
        boolean valid = false;
        while (!valid) {
            int slot = getUserSlot();
            int row = getRowFromSlot(slot);
            int col = getColFromSlot(slot);

            if (isValidMove(row, col)) {
                placeMove(row, col, humanSymbol);
                valid = true;
            } else {
                System.out.println("Invalid move! Try again.");
            }
        }
    }

    /**
     * UC8: Temporary check to stop the loop when no spots remain
     */
    static boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '-') return false;
            }
        }
        return true;
    }

    // --- REUSED METHODS FROM PREVIOUS UCs ---
    static void computerMove() {
        boolean movePlaced = false;
        while (!movePlaced) {
            int slot = random.nextInt(9) + 1;
            int r = getRowFromSlot(slot), c = getColFromSlot(slot);
            if (isValidMove(r, c)) {
                placeMove(r, c, computerSymbol);
                movePlaced = true;
            }
        }
    }

    static void placeMove(int r, int c, char s) { board[r][c] = s; }
    static boolean isValidMove(int r, int c) { return r>=0 && r<3 && c>=0 && c<3 && board[r][c]=='-'; }
    static int getRowFromSlot(int s) { return (s - 1) / 3; }
    static int getColFromSlot(int s) { return (s - 1) % 3; }
    static int getUserSlot() { System.out.print("Enter slot (1-9): "); return sc.nextInt(); }
    static void createBoard() { for(int i=0; i<3; i++) for(int j=0; j<3; j++) board[i][j]='-'; }
    static void displayBoard() {
        for(int i=0; i<3; i++) {
            System.out.println(" " + board[i][0] + " | " + board[i][1] + " | " + board[i][2]);
            if(i<2) System.out.println("-----------");
        }
    }
    static void tossAndAssignSymbols() {
        isHumanTurn = random.nextBoolean();
        humanSymbol = isHumanTurn ? 'X' : 'O';
        computerSymbol = (humanSymbol == 'X') ? 'O' : 'X';
        System.out.println("Toss result: " + (isHumanTurn ? "Human" : "Computer") + " starts first.");
    }
}