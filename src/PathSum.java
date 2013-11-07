import java.util.ArrayList;

public class PathSum {
    
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if (root == null)
            return null;
        
        ArrayList<ArrayList<Integer>> answers = new ArrayList<ArrayList<Integer>>();
        
        pathSumHelper(root, sum, new ArrayList<Integer>(), answers);
        
        return answers;
    }
    
    public boolean pathSumHelper(TreeNode curr, int sum, ArrayList<Integer> path, ArrayList<ArrayList<Integer>> answers) {
        if (curr == null)
            return false;
                
        path.add(curr.val);
        
        if (curr.left == null && curr.right == null && curr.val == sum) {
            ArrayList<Integer> answer = new ArrayList<Integer>();
            answer.addAll(path);
            answers.add(answer);
            path.remove(path.size()-1);
            return true;
        }
        
        boolean resultLeft = pathSumHelper(curr.left, sum - curr.val, path, answers);
        boolean resultRight = pathSumHelper(curr.right, sum - curr.val, path, answers);
        
        path.remove(path.size()-1);
        
        return resultLeft || resultRight;
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub

        //         5
        //        / \
        //       4   8
        //      /   / \
        //     11  13  4
        //    /  \    / \
        //   7    2  5   1
 
        TreeNode n1  = new TreeNode(5);
        TreeNode n2  = new TreeNode(4);
        TreeNode n3  = new TreeNode(8);
        TreeNode n4  = new TreeNode(11);
        TreeNode n5  = new TreeNode(13);
        TreeNode n6  = new TreeNode(4);
        TreeNode n7  = new TreeNode(7);
        TreeNode n8  = new TreeNode(2);
        TreeNode n9  = new TreeNode(5);
        TreeNode n10 = new TreeNode(1);
     
        n1.left = n2; n1.right = n3;
        n2.left = n4;
        n3.left = n5; n3.right = n6;
        n4.left = n7; n4.right = n8;
        n6.left = n9; n6.right = n10;
     
        PathSum p = new PathSum();
     
        ArrayList<ArrayList<Integer>> result = p.pathSum(n1, 22);
        
        for (ArrayList<Integer> r : result) {
            for (Integer i : r) {
                System.out.print(i + " ");
            }
            System.out.println();;
        }
    }

}
