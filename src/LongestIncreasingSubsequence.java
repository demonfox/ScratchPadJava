public class LongestIncreasingSubsequence {
  public int longestIncreasingSubsequence(int[] nums) {
    int[] LIS = new int[nums.length];
    LIS[0] = 1;
    for (int i=1; i<nums.length; i++) {
      LIS[i] = 1;
      for (int j=0; j<=i-1; j++) {
        if (nums[i] > nums[j]) {
          LIS[i] = Math.max(LIS[j]+1, LIS[i]);
        }
      }
    }

    int lastIndexInLIS = 0;
    int currLen = 1;
    for (int i=0; i<nums.length; i++) {
      if (LIS[i] > currLen) {
        lastIndexInLIS = i;
        currLen++;
      }
    }
    StringBuilder sb = new StringBuilder();
    int result = currLen;
    currLen--;
    sb.insert(0, nums[lastIndexInLIS]);    
    for (int i=lastIndexInLIS-1; i>=0; i--) {
      if (LIS[i] == currLen) {
        sb.insert(0, nums[i] + " ");
        currLen--;
      }
    }

    System.out.println(sb.toString());

    return result;
  }

  public static void main(String[] args) {
    LongestIncreasingSubsequence lis = new LongestIncreasingSubsequence();
    System.out.println(lis.longestIncreasingSubsequence(new int[]{2,3,9,8,10,7,5,6,12,13,9,8}));
  }
}
