public class LeetCode61 {
    public static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

    public static ListNode rotateRight(ListNode head, int k) {
        if(head == null){
            return null;
        }
        if(k < 0){
            throw new IllegalArgumentException("k < 0, this is illegal");
        }
        int count = 1;
        ListNode p1 = head;
        while(true){
            if(p1.next == null){
                p1.next = head;
                break;
            }
            p1 = p1.next;
            count++;
        }

        k = count - (k % count) - 1;
        p1 = head;
        for(int i = 0; i < k; i++){
            p1 = p1.next;
        }
        ListNode tmp = p1.next;
        p1.next = null;
        return tmp;
    }

    public static void main(String[] args){
        ListNode p1 = new ListNode(1);
        ListNode p2 = new ListNode(2);
        ListNode p3 = new ListNode(3);
        p1.next = p2;
        p2.next = p3;
        ListNode newHead;
        newHead = rotateRight(p1,2);
        while(newHead != null){
            System.out.println(newHead.val);
            newHead = newHead.next;
        }
    }

}
