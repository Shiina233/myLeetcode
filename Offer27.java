public class Offer27 {
    public class BinaryTreeNode{
        double val;
        BinaryTreeNode left;
        BinaryTreeNode right;
    }

    public void mirrorTree(BinaryTreeNode root){
        if(root == null){
            return;
        }
        if(root.left == null && root.right == null){
            return;
        }

        BinaryTreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        if(root.left != null){
            mirrorTree(root.left);
        }
        if(root.right != null) {
            mirrorTree(root.right);
        }
    }
}
