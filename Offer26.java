public class Offer26 {
    public class BinaryTreeNode{
        double val;
        BinaryTreeNode left;
        BinaryTreeNode right;
    }

    public boolean hasSubtree(BinaryTreeNode root1, BinaryTreeNode root2){
        boolean result = false;
        if(root1 != null && root2 != null) {
            if (Double.valueOf(root1.val).equals(root2.val)) {
                result = doesTree1HaveTree2(root1, root2);
            }
            if (!result) {
                result = hasSubtree(root1.left, root2);
            }
            if (!result) {
                result = hasSubtree(root1.right, root2);
            }
        }

        return result;
    }

    private boolean doesTree1HaveTree2(BinaryTreeNode root1, BinaryTreeNode root2){
        if(root2 == null){
            return true;
        }

        if(root1 == null){
            return false;
        }

        if(!Double.valueOf(root1.val).equals(root2)){
            return false;
        }

        return doesTree1HaveTree2(root1.left, root2.left) && doesTree1HaveTree2(root1.right, root2.right);
    }


}
