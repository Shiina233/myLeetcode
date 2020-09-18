package LeetCode;

public class leetCode104 {
    public class TreeNode
    {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    public int maxDepth(TreeNode root) {
        if(root==null)
            return 0;
        int dl = maxDepth(root.left);
        int dr = maxDepth(root.right);
        return Math.max(dl,dr)+1;

    }






}
