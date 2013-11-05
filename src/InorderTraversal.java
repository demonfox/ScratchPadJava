import java.util.ArrayList;


public class InorderTraversal {
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        if (root == null)
            return new ArrayList<Integer>();
        
        ArrayList<Integer> result = new ArrayList<Integer>();
        
        result.addAll(inorderTraversal(root.left));
        result.add(root.val);
        result.addAll(inorderTraversal(root.right));
        
        return result;
     }
}
