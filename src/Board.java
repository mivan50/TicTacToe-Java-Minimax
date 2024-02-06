public class Board {
    private char[][] board;

    public Board() {
        board = new char[3][3];
        initializeBoard();
    }

    private void initializeBoard() {
        for (int row = 0; row < 3; ++row) {
            for (int col = 0; col < 3; ++col) {
                board[row][col] = ' ';
            }
        }
    }

    public void displayBoard() {
        System.out.println("-------------");
        for (int row = 0; row < 3; row++) {
            System.out.print("| ");
            for (int col = 0; col < 3; col++) {
                System.out.print(board[row][col] + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }

    public boolean PlayerMove(int input, int turn) {
        int row = input / 10;
        int col = input % 10;

        if (board[row][col] != ' ') {
            return false;
        }

        board[row][col] = getSymbol(turn);
        return true;
    }

    private char getSymbol(int turn) {
        if (turn % 2 == 1) {
            return 'X';
        }
        return 'O';
    }

    public char checkWinner() {
        for (int i=0; i<3; ++i) {
            if (board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][0] != ' ') {
                return board[i][0];
            }
            if (board[0][i] == board[1][i] && board[1][i] == board[2][i] && board[0][i] != ' ') {
                return board[0][i];
            }
        }

        if (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != ' ') {
            return board[0][0];
        }

        if (board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[0][2] != ' ') {
            return board[0][2];
        }

        return ' ';
    }

}
