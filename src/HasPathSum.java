
public class HasPathSum {

    public boolean hasPathSum(TreeNode root, int sum) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        
        if (root == null)
            return false;
        
        if (root.left == null && root.right == null)
            return root.val == sum;
        
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }
    
    public boolean hasPathSumHelper(TreeNode root, int sum) {
        if (root == null)
            return sum == 0;
        
        return hasPathSumHelper(root.left, sum - root.val) || hasPathSumHelper(root.right, sum - root.val);
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        //         5
        //        / \
        //       4   8
        //      /   / \
        //     11  13  4
        //    /  \      \
        //   7    2      1
    
        TreeNode n1 = new TreeNode(5);
        TreeNode n2 = new TreeNode(4);
        TreeNode n3 = new TreeNode(8);
        TreeNode n4 = new TreeNode(11);
        TreeNode n5 = new TreeNode(13);
        TreeNode n6 = new TreeNode(4);
        TreeNode n7 = new TreeNode(7);
        TreeNode n8 = new TreeNode(2);
        TreeNode n9 = new TreeNode(1);
        
        n1.left = n2; n1.right = n3;
        n2.left = n4;
        n3.left = n5; n3.right = n6;
        n4.left = n7; n4.right = n8;
        n6.right = n9;
        
        TreeNode n10 = new TreeNode(1);
        TreeNode n11 = new TreeNode(2);
        
        n10.left = n11;
        
        HasPathSum h = new HasPathSum();
        System.out.println(h.hasPathSum(n1, 22));
        System.out.println(h.hasPathSum(n10, 1));
    }

}
