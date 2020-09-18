package LeetCode;
/*
给定一个二叉树，找出其最小深度。

最小深度是从根节点到最近叶子节点的最短路径上的节点数量。

说明: 叶子节点是指没有子节点的节点。
 */
public class leetCode111 {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

  //当一个节点的其中一个为空时，不能直接算，因为直接为空的话返回0，另一个子树返回1，min()就会取0，加1就是1，事实上应该是2，不能把空节点
    //当成叶子节点。
  public int minDepth(TreeNode root)
  {
      if(root == null)
          return 0;

      if(root.left == null && root.right != null)
          return 1+minDepth(root.right);
      if(root.right == null && root.left!=null)
          return 1+minDepth(root.left);
      return Math.min(minDepth(root.right),minDepth(root.left))+1;
  }
}
