
public class IsValidBST {
    public boolean isValidBST(TreeNode root) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        return validate(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    private boolean validate(TreeNode root, int lowerBound, int upperBound) {
        if (root == null)
            return true;

        if (root.val <= lowerBound || root.val >= upperBound)
            return false;

        return validate(root.left, lowerBound, root.val) && validate(root.right, root.val, upperBound);
    }
}
