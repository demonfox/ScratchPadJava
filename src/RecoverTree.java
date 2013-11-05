
public class RecoverTree {
    private TreeNode wrongNode1 = null;
    private TreeNode wrongNode2 = null;
    private TreeNode parentOfWrongNode1 = null;
    private TreeNode parentOfWrongNode2 = null;
    
    public void recoverTree(TreeNode root) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        validate(root, null, Integer.MIN_VALUE, Integer.MAX_VALUE);
        
        if (parentOfWrongNode1 == null) {
            root = wrongNode2;
        } else if (wrongNode1 == parentOfWrongNode1.left) {
            parentOfWrongNode1.left = wrongNode2;
        } else {
            parentOfWrongNode1.right = wrongNode2;
        }
        
        TreeNode temp1 = wrongNode2.left;
        TreeNode temp2 = wrongNode2.right;
        
        wrongNode2.left = wrongNode1.left;
        wrongNode2.right = wrongNode1.right;
        
        if (parentOfWrongNode2 == null) {
            root = wrongNode1;
        }
        if (wrongNode2 == parentOfWrongNode2.left) {
            parentOfWrongNode2.left = wrongNode1;
        } else {
            parentOfWrongNode2.right = wrongNode1;
        }
        
        wrongNode1.left = temp1;
        wrongNode1.right = temp2;
    }
    
    private void validate(TreeNode root, TreeNode parent, int lowerBound, int upperBound) {
        if (root == null)
            return;

        if (root.val <= lowerBound || root.val >= upperBound)
        {
            if (wrongNode1 == null) {
                wrongNode1 = root;
                parentOfWrongNode1 = parent;
            } else if (wrongNode2 == null) {
                wrongNode2 = root;
                parentOfWrongNode2 = parent;
            }
            
        }

        validate(root.left, root, lowerBound, root.val);
        validate(root.right, root, root.val, upperBound);
    }
    
    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(0);
        TreeNode n2 = new TreeNode(1);
        n1.left = n2;
        
        RecoverTree rt = new RecoverTree();
        rt.recoverTree(n1);
    }
}
