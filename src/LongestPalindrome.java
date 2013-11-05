
public class LongestPalindrome {
    private String helper(String s, int c1, int c2) {
        int l = c1, r = c2;
        while (l >=0 && r <= s.length() - 1 && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        
        if (l + 2 <= r)
            return s.substring(l+1, r);
        
        return "";
    }
    public String longestPalindrome(String s) {
        if (s == "") 
            return "";
        String longest = s.substring(0, 1);
        for (int i = 0; i < s.length() - 1; i++) {
            String p1 = helper(s, i, i);
            if (p1.length() > longest.length())
                longest = p1;

            p1 = helper(s, i, i+1);
            if (p1.length() > longest.length())
                longest = p1;
        }
        
        return longest;
    }
    
    public static void main(String[] args) {
        LongestPalindrome s = new LongestPalindrome();
        String result = s.longestPalindrome("FourscoreandsevenyearsagoourfaathersbroughtforthonthiscontainentanewnationconceivedinzLibertyanddedicatedtothepropositionthatallmenarecreatedequalNowweareengagedinagreahtcivilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth");
        //String result = s.longestPalindrome("aba");
        System.out.println(result);
    }
}
