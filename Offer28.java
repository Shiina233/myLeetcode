public class Offer28 {
    public class BinaryTreeNode{
        double val;
        BinaryTreeNode left;
        BinaryTreeNode right;
    }

    public boolean isSymmetrical(BinaryTreeNode root){
        return isSymmetrical(root, root);
    }

    private boolean isSymmetrical(BinaryTreeNode root1, BinaryTreeNode root2){
        if(root1 == null && root2 == null){
            return true;
        }
        if(root1 == null || root2 == null){
            return false;
        }

        if(root1.val != root2.val){
            return false;
        }

        return isSymmetrical(root1.left, root2.right) && isSymmetrical(root1.right, root2.left);
    }
}
