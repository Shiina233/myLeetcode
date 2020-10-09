public class LeetCode141 {
    class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }

    public boolean hasCycle(ListNode head){
        ListNode p1 = head;
        ListNode p2 = head;
        while(true){
            if(p2 != null){
                p1 = p1.next;
                p2 = p2.next;
            }
            if(p2 != null){
                p2 = p2.next;
            }
            else{
                return false;
            }
            if(p1 == p2){
                return true;
            }
        }
    }
}
