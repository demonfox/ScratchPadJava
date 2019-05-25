import java.util.*;

public class VerifyKarlSkill {
	public static void main(String[] args) {
        HashSet<Integer> result = new HashSet<Integer>();
        ArrayList<Integer> element = new ArrayList<Integer>();
        element.add(1);
        element.add(10);
        element.add(100);
        element.add(1000);
        for (Integer var1 : element) {
            for (Integer var2 : element) {
                for (Integer var3 : element) {
                    for (Integer var4 : element) {
                        Integer id = var1 + var2 + var3 + var4;
                        if (!result.contains(id))
                            result.add(id);
                    }
                }
            }
        }

        System.out.println("Total number of skills Karl can have with 4 elements: " + result.size());
        System.out.println(result.toString());
	}
}