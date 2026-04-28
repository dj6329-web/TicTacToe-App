import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
    static char[][] board = new char[3][3];
    static Scanner sc = new Scanner(System.in);
    static Random random = new Random();

    static boolean isHumanTurn;
    static char humanSymbol;
    static char computerSymbol;
    static boolean gameOver; // Moved inside the loop reset

    public static void main(String[] args) {
        char playAgain;
        
        do {
            // Reset game state for a new round
            gameOver = false;
            createBoard();
            tossAndAssignSymbols();
            System.out.println("\n--- New Game Started! ---");
            displayBoard();

            while (!gameOver) {
                if (isHumanTurn) {
                    System.out.println("\n--- Your Turn (" + humanSymbol + ") ---");
                    handleHumanTurn();
                } else {
                    System.out.println("\n--- Computer's Turn (" + computerSymbol + ") ---");
                    computerMove();
                }

                displayBoard();

                char result = checkWinner();
                if (result != '-') {
                    if (result == 'D') {
                        System.out.println("It's a Draw!");
                    } else {
                        System.out.println((result == humanSymbol ? "You" : "Computer") + " Wins!");
                    }
                    gameOver = true;
                } else {
                    isHumanTurn = !isHumanTurn;
                }
            }

            // UC10: Ask to play again
            System.out.print("\nDo you want to play again? (y/n): ");
            playAgain = sc.next().toLowerCase().charAt(0);

        } while (playAgain == 'y');

        System.out.println("Thanks for playing Tic-Tac-Toe!");
    }

    // --- REUSED METHODS (Ensure all these are present in your file) ---
    static char checkWinner() {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] != '-' && board[i][0] == board[i][1] && board[i][1] == board[i][2]) return board[i][0];
            if (board[0][i] != '-' && board[0][i] == board[1][i] && board[1][i] == board[2][i]) return board[0][i];
        }
        if (board[0][0] != '-' && board[0][0] == board[1][1] && board[1][1] == board[2][2]) return board[0][0];
        if (board[0][2] != '-' && board[0][2] == board[1][1] && board[1][1] == board[2][0]) return board[0][2];
        if (isBoardFull()) return 'D';
        return '-';
    }

    static void handleHumanTurn() {
        boolean valid = false;
        while (!valid) {
            int slot = getUserSlot();
            int r = getRowFromSlot(slot), c = getColFromSlot(slot);
            if (isValidMove(r, c)) {
                placeMove(r, c, humanSymbol);
                valid = true;
            } else System.out.println("Invalid! Try again.");
        }
    }

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

    static boolean isBoardFull() {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if (board[i][j] == '-') return false;
        return true;
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