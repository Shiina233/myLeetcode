
public class leetCode100
{
    public class TreeNode
    {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right)
      {
          this.val = val;
          this.left = left;
          this.right = right;
      }
    }

    //不断比较两个树的对应的节点即可
    public boolean isSameTree(TreeNode p,TreeNode q)
    {
        if(p==null && q==null)
            return true;
        else if(p == null || q == null || q.val != p.val)
            return false;
        return isSameTree(p.left,q.left)&&isSameTree(p.right,q.right);
    }





}
