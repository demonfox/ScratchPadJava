public class RemoveDuplicateSubstring {
    public int removeDup(int[] nums, int k) {
        int dupCount = 0;
        int currLen = nums.length;
        int i = 0;
        for (i = 0; i < currLen; i++) {
            if (i == 0) {
                dupCount = 1;
            } else if (nums[i] == nums[i - 1]) {
                dupCount++;
            } else {
                if (dupCount >= k) {
                    int startOfDuplicates = i - dupCount;
                    currLen = cleanupArray(nums, startOfDuplicates, dupCount, currLen);
                    // restart from the position right ahead of
                    // the block of duplicates we just cleaned up
                    i = startOfDuplicates - 1;
                }
                dupCount = 1;
            }
        }
        // when we sweep until the end of the array, we need to check one more time
        if (dupCount >= k) {
            int startOfDuplicates = i - dupCount;
            currLen = cleanupArray(nums, startOfDuplicates, dupCount, currLen);
        }
        return currLen;
    }

    private int cleanupArray(int[] nums, int sIndex, int dupCount, int length) {
        if (sIndex + dupCount >= length) {
            return length - dupCount;
        } else {
            int kIndex = sIndex + dupCount;
            for (int i = kIndex; i < length; i++, sIndex++) {
                nums[sIndex] = nums[i];
            }
            return length - dupCount;
        }
    }

    private void Print(int[] nums, int len) {
        for (int i = 0; i < len; i++)
            System.out.print(nums[i] + " ");
        System.out.println();
    }

    public static void main(String args[]) {
        RemoveDuplicateSubstring s = new RemoveDuplicateSubstring();
        int[] nums = new int[] { 1, 1, 2 };
        int len = s.removeDup(nums, 2);
        s.Print(nums, len);
        nums = new int[] { 1, 1 };
        len = s.removeDup(nums, 2);
        s.Print(nums, len);
        nums = new int[] { 1, 2, 3, 3, 3, 2, 2, 4, 4, 4 };
        len = s.removeDup(nums, 2);
        s.Print(nums, len);
        nums = new int[] { 1, 4, 2, 3, 3, 3, 2, 2, 4, 5 };
        len = s.removeDup(nums, 2);
        s.Print(nums, len);
    }
}