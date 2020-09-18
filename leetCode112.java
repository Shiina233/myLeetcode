package LeetCode;

public class leetCode112 {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    //先分析找到递归点，既然求一条路径的总和，那就用总和减去当前节点的值，再把减去后的值作为参数递归
    //
  public boolean hasPathSum(TreeNode root, int sum)
  {
      if(root == null)
          return false;
      if(root.val == sum && root.left == null && root.right == null)
          return true;
      else
          return hasPathSum(root.left, sum-root.val)||hasPathSum(root.right,sum-root.val);
  }
}
