// 给定长度为n的数组，每个元素代表一个木头的长度，木头可以任意截断，从这堆木头中截出至少k个
// 相同长度为m的木块。已知k，求max(m)

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class WoodCutting {

    public int findMaxM(int n, int k, int[] woods) {
        Arrays.sort(woods);
        System.out.println(Arrays.toString(woods));
        int start = woods.length - k;
        int end = woods.length-1;
        int minL = woods[start];
        int maxL = woods[end];
        int result = -1;
        
        while (minL <= maxL) {
            int midL = (minL + maxL)/2;
            if (canCutAtLeastK(woods, start, end, k, midL)) {
                result = midL;
                minL = midL+1;
            } else {
                maxL = midL-1;
            }
        }
        return result;
    }

    private boolean canCutAtLeastK(int[] woods, int start, int end, int k, int m) {
        int count = 0;
        for (int i=start; i<=end; i++) {
            count += woods[i]/m;
        }
        return count >= k;
    }
    public static void main(String[] args) {
        WoodCutting c = new WoodCutting();
        //System.out.println(c.findMaxM(5, 5, new int[]{4, 7, 2, 10, 5}));
        //System.out.println(c.findMaxM(5, 5, new int[]{1, 1, 1, 1, 1, 1, 1}));
        int[] input = new int[10];
        for (int i=0; i<10; i++) {
            input[i] = ThreadLocalRandom.current().nextInt(50)+1;
        }
        System.out.println(Arrays.toString(input));
        int k = ThreadLocalRandom.current().nextInt(10)+1;
        System.out.println(k);
        System.out.println(c.findMaxM(10, 
                    k, 
                    input));
    }
}
