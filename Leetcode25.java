import org.junit.Test;

public class Leetcode25 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null){
            return null;
        }
        if(k == 1){
            return head;
        }
        ListNode prev = null;
        ListNode cur = head;
        ListNode next = null;
        ListNode checkNode = head;
        int check = 0;
        int count = 0;
        while(check < k && checkNode != null){
            checkNode = checkNode.next;
            check++;
        }

        if(check == k){
            while(count < k ){
                next = cur.next;
                cur.next = prev;
                prev = cur;
                cur = next;
            }
            if(next != null){
                head.next = reverseKGroup(next,k);
            }

            return prev;

        }
        else{
            return head;
        }
    }


}
