import java.util.LinkedList;
import java.util.Queue;


public class ReverseInteger {
    public int reverse(int x) {
        boolean isNegative = false;
        if (x < 0) {
            x = -x;
            isNegative = true;
        }
        Queue<Integer> q = new LinkedList<Integer>();
        while (x != 0) {
            q.add(x%10);
            x /= 10;
        }
        while (!q.isEmpty()) {
            x = 10 * x + q.remove();
        }
        if (isNegative)
            x = -x;
        return x;
    }
    
    public static void main(String[] args) {
        ReverseInteger ri = new ReverseInteger();
        System.out.println(ri.reverse(2190));
    }
}
