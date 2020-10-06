public class Offer24 {
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

    public static ListNode reverseList1(ListNode head){
        if(head == null)
            return null;
        else if(head.next == null)
            return head;
        ListNode before = null;
        ListNode after = null;
        ListNode p = head;
        while(true){
            if(p.next == null){
                p.next = before;
                break;
            }
            after = p.next;
            p.next = before;
            before = p;
            p = after;
        }
        return p;
    }

    public static ListNode reverseList2(ListNode head){
        return reverseList2Core(null,head);
    }

    private static ListNode reverseList2Core(ListNode pBefore, ListNode p){
        if(p == null){
            return null;
        }
        else if(p.next == null){
            p.next = pBefore;
            return p;
        }
        ListNode after = p.next;
        p.next = pBefore;
        pBefore = p;
        p = after;
        return reverseList2Core(pBefore, p);
    }



    public static void main(String[] args){
        ListNode p1 = new ListNode(1);
        ListNode p2 = new ListNode(2);
        ListNode p3 = new ListNode(3);
        p1.next = p2;
        p2.next = p3;
        ListNode newHead = reverseList2(p1);
        while(newHead != null){
            System.out.println(newHead.val);
            newHead = newHead.next;
        }
    }
}
