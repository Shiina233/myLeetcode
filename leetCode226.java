package LeetCode;

import java.util.LinkedList;
import java.util.Queue;

/*
翻转一棵二叉树。
 */
public class leetCode226 {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    public TreeNode invertTree(TreeNode root)
    {
        if(root == null)
            return root;
        TreeNode oldLeft = root.left;
        TreeNode oldRight = root.right;
        root.left = oldRight;
        root.right = oldLeft;
        root.left = invertTree(root.left);
        root.right = invertTree(root.right);
        return root;
    }






}
