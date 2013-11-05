
public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        int[] canary = new int[26];
        int currStartPos = 0;
        int currMax = 0;
        int currLen = 0;
        for (int i = 0; i < 26; i++) {
            canary[i] = -1;
        }
        
        for (int i = 0; i < s.length(); i++) {
            int index = 0;
            if (s.charAt(i) >= 'a')
                index = (int)(s.charAt(i) - 'a');
            else
                index = (int)(s.charAt(i) - 'A');
            if (canary[index] == -1) {
                canary[index] = i;
                currLen++;
            }
            else if (canary[index] < currStartPos) {
                canary[index] = i;
                currLen++;
            } else {
                currStartPos = canary[index] + 1;
                currLen = i - canary[index];
                canary[index] = i;
            }
            
            if(currLen > currMax)
                currMax = currLen;
        }
        
        return currMax;
    }
    
    public static void main(String[] args) {
        LengthOfLongestSubstring s = new LengthOfLongestSubstring();
        int result = s.lengthOfLongestSubstring("bbbb");
        System.out.println(result);
        char c = 'a';
        int t = (int)c;
        System.out.println(t);
    }
}
