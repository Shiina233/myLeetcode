import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Offer32 {
    public class Node{
        int val;
        Node left;
        Node right;
    }
    public void printTree1(Node root){
        if(root == null){
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            Node p = queue.poll();
            System.out.println(p.val);
            if(p.left != null){
                queue.add(p.left);
            }
            if(p.right != null){
                queue.add(p);
            }
        }
    }

    public void printTree2(Node root){
        if(root == null){
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        int nextLevel = 0;
        int toBePrinted = 1;
        queue.add(root);
        while(!queue.isEmpty()){
            Node p = queue.poll();
            System.out.print(p.val);
            toBePrinted--;
            if(p.left != null){
                queue.add(p.left);
                nextLevel++;
            }
            if(p.right != null){
                queue.add(p.right);
                nextLevel++;
            }
            if(toBePrinted == 0){
                System.out.println("");
                toBePrinted = nextLevel;
                nextLevel = 0;
            }

        }
    }

    public void printTree3(Node root){
        int current = 0;
        int next = 1;
        Stack<Node>[] stack = new Stack[2];
        stack[current].push(root);
        while(!stack[0].isEmpty() || !stack[1].isEmpty()){
            Node p = stack[current].pop();
            System.out.print(p.val);

            if(current == 0){
                if(p.left != null){
                    stack[next].push(p.left);
                }
                if(p.right != null){
                    stack[next].push(p.right);
                }
            }
            else{
                if(p.right != null){
                    stack[next].push(p.right);
                }
                if(p.left != null){
                    stack[next].push(p.left);
                }
            }
            if(stack[current].isEmpty()){
                System.out.println("");
                current = 1 - current;
                next = 1 - next;
            }
        }
    }
}
