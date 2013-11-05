import java.util.HashMap;
import java.lang.Integer;


public class TwoSum {
    public int[] twoSum(int[] numbers, int target) {
        HashMap<Integer, Integer> targetMinus = new HashMap<Integer, Integer>();
        for (int i = 0; i < numbers.length; i++) {
            targetMinus.put(target - numbers[i], i+1);
        }
        for (int i = 0; i < numbers.length; i++) {
            if (targetMinus.containsKey(numbers[i])) {
                int index1 = i+1;
                int index2 = targetMinus.get(numbers[i]).intValue();
                if (index1 < index2)
                    return new int[] {index1, index2};
                else if (index1 < index2)
                    return new int[] {index2, index1};
            }
        }
        return null;
    }
    
    public static void main(String[] args) {
        TwoSum s = new TwoSum();
        int[] result = s.twoSum(new int[] {4, 4, 15, 9}, 8);
        System.out.println(result[0]);
        System.out.println(result[1]);
    }
}
