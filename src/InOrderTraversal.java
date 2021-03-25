import java.util.Stack;

public class InOrderTraversal {
  public static void main(String[] args) {
    TreeNode n1 = new TreeNode(1);
    TreeNode n2 = new TreeNode(2);
    TreeNode n3 = new TreeNode(3);
    TreeNode n4 = new TreeNode(4);
    TreeNode n5 = new TreeNode(5);
    TreeNode n6 = new TreeNode(6);
    TreeNode n7 = new TreeNode(7);
    TreeNode n8 = new TreeNode(8);
    TreeNode n9 = new TreeNode(9);
    n1.left = n2;
    n1.right = n3;
    n2.left = n4;
    n3.left = n5;
    n3.right = n6;
    n6.right = n7;
    n2.right = n8;
    n7.left = n9;
    Stack<TreeNode> s = new Stack<>();
    TreeNode node = n1;
    while (node != null || !s.isEmpty()) {
      while(node != null) {
        s.add(node);
        node = node.left;
      }
      node = s.pop();
      System.out.println(node.val);
      node = node.right;
    }
  }

  
}
