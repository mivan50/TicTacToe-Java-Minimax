import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        int turn = 1;
        boolean gameEnd = false;
        char[][] board = new char[3][3];
        Board.initializeBoard(board);
        char currPlayer;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Would you like to go first or second");
        String ans = scanner.next();
        if (ans.equals("first")) {
            currPlayer = 'X';
        }
        else {
            currPlayer = 'O';
        }

        while (!gameEnd) {
            Board.displayBoard(board);

            if (currPlayer == 'X') {
                System.out.println("Enter the row and column (e.g., 1 2):");
                int row = scanner.nextInt();
                int col = scanner.nextInt();

                while (row > 2 || col > 2 || !Board.PlayerMove(row, col, board)) {
                    System.out.println("That position is not available, enter the row and column (e.g., 1 2):");
                    row = scanner.nextInt();
                    col = scanner.nextInt();
                }
            }
            else {
                System.out.println("Computer's move:");
                int[] compMove = Minimax.findBestMove(board);
                board[compMove[0]][compMove[1]] = 'O';
            }

            char winner = Board.checkWinner(board);
            ++turn;
            if (winner != ' ') {
                Board.displayBoard(board);
                if (winner == 'X') {
                    System.out.println("Player has won!");
                }
                else {
                    System.out.println("Computer has won!");
                }

                gameEnd = true;
            }
            else if (turn == 10) {
                Board.displayBoard(board);
                System.out.println("It's a tie!");
                gameEnd = true;
            }

            if (currPlayer == 'X') {
                currPlayer = 'O';
            }
            else {
                currPlayer = 'X';
            }
        }
    }
}