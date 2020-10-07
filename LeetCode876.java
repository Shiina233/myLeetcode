public class LeetCode876 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode middleNode(ListNode head){
        if(head == null){
            return null;
        }
        ListNode p1 = head;
        ListNode p2 = head;
        while(p2.next != null){
            p1 = p1.next;
            p2 = p2.next;
            if(p2.next != null){
                p2 = p2.next;
            }
            else{
                break;
            }
        }
        return p1;
    }
}
