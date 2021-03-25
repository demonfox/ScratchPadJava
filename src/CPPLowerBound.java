public class CPPLowerBound {
  public static int lowerBound(int[] nums, int target) {
    int l = 0;
    int r = nums.length-1;
    int m;
    int ll = l;
    int lr = r;
    while (l <= r) {
      m = l + (r-l)/2;
      if (nums[m] == target)
        return m;
      else if (nums[m] < target) {
        ll = l;
        l = m+1;
      } else {
        lr = r;
        r = m-1;
      }
    }

    for (m=ll; m<=lr; m++) {
      if (target < nums[m])
        return m;
    }

    return m;
  }

  public static void main(String[] args) {
    System.out.println(lowerBound(new int[]{1,2,4,5,6}, 3));
    System.out.println(lowerBound(new int[]{2,4,6,7,10,12,14,16,18,20}, 11));
    System.out.println(lowerBound(new int[]{1,2,4,5,6}, 4));
    System.out.println(lowerBound(new int[]{1,2,4,5,6}, 6));
    System.out.println(lowerBound(new int[]{1,2,4,5,6}, 1));
    System.out.println(lowerBound(new int[]{1,2,4,5,6}, 7));
  }
}
