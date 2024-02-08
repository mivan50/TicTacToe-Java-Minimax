public class Minimax {
    public static int minimax(char[][] board, int depth, boolean isMaximising) {
        char winner = Board.checkWinner(board);
        if (winner != ' ') {
            if (winner == 'X') {
                return -10 + depth;
            }
            else {
                return 10 - depth;
            }
        }
        if (Board.isBoardFull(board)) {
            return 0;
        }

        if (isMaximising) {
            int bestScore = Integer.MIN_VALUE;
            for (int i=0; i<3; ++i) {
                for (int j=0; j<3; ++j) {
                    if (board[i][j] == ' ') {
                        board[i][j] = 'O';
                        int score = minimax(board, depth + 1, false);
                        board[i][j] = ' ';
                        bestScore = Math.max(bestScore, score);
                    }
                }
            }
            return bestScore;
        }
        else {
            int bestScore = Integer.MAX_VALUE;
            for (int i=0; i<3; ++i) {
                for (int j=0; j<3; ++j) {
                    if (board[i][j] == ' ') {
                        board[i][j] = 'X';
                        int score = minimax(board, depth + 1, true);
                        board[i][j] = ' ';
                        bestScore = Math.min(bestScore, score);
                    }
                }
            }
            return bestScore;
        }
    }

    public static int[] findBestMove(char[][] board) {
        int bestVal = Integer.MIN_VALUE;
        int[] bestMove = {-1, -1};

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    board[i][j] = 'O';
                    int moveVal = minimax(board, 0, false);
                    board[i][j] = ' ';
                    if (moveVal > bestVal) {
                        bestMove[0] = i;
                        bestMove[1] = j;
                        bestVal = moveVal;
                    }
                }
            }
        }

        return bestMove;
    }
}
