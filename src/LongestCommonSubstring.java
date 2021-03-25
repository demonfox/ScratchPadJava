public class LongestCommonSubstring {
  public String lcs(String t1, String t2) {
    StringBuilder lcsString = new StringBuilder();
    int m = t1.length();
    int n = t2.length();
    int[][] lcsCount = new int[m+1][n+1];
    for (int i=0; i<m+1; i++)
      lcsCount[i][0] = 0;
    for (int j=0; j<n+1; j++)
      lcsCount[0][j] = 0;
    int currMax = 0;
    int lastStartIndex = -1;
    for (int i=1; i<m+1; i++) {
      for (int j=1; j<n+1; j++) {
        if (t1.charAt(i-1) == t2.charAt(j-1)) {
          lcsCount[i][j] = lcsCount[i-1][j-1] + 1;
          if (lcsCount[i][j] > currMax) {
            currMax = lcsCount[i][j];
            int currStartIndex = (i-1) - lcsCount[i][j] + 1;
            if (currStartIndex == lastStartIndex) {
              lcsString.append(t1.charAt(i-1));
            } else {
              lastStartIndex = currStartIndex;
              lcsString.setLength(0);
              lcsString.append(t1.substring(currStartIndex, i));
            }
          }
        } else {
          lcsCount[i][j] = 0;
        }
      }
    }
    return lcsString.toString();
  }

  public static void main(String[] args) {
    LongestCommonSubstring lcs = new LongestCommonSubstring();
    System.out.println(lcs.lcs("varena", "varenaesportsarena"));
    System.out.println(lcs.lcs("varena", "vaarenaesportsarena"));
  }
}
