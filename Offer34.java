import java.util.Stack;

public class Offer34 {
    public class Node{
        int val;
        Node left;
        Node right;
    }
    public void findPath(Node root, int sum){
        if(root == null){
            return;
        }
        int currentSum = 0;
        Stack path = new Stack();
        findPath(root,sum,path,currentSum);
    }

    private void findPath(Node root, int sum, Stack path, int currentSum){
        currentSum += root.val;
        path.push(root.val);
        boolean isLeaf = root.left == null && root.right == null;
        if(currentSum == sum && isLeaf){
            System.out.println("a path is found");
            Integer[] array = (Integer[])path.toArray();
            for(int i = 0; array[i] != null; i++){
                System.out.print(+array[i].intValue()+" ");
            }
        }

        if(root.left != null){
            findPath(root.left,sum,path,currentSum);
        }
        if(root.right != null){
            findPath(root,sum,path,currentSum);
        }
        path.pop();
    }
}
