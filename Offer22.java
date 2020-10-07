import org.junit.Test;

public class Offer22 {
    public static class ListNode{
        int val;
        ListNode next;

        public ListNode(){
            this(0);
        }

        public ListNode(int val){
            this.val = val;
            next = null;
        }
    }

    public static ListNode findKToTail(ListNode head, int k){
        if(head == null || k <= 0)
            return null;
        ListNode p1 = head;
        ListNode p2 = head;
        for(int i = 1; i < k; i++){
            if(p2.next != null)
                p2 = p2.next;
            else {
                System.out.println("linkedList.length < k");
                return null;
            }
        }
        while(true){
            if(p2.next != null){
                p1 = p1.next;
                p2 = p2.next;
            }
            else{
                break;}
        }
        return p1;
    }

    @Test
    public void offer22Test(){
        ListNode p1 = new ListNode(1);
        ListNode p2 = new ListNode(2);
        ListNode p3 = new ListNode(3);
        ListNode p4 = new ListNode(4);
        ListNode p5 = new ListNode(5);
        p1.next = p2;
        p2.next = p3;
        p3.next = p4;
        p4.next = p5;
        ListNode test = null;
        ListNode res = findKToTail(p1,5);
        if(res == null)
            System.out.println("null");
        else
            System.out.println(res.val);
    }
}
