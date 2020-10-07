import java.util.Stack;

public class LeetCode430 {
    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    }


    public Node flatten1(Node head) {
        if (head == null) {
            return null;
        }
        Stack<Node> stack = new Stack<>();
        Node cur = head;
        while(true){
            if(cur.child != null){
                if(cur.next != null) {
                    stack.push(cur.next);
                }
                cur.next = cur.child;
                cur.child.prev = cur;
                cur.child = null;
            }
            if(cur.next != null){
                cur = cur.next;
            }
            else if(!stack.isEmpty()){
                Node next = stack.pop();
                cur.next = next;
                next.prev = cur;
                cur = next;
            }
            else
                return head;
        }
    }

    public Node flatten2(Node head){
        if(head == null){
            return null;
        }
        Node cur = head;
        while(cur != null){
            if(cur.child != null){
                Node next = cur.next;
                Node child = flatten2(cur.child);
                cur.next = child;
                child.prev = cur;
                cur.child = null;
                if(next != null){
                    while(cur.next != null){
                        cur = cur.next;
                    }
                    cur.next = next;
                    next.prev = cur;
                }
            }
            cur = cur.next;
        }
        return head;
    }



}
