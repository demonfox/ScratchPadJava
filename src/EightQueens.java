import java.util.HashSet;
import java.util.Set;

public class EightQueens {
  public static Boolean solve(int[][] board, int N, int row) {
    if (row >= N)
      return true;
    for (int j = 0; j < N; j++) {
      if (isSafe(board, N, row, j)) {
        board[row][j] = 1;
        if (solve(board, N, row + 1) == true)
          return true;
        board[row][j] = 0;
      }
    }
    return false;
  }

  private static Boolean isSafe(int[][] board, int N, int row, int col) {
    // check no queen is on the same row or the same diagonal
    for (int i = 0; i < row; i++) {
      if (board[i][col] == 1)
        return false;
      int dist = row - i;
      if (col - dist >= 0 && board[i][col-dist] == 1)
        return false;
      if (col + dist < N && board[i][col+dist] == 1)
        return false;
    }
    return true;
  }

  private static Set<Integer> cols = new HashSet<Integer>();
  private static Set<Integer> pies = new HashSet<Integer>();
  private static Set<Integer> nas = new HashSet<Integer>();
  public static Boolean solve2(int[][] board, int N, int row) {
    if (row >= N)
      return true;
    for (int j=0; j<N; j++) {
      if (cols.contains(j) || pies.contains(row+j) || nas.contains(row-j))
        continue;
      cols.add(j);
      pies.add(row+j);
      nas.add(row-j);
      board[row][j] = 1;
      if (solve2(board, N, row+1))
        return true;
      cols.remove(j);
      pies.remove(row+j);
      nas.remove(row-j);
      board[row][j] = 0;
    }
    return false;
  }

  public static void main(String[] args) {
    int[][] board = new int[][] { {0, 0, 0, 0, 0, 0, 0, 0},
                                  {0, 0, 0, 0, 0, 0, 0, 0},
                                  {0, 0, 0, 0, 0, 0, 0, 0},
                                  {0, 0, 0, 0, 0, 0, 0, 0},
                                  {0, 0, 0, 0, 0, 0, 0, 0},
                                  {0, 0, 0, 0, 0, 0, 0, 0},
                                  {0, 0, 0, 0, 0, 0, 0, 0},
                                  {0, 0, 0, 0, 0, 0, 0, 0}
                                };
    if (solve2(board, 8, 0) == true) {
      System.out.println("Here is the solution for the 8-Queens problem:");
      for (int i = 0; i < 8; i++) {
        for (int j = 0; j < 8; j++) {
          System.out.print(board[i][j]);
          System.out.print(" ");
        }
        System.out.println("");
      }
    }
  }
}
