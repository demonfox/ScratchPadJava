
public class ClimbStairs {
	
	public int climbStairs(int n) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        
		int f1 = 1;
		int f2 = 2;
		int fn = 0;
		
		if (n == 1)
			return f1;
		if (n == 2)
			return f2;
		
		for (int i=3; i<=n; i++) {
			fn = f2 + f1;
			f1 = f2;
			f2 = fn;
		}
		
		return fn;
    }
	
	public static void main(String[] args) {
		ClimbStairs c = new ClimbStairs();
		System.out.println(c.climbStairs(3));
		System.out.println(c.climbStairs(4));
		System.out.println(c.climbStairs(10));
	}
}
