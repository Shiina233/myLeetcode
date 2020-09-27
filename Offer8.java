public class Offer8 {
    public static class Node{
        int val;
        Node parent;
        Node left;
        Node right;
        public Node(int x){
            x = val;
            parent = null;
            left = null;
            right = null;
        }
    }

    public static Node nextNode(Node x){
        if(x == null){
            return null;
        }
        if(x.right != null){
            return x.right;
        }
        else{
            if(x.parent == null){
                return null;
            }
            if(x.parent.left == x){
                return x.parent;
            }
            else{
                while(x.parent.left != x){
                    if(x.parent == null){
                        return null;
                    }
                    x = x.parent;
                }
                for(;;){
                    if(x.parent == null){
                        return null;
                    }
                    if(x.parent.left != x){
                        x=x.parent;
                    }
                    else{
                        return x;
                    }
                }
            }
        }
    }

    public static void main(String[] args){
        Node a = new Node(1);
        System.out.println(nextNode(a));
    }
}

