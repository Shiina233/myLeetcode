package LeetCode;

/*
将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。

本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 */
public class leetCode108 {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

  //要得到平衡的书，就需要先插入中间的值，考虑共有N个数
    //先插入中间的数作为根节点，再插左边的数，其左节点也取左边的中间
    //构造函数，传递其左右索引,每次递归索引变化，直到不符合
  public TreeNode AVLtree(int[] nums)
  {
      return deal(nums,0,nums.length-1);

  }

  private TreeNode deal(int[] nums,int leftIndex,int rightIndex)
  {
      if(leftIndex > rightIndex)
          return null;
      int i=leftIndex+(rightIndex-leftIndex)/2;
      TreeNode t = new TreeNode(nums[i]);
      t.left = deal(nums,leftIndex,i-1);
      t.right = deal(nums,i+1,rightIndex);
      return t;
  }



}
