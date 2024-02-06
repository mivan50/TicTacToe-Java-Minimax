import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        int turn = 1;
        boolean gameEnd = false;
        Board board = new Board();
        Scanner scanner = new Scanner(System.in);

        while (!gameEnd) {
            board.displayBoard();
            System.out.println("Player " + turn%2 + ", enter the row and column (e.g., 1 2):");
            int row = scanner.nextInt();
            int col = scanner.nextInt();

            while (row > 2 || col > 2 || !board.PlayerMove(row, col, turn)) {
                System.out.println("That position is not available, enter the row and column (e.g., 1 2):");
                row = scanner.nextInt();
                col = scanner.nextInt();
            }

            char winner = board.checkWinner();
            ++turn;
            if (winner != ' ') {
                board.displayBoard();
                System.out.println(winner + " has won!");
                gameEnd = true;
            }
            else if (turn == 10) {
                board.displayBoard();
                System.out.println("It's a tie!");
                gameEnd = true;
            }
        }
    }
}