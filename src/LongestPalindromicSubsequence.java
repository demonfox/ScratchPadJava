public class LongestPalindromicSubsequence {
  public int longestIncreasingSubsequence(String s) {
    int[][] lps = new int[s.length()][s.length()];
    for (int i=0; i<s.length(); i++)
      lps[i][i] = 1;
    int len;
    for (len=2; len<=s.length(); len++) {
      for (int i=0; i<=s.length()-len; i++) {
        int j = i + len -1;
        if (s.charAt(i) == s.charAt(j)) {
          if (len == 2)
            lps[i][j] = 2;
          else
            lps[i][j] = lps[i+1][j-1] + 2;
        } else {
          lps[i][j] = Math.max(lps[i+1][j], lps[i][j-1]);
        }
      }
    }
    
    return lps[0][s.length()-1];
  }

  public static void main(String[] args) {
    LongestPalindromicSubsequence lps = new LongestPalindromicSubsequence();
    System.out.println(lps.longestIncreasingSubsequence("AAAA"));
    System.out.println(lps.longestIncreasingSubsequence("AABAA"));
    System.out.println(lps.longestIncreasingSubsequence("AABABA"));
    System.out.println(lps.longestIncreasingSubsequence("ACABABD"));
  }
}