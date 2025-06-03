public class Substring {

    public static void main(String[] args) {
        // Give me a complete implementable code for 8Queens problem using backtracking in Java
        int n = 8; // Size of the chessboard
        boolean[][] board = new boolean[n][n];
        if (solveNQueens(board, 0)) {
            printBoard(board);
        } else {
            System.out.println("No solution exists");
        }

    }

    private static boolean solveNQueens(boolean[][] board, int col) {
        if (col >= board.length) {
            return true;
        }
        for (int i = 0; i < board.length; i++) {
            if (isSafe(board, i, col)) {
                board[i][col] = true;
                if (solveNQueens(board, col + 1)) {
                    return true;
                }
                board[i][col] = false;
            }
        }
        return false;
    }

    private static boolean isSafe(boolean[][] board, int row, int col) {
        // Check this row on left side
        for (int i = 0; i < col; i++) {
            if (board[row][i]) {
                return false;
            }
        }
        // Check upper diagonal on left side
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j]) {
                return false;
            }
        }
        // Check lower diagonal on left side
        for (int i = row, j = col; j >= 0 && i < board.length; i++, j--) {
            if (board[i][j]) {
                return false;
            }
        }
        return true;
    }

    private static void printBoard(boolean[][] board) {
        for (boolean[] row : board) {
            for (boolean cell : row) {
                System.out.print(cell ? "Q " : ". ");
            }
            System.out.println();
        }
    }
    
}
