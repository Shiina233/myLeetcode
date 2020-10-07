import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode86 {
    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }


    @Deprecated
    public ListNode partition1(ListNode head, int x){
        if(head == null){
            return null;
        }
        Queue<ListNode> bigX = new LinkedList<>();
        Queue<ListNode> smallX = new LinkedList<>();
        ListNode newHead;
        ListNode p = head;
        while(p != null){
            if(p.val < x){
                smallX.offer(p);
                p = p.next;
            }
            else{
                bigX.offer(p);
                p = p.next;
            }
        }
        if(!smallX.isEmpty()) {
            newHead = smallX.poll();
        }
        else{
            newHead = bigX.poll();
        }
        p = newHead;
        while(true){
            if(!smallX.isEmpty()){
                p.next = smallX.poll();
                p = p.next;
            }
            else{
                break;
            }
        }
        while(true){
            if(!bigX.isEmpty()){
                p.next = bigX.poll();
                p = p.next;
            }
            else{
                break;
            }
        }
        p.next = null;
        return newHead;
    }

    public ListNode partition2(ListNode head, int x){
        if(head == null){
            return null;
        }
        ListNode newHead1 = new ListNode(0);
        ListNode newHead2 = new ListNode(0);
        ListNode p = head;
        ListNode p1 = newHead1;
        ListNode p2 = newHead2;
        while(p != null){
            if(p.val < x){
                p1.next = p;
                p1 = p1.next;
                p = p.next;
            }
            else{
                p2.next = p;
                p2 = p2.next;
                p = p.next;
            }
        }
        p1.next = newHead2.next;
        p2.next = null;
        return newHead1.next;

    }
    @Test
    public void test(){
        ListNode p1 = new ListNode(1);
        ListNode p2 = new ListNode(7);
        ListNode p3 = new ListNode(2);
        ListNode p4 = new ListNode(4);
        ListNode p5 = new ListNode(5);
        p1.next = p2;
        p2.next = p3;
        p3.next = p4;
        p4.next = p5;
        ListNode test = partition2(p1,3);
    }
}
