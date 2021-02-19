public class EightQueens {
    public static Boolean solve(int[][] board, int N, int col) {
        if (col >= N)
            return true;
        for (int i=0; i<N; i++) {            
            if (isSafe(board, N, i, col)) {
                board[i][col] = 1;
                if (solve(board, N, col+1) == true)
                    return true;
                board[i][col] = 0;
            }
        }
        return false;
    }

    public static Boolean isSafe(int[][] board, int N, int row, int col) {
        // check no queen is on the same row or the same diagonal
        for (int i=0; i<col; i++) {
            if (board[row][i] == 1)
                return false;
            int dist = col - i;
            if (row - dist >=0 && board[row-dist][i] == 1)
                return false;
            if (row + dist < N && board[row+dist][i] == 1)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] board = new int[][]{ {0, 0, 0, 0, 0, 0, 0, 0},
                                     {0, 0, 0, 0, 0, 0, 0, 0},
                                     {0, 0, 0, 0, 0, 0, 0, 0},
                                     {0, 0, 0, 0, 0, 0, 0, 0},
                                     {0, 0, 0, 0, 0, 0, 0, 0},
                                     {0, 0, 0, 0, 0, 0, 0, 0},
                                     {0, 0, 0, 0, 0, 0, 0, 0},
                                     {0, 0, 0, 0, 0, 0, 0, 0}
                                    };
        if (solve(board, 8, 0) == true) {
            System.out.println("Here is the solution for the 8-Queens problem:");
            for (int i=0; i<8; i++) {
                for (int j=0; j<8; j++) {
                    System.out.print(board[i][j]);
                    System.out.print(" ");
                }
                System.out.println("");
            }
        }
    }    
}
