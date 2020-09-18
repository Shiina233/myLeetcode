package LeetCode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class leetCode107
{
    public class TreeNode
    {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }



  public List<List<Integer>> levelOrder(TreeNode root)
  {
      LinkedList<List<Integer>> result = new LinkedList<>();
      if(root == null)
          return result;
      Queue<TreeNode> queue = new LinkedList<>();
      queue.add(root);
      while(!queue.isEmpty())
      {
          List<Integer> theLevel = new LinkedList<>();
          int length = queue.size();
          for(int i=0;i<length;i++)
          {
              TreeNode old = queue.poll();
              theLevel.add(old.val);
              if(old.left != null)
                  queue.add(old.left);
              if(old.right != null)
                  queue.add(old.right);
          }
          result.addFirst(theLevel);
      }
      return result;
  }

}
