import org.junit.Test;

import java.util.ArrayList;

public class Offer37 {
    public class Node{
        int val;
        Node left;
        Node right;

        public Node(int val){
            this.val = val;
            this.left = null;
            this.right = null;
        }

        public Node(){

        }
    }

    public void serialize(Node root){
        if(root == null){
            return;
        }

        ArrayList res = new ArrayList();
        serialize(root, res);
        for(int i = 0; i < res.size(); i++){
            System.out.print(res.get(i));
        }
    }

    private void serialize(Node root, ArrayList res){
        if(root == null){
            res.add('$');
            res.add(',');
            return;
        }
        res.add(root.val);
        res.add(',');
        serialize(root.left, res);
        serialize(root.right, res);
    }


}
