
/*给定一个二叉树，检查它是否是镜像对称的。
 */


import java.util.LinkedList;
import java.util.Queue;

public class leetCode101 {
    public class TreeNode
    {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x)
        {
            val = x;
        }
    }


    //利用递归实现，首先分析题目，镜像对称，也就是要不断比较处于对称位的两个，因此递归方法应该有两个节点参数
    //分别存放处于对称位的两个节点，当两个节点都为空时，是对称的，当一个节点为空或者二者数值不等时，是非对称的
    //最后，递归其下的两对对称节点，当两对都对称时，才对称。
    public boolean isSy(TreeNode root)
    {
        if(root == null)
            return true;
        else return cmp(root.left,root.right);
    }

    private boolean cmp(TreeNode left, TreeNode right)
    {
        if(left == null && right == null)
            return true;
        else if(left == null || right == null || left.val != right.val)
            return false;
        return cmp(left.left,right.right) && cmp(left.right, right.left);
    }





    //与递归相同，应该不断比较两个对称节点是否对称，考虑用循环
    //循环必须列出所有的对称点，考虑用链表存储对称节点，一次只能比两个，所以使用队列
    //
    public boolean isSyByIterator(TreeNode root)
    {
        if(root == null)
            return true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root.left);
        queue.offer(root.right);
        while(!queue.isEmpty())
        {
            TreeNode node1 = queue.poll();
            TreeNode node2 = queue.poll();
            if(node1 == null && node2 == null)
                continue;
            if(node1 == null || node2 == null || node1.val!= node2.val)
                return false;
            queue.offer(node1.left);
            queue.offer(node2.right);
            queue.offer(node1.right);
            queue.offer(node2.left);
        }
        return true;
    }
}
