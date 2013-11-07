
public class NumDistinct {

	public int numDistinct(String S, String T) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
		
		int[][] count = new int[T.length()+1][S.length()+1];
		
		count[0][0] = 1;
		
		for (int i = 1; i <= T.length(); i++) {
			count[i][0] = 0;
		}  
		for (int j = 1; j <= S.length(); j++) {  
			count[0][j] = 1;
		}
		
		for (int i=1; i<=T.length(); i++) {
			for (int j=1; j<=S.length(); j++) {
				count[i][j] = count[i][j-1];
				if (T.charAt(i-1) == S.charAt(j-1))
					count[i][j] += count[i-1][j-1];
			}
		}
		
		return count[T.length()][S.length()];
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    NumDistinct n = new NumDistinct();
	    System.out.println(n.numDistinct("rabbbit", "rabit"));
	    System.out.println(n.numDistinct("w", "w"));
	}

}
