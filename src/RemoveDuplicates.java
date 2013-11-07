
public class RemoveDuplicates {

	public int removeDuplicates(int[] A) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
		if (A.length == 0)
			return 0;
		
		int prevNum = A[0];
		int prevIndex = 0;
		
        for (int i=1; i<A.length; i++) {
        	if (A[i] != prevNum) {
        		prevIndex++;
        		A[prevIndex] = A[i];
        		prevNum = A[i];
        	}
        }
        
        return prevIndex + 1;
    }
	
	private static void printArray(int[] A, int length) {
		for (int i = 0; i < length; i++) {
			System.out.print(A[i] + " ");
		}
	}
	public static void main(String[] args) {
		RemoveDuplicates r = new RemoveDuplicates();
		int[] A = new int[] { 1, 1, 2, 2, 2, 3, 4, 4, 5 };
		int newLength = r.removeDuplicates(A);
		System.out.println(newLength);
		printArray(A, newLength);
	}

}
